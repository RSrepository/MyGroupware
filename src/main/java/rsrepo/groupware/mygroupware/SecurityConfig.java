package rsrepo.groupware.mygroupware;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import rsrepo.groupware.mygroupware.simpleresponse.*;

// セキュリティ設定用クラス
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // データソース
    @Autowired
    private DataSource dataSource;
    // ユーザー名とパスワードを取得するSQL文
    private static final String USER_SQL = "SELECT name, password, true FROM user WHERE name = ?";
    private static final String ROLE_SQL = "SELECT name, role FROM user WHERE name = ?";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // APIの認可の設定
                .authorizeRequests().mvcMatchers("/login", "/user/insert").permitAll().mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                // 認証、認可の例外処理
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .accessDeniedHandler(accessDeniedHandler()).and()
                // 認証と成功・失敗時の処理
                .formLogin().loginProcessingUrl("/login").permitAll().usernameParameter("name")
                .passwordParameter("password").successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler()).and()
                // ログアウト時の処理
                .logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler()).and()
                // CSRF
                .csrf()
                // .ignoringAntMatchers("/login")
                .csrfTokenRepository(new CookieCsrfTokenRepository());
    }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth,
    // @Qualifier("simpleUserDetailsService") UserDetailsService userDetailsService,
    // PasswordEncoder passwordEncoder) throws Exception {
    // auth.eraseCredentials(true).userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    // }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // ログイン処理時のユーザー情報を、DBから取得する
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(USER_SQL)
                .authoritiesByUsernameQuery(ROLE_SQL).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 未認証のユーザーが認証の必要なAPIにアクセスしたとき
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new SimpleAuthenticationEntryPoint();
    }

    // ユーザーは認証済みだが未認可のリソースへアクセスしたとき
    AccessDeniedHandler accessDeniedHandler() {
        return new SimpleAccessDeniedHandler();
    }

    // 認証が成功した時
    AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SimpleAuthenticationSuccessHandler();
    }

    // 認証が失敗した時
    AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleAuthenticationFailureHandler();
    }

    // ログアウトが正常終了した時
    LogoutSuccessHandler logoutSuccessHandler() {
        return new HttpStatusReturningLogoutSuccessHandler();
    }
}
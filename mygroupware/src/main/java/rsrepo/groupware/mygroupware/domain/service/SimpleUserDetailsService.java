// package rsrepo.groupware.mygroupware.domain.service;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.stereotype.Service;

// import rsrepo.groupware.mygroupware.domain.repository.UserMapper;

// @Service("simpleUserDetailsService")
// public class SimpleUserDetailsService implements UserDetailsService {

//     private final UserMapper userMapper;

//     public SimpleUserDetailsService(UserMapper userMapper) {
//         this.userMapper = userMapper;
//     }

//     @Override
//     public UserDetails loadUserByUsername(final String name) {
//         // emailでデータベースからユーザーエンティティを検索する
//         return userRepository.findByEmail(name)
//                 .map(SimpleLoginUser::new)
//                 .orElseThrow(() -> new UsernameNotFoundException("user not found"));
//     }
// }
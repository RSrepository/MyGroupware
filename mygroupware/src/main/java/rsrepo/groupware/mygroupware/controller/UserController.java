package rsrepo.groupware.mygroupware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import rsrepo.groupware.mygroupware.domain.model.SignupForm;
import rsrepo.groupware.mygroupware.domain.model.User;
import rsrepo.groupware.mygroupware.domain.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService service;

    // ログイン画面のGET用コントローラー
    @GetMapping("/login")
    public String getLogin(Model model) {
        // login.htmlに画面遷移
        return "login";
    }

    // ログイン画面のPOST用コントローラー.
    @PostMapping("/login")
    public String postLogin(Model model) {
        // ホーム画面に遷移
        return "home";
    }

    // ユーザー登録画面のGET用コントローラー
    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model) {
        // signup.htmlに画面遷移
        return "signup";
    }

        // ユーザー登録画面のGET用コントローラー
        @PostMapping("/signup")
        public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult,
                Model model) {
            // 入力チェックに引っかかった場合、ユーザー登録画面に戻る
            if (bindingResult.hasErrors()) {
                // GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻る
                return getSignUp(form, model);
            }
            // login.htmlにリダイレクト
            return "redirect:/login";
        }

    // ユーザー全件取得
    @GetMapping("/user/get")
    @ResponseBody
    public List<User> getUserMany() {
        // ユーザー全件取得
        return service.selectMany();
    }

    // ユーザー1件取得
    @GetMapping("/user/get/{id}")
    @ResponseBody
    public User getUserOne(@PathVariable("id") String userId) {
        // ユーザー1件取得
        return service.selectOne(userId);
    }

    // ユーザーを1件登録
    @PostMapping("/user/insert")
    @ResponseBody
    public String putUserOne(@RequestBody User user) {
        boolean result = service.insert(user);
        String str = "";
        if (result) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        // 結果用の文字列をリターン
        return str;
    }

    // ユーザーを1件更新
    @PutMapping("/user/update")
    @ResponseBody
    public String postUserOne(@RequestBody User user) {
        boolean result = service.update(user);
        String str = "";
        if (result) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        // 結果用の文字列をリターン
        return str;
    }

    // ユーザーを1件削除
    @DeleteMapping("/user/delete/{id:.+}")
    @ResponseBody
    public String deleteUserOne(@PathVariable("id") String userId) {
        boolean result = service.delete(userId);
        String str = "";
        if (result) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        // 結果用の文字列をリターン
        return str;
    }
}
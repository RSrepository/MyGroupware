package rsrepo.groupware.mygroupware.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    // ログイン画面のGET用コントローラー
    @GetMapping("/login")
    public String getLogin(Model model) {
        // HelloWorldを返す
        return "HelloWorld";
    }

    // ログイン画面のPOST用コントローラー.
    // @PostMapping("/login")
    // public String postLogin(Model model) {
    //     // ホーム画面に遷移
    //     return "redirect:/home";
    // }
}
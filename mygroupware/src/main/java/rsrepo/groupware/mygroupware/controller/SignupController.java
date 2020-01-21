package rsrepo.groupware.mygroupware.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rsrepo.groupware.mygroupware.domain.model.User;

@RestController
public class SignupController {
    @PostMapping("/users/insert")
    public String putUserOne(@RequestBody User user) {
        // ユーザーを1件登録
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
}
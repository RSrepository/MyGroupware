package rsrepo.groupware.mygroupware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rsrepo.groupware.mygroupware.domain.model.User;
import rsrepo.groupware.mygroupware.domain.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService service;

    // ユーザー全件取得
    @GetMapping("/user/get")
    public List<User> getUserMany() {
        // ユーザー全件取得
        return service.selectMany();
    }

    // ユーザー1件取得
    @GetMapping("/user/get/{id}")
    public User getUserOne(@PathVariable("id") String userId) {
        // ユーザー1件取得
        return service.selectOne(userId);
    }

    // ユーザーを1件登録
    @PostMapping("/user/insert")
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
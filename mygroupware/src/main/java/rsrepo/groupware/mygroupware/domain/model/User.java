package rsrepo.groupware.mygroupware.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private String id; // ID
    private String name; // ユーザー名
    private String password; // パスワード
    private String role; // ロール
    private Date updated_at; // 更新日時
}
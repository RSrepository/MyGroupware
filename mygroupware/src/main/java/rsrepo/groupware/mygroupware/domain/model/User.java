package rsrepo.groupware.mygroupware.domain.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import rsrepo.groupware.mygroupware.domain.model.ValidGroups.*;

import lombok.Data;

@Data
public class User {
    private String id; // ID
    // ユーザー名
    @NotBlank(groups = ValidGroup1.class)
    @Length(max = 20, groups = ValidGroup2.class)
    private String name; // ユーザー名
    // パスワード
    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 8, max = 20, groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class)
    private String password; // パスワード
    private String role; // ロール
    private Date updated_at; // 更新日時
}
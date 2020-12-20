package rsrepo.groupware.mygroupware.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import rsrepo.groupware.mygroupware.Role;
import rsrepo.groupware.mygroupware.domain.model.ValidGroups.*;

import lombok.Data;

// 新規登録フォーム
@Data
public class SignupForm {
    // ユーザー名
    @NotBlank(groups = ValidGroup1.class)
    @Length(max = 20, groups = ValidGroup2.class)
    private String name;
    // パスワード
    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 8, max = 20, groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class)
    private String password;
    // 権限
    private Role role;
}
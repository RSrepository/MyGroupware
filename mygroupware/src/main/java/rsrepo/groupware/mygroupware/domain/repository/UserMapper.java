package rsrepo.groupware.mygroupware.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import rsrepo.groupware.mygroupware.domain.model.User;

@Mapper
public interface UserMapper {
    // 登録用メソッド
    @Insert("INSERT INTO users ( name, password, role ) VALUES ( #{name}, #{password}, #{role} )")
    public boolean insert(User user);

    // 1件検索用メソッド
    @Select("SELECT id, name, password, role, updated_at FROM users WHERE id = #{id}")
    public User selectOne(String id);

    // 全件検索用メソッド
    @Select("SELECT id, name, password, role, updated_at FROM users")
    public List<User> selectMany();

    // 1件更新用メソッド
    @Update("UPDATE users SET name = #{name}, password = #{password}, role = #{role} WHERE id = #{id}")
    public boolean updateOne(User user);

    // 1件削除用メソッド
    @Delete("DELETE FROM users WHERE id = #{id}")
    public boolean deleteOne(String id);
}
package rsrepo.groupware.mygroupware.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rsrepo.groupware.mygroupware.domain.model.User;
import rsrepo.groupware.mygroupware.domain.repository.UserMapper;

@Transactional
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    // 登録用メソッド
    public boolean insert(User user) {
        return userMapper.insert(user);
    }

    // 1件検索用メソッド
    public User selectOne(String id) {
        return userMapper.selectOne(id);
    }

    // 全件検索用メソッド
    public List<User> selectMany() {
        return userMapper.selectMany();
    }

    // 1件更新用メソッド
    public boolean update(User user) {
        return userMapper.updateOne(user);
    }

    // 1件削除用メソッド
    public boolean delete(String id) {
        return userMapper.deleteOne(id);
    }
}
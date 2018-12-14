package io.renren.modules.service.user;

import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.modules.mapper.UserMapper;
import io.renren.modules.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return password.equals(user.getPassword());
    }
}

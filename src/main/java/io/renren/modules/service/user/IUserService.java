package io.renren.modules.service.user;

import io.renren.common.base.service.IBaseService;
import io.renren.modules.model.User;

public interface IUserService extends IBaseService<User> {
    boolean checkPassword(User user, String password);
}

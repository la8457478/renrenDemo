package io.renren.modules.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.base.controller.BaseController;
import io.renren.common.utils.Constant;
import io.renren.common.utils.Result;
import io.renren.common.utils.ResultUtil;
import io.renren.modules.model.User;
import io.renren.modules.service.user.IUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"mgt/user"})
public class MgtUserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * 所有用户列表
     */
    @ApiOperation(value = "用户列表", notes = "参数为JSON数据对象")
    @PostMapping("/list")
//    @RequiresPermissions("mgt:user:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //只有超级管理员，才能查看所有管理员列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }
        PageHelper.startPage(params);
        List<User> userList = userService.selectAll();
        return ResultUtil.returnQuery(new PageInfo<User>(userList));
    }

}

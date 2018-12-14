package io.renren.modules.controller.user;

import com.alibaba.druid.util.StringUtils;
import io.renren.common.utils.Result;
import io.renren.common.utils.ResultUtil;
import io.renren.modules.model.User;
import io.renren.modules.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin
@RequestMapping(value = {"/api/user/"})
@Api(tags = "APP用户相关接口")
public class ApiUserController {

    @Autowired
    private IUserService service;
//    @Autowired
//    private IUserRoleMiddleService userRoleMiddleService;
//    @Autowired
//    private IProjectService projectService;
//    @Autowired
//    private IScoreResultService scoreResultService;
//    Passworde passwordEncoder = PasswordEncoderFactory.getPasswordEncode("MD5");

    @ApiOperation(value = "app登录", nickname = "loginApp", notes = "Model说明为主，返回Json三级以上关系可忽略,数据以实际调用返回为准")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<User> loginApp(@Valid @NotNull @RequestParam String username, @RequestParam @Valid @NotNull String password) {
//        PasswordEncoder passwordEncoder = PasswordEncoderFactory.getPasswordEncode("MD5");
        User user = new User();
        user.setUsername(username);
        user = service.selectOne(user);
        if (null == user) {
            return ResultUtil.returnFail("用户名或密码错误");
        } else if (!StringUtils.isEmpty(password) && service.checkPassword(user, password)) {
//            ScoreResult scoreResult = ScoreResult.builder().user(user).month(Constants.getLocalYM()).build();
//            scoreResult = scoreResultService.findOne(Example.of(scoreResult));
//            user.setScoreResult(scoreResult);
            return ResultUtil.returnSuccess("登陆成功", user);
        } else {
            return ResultUtil.returnFail("用户名或密码错误");
        }
    }

//    @ApiOperation(value = "app登录（电话）", nickname = "loginApp", notes = "Model说明为主，返回Json三级以上关系可忽略,数据以实际调用返回为准")
//    @RequestMapping(value = "/loginByPhoneNo", method = RequestMethod.POST)
//    public Result<User> loginByPhoneNo(@Valid @NotNull @RequestParam String phoneNo, @RequestParam @Valid @NotNull String password) {
////        PasswordEncoder passwordEncoder = PasswordEncoderFactory.getPasswordEncode("MD5");
//        List<User> users = service.queryToList("phoneNumber", phoneNo);
//        Result result = new Result();
//        if (users.isEmpty()) {
//            result.setSuccess(false);
//            result.setResult("电话或密码错误");
//        } else if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(password) && service.checkPassword(users.get(0), password)) {
//            result.setResult("成功");
//            result.setSuccess(true);
//            users.get(0).setTokenId(users.get(0).getId());
//            result.setData(users.get(0));
//        } else {
//            result.setSuccess(false);
//            result.setResult("电话或密码错误");
//        }
//        return result;
//    }
//
//    @ApiOperation(value = "修改密码", notes = "Model说明为主，返回Json三级以上关系可忽略,数据以实际调用返回为准", nickname = "modify", response = Boolean.class)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "string", paramType = "query"),
//            @ApiImplicitParam(name = "oldPassword", value = "旧密码", dataType = "string", paramType = "query"),
//            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "string", paramType = "query")
//    })
//    @RequestMapping(value = "/modify", method = RequestMethod.POST)
//    public Result<User> modify(@Valid @NotNull(message = "请传用户Id") String userId, @Valid @NotNull(message = "请传旧密码") String oldPassword, @Valid @NotNull(message = "请传新密码") String newPassword) {
//        User user = service.getOne(userId);
//        Result result = new Result();
//        if (service.checkPassword(user, oldPassword)) {
////        if (oldPassword.equals(user.getPassword())) {
//
//            String encodedPwd = passwordEncoder.encode(newPassword);
//            user.setPassword("{MD5}" + encodedPwd);
////            user.setPassword(newPassword);
//            service.save(user);
//            result.setSuccess(true);
//            result.setResult("成功");
//        } else {
//            result.setSuccess(false);
//            result.setResult("失败");
//        }
//        return result;
//
//    }

    @ApiOperation(value = "加载用户信息", nickname = "loadUserInfo", notes = "user", response = User.class)
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Result loadUserInfo(@PathVariable(name = "id") Long id) {
        Result result = new Result();

        User user = service.selectOne(User.builder().id(id).build());
        return null != user ? ResultUtil.returnSuccess("加载成功", user) : ResultUtil.returnFail("未找到用户信息");
    }

    @ApiOperation(value = "用户列表", nickname = "findUsersByProject", notes = "user", response = User.class)
    @RequestMapping(value = "/findUsersByProject/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Result findUsersByProject(@PathVariable(name = "id") Long id) {
//        Project project = projectService.findOne(id);
//        Map map = new HashMap();
//        map.put("company.city", project.getCity());
//        List<User> users = service.queryToList(map, new PageableRequest());
        return ResultUtil.returnSuccess("查询成功", null);
    }
}
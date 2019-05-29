package io.renren.service;

import com.github.pagehelper.PageInfo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.RedisUtils;
import io.renren.modules.mapper.sys.SysConfigMapper;
import io.renren.modules.service.SysConfigService;
import io.renren.modules.service.SysMenuService;
import io.renren.modules.sys.controller.SysMenuController;
import io.renren.modules.sys.entity.SysConfigEntity;
import io.renren.modules.sys.entity.SysMenuEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TkControllerTest {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysMenuController sysMenuController;

    @Test
    public void test() {
        List<SysMenuEntity> s = sysMenuController.list();
        Assert.assertNotNull(s);
    }

}
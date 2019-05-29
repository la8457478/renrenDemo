package io.renren.service;

import org.apache.commons.lang.builder.ToStringBuilder;
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
import io.renren.modules.sys.entity.SysConfigEntity;
import io.renren.modules.sys.entity.SysMenuEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TkMapperTest {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysConfigService sysConfigService;

    @Test
    public void test() {
        List<SysConfigEntity> sysConfigEntityList = sysConfigMapper.selectAll();
        Assert.assertNotNull(sysConfigEntityList);
        Assert.assertTrue(sysConfigEntityList.size() > 0);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        sysConfigEntityList = sysConfigService.queryByParams(map);
        Assert.assertNotNull(sysConfigEntityList);
        Assert.assertTrue(sysConfigEntityList.size() > 0);

        Map<String, Object> params = new HashMap<>();
        params.put("type", 1);
        params.put("orderNum_ge", 2);
        List<SysMenuEntity> sysMenuEntities = sysMenuService.queryByParams(params);
        Assert.assertNotNull(sysMenuEntities);
        Assert.assertTrue(sysMenuEntities.size() > 1);
        //        Assert.assertTrue(sysMenuEntities.get(0).getIcon().equalsIgnoreCase("sql"));

        Map<String, Object> params2 = new HashMap<>();
        params2.put("perms_like:", "sys");
        params2.put("type_eq", 1);
        List<SysMenuEntity> sysMenuEntities2 = sysMenuService.queryByParams(params2);
        Assert.assertNotNull(sysMenuEntities2);
        Assert.assertTrue(sysMenuEntities2.size() > 1);
        //        Assert.assertTrue(sysMenuEntities2.get(0).getIcon().equalsIgnoreCase("sql"));

    }

}
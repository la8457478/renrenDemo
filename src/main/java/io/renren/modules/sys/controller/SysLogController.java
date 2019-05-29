/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.renren.modules.sys.controller;

import com.github.pagehelper.PageInfo;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.service.SysLogService;
import io.renren.modules.sys.entity.SysConfigEntity;
import io.renren.modules.sys.entity.SysLogEntity;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * 系统日志
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-08 10:40:56
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("sys:log:list")
    public R list(@RequestParam Map<String, Object> params) {
        String paramKey = (String) params.get("paramKey");
        Example example =
            new Example.Builder(SysLogEntity.class).where(WeekendSqls.<SysConfigEntity>custom().andEqualTo(SysConfigEntity::getParamKey, paramKey).andEqualTo(SysConfigEntity::getStatus, 1)).build();
        List<SysLogEntity> sysConfigEntitys = sysLogService.getByExample(example);
        PageInfo page
            = new PageInfo<>(sysConfigEntitys);
        return R.ok().put("page", page);

    }

}

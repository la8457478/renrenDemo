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

package io.renren.modules.service.impl;

import com.google.gson.Gson;


import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.common.exception.RRException;
import io.renren.modules.mapper.sys.SysConfigMapper;
import io.renren.modules.sys.entity.SysConfigEntity;
import io.renren.modules.sys.redis.SysConfigRedis;
import io.renren.modules.service.SysConfigService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("sysConfigService")
public class SysConfigServiceImpl extends BaseService<SysConfigEntity> implements SysConfigService {
    @Autowired
    private SysConfigRedis sysConfigRedis;
    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Override
    public CommonMapper<SysConfigEntity> getMapper() {
        return sysConfigMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] ids) {
        for (Long id : ids) {
            SysConfigEntity config = sysConfigMapper.selectByPrimaryKey(id);
            sysConfigRedis.delete(config.getParamKey());
        }
        this.deleteByIds(StringUtils.join(ids));
    }

    @Override
    public String getValue(String key) {
        SysConfigEntity config = sysConfigRedis.get(key);
        if (config == null) {
            config = sysConfigMapper.selectByPrimaryKey(key);
            sysConfigRedis.saveOrUpdate(config);
        }
        return config == null ? null : config.getParamValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RRException("获取参数失败");
        }
    }


}

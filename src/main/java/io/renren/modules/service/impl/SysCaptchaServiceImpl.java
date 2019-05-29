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

import com.google.code.kaptcha.Producer;

import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.common.exception.RRException;
import io.renren.common.utils.DateUtils;
import io.renren.modules.mapper.SysCaptchaMapper;
import io.renren.modules.sys.entity.SysCaptchaEntity;
import io.renren.modules.service.SysCaptchaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * 验证码
 * @author Mark sunlightcs@gmail.com
 * @since 2.0.0 2018-02-10
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends BaseService<SysCaptchaEntity> implements SysCaptchaService {
    @Autowired
    private Producer producer;
    @Autowired
    private SysCaptchaMapper entityDao;

    @Override
    public CommonMapper<SysCaptchaEntity> getMapper() {
        return entityDao;
    }

    @Override
    public BufferedImage getCaptcha(Long id) {
        if (null != id) {
            throw new RRException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        SysCaptchaEntity captchaEntity = new SysCaptchaEntity();
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        this.save(captchaEntity);
        return producer.createImage(code);
    }

    @Override
    public boolean validate(Long id, String code) {
        SysCaptchaEntity captchaEntity = this.get(id);
        if (captchaEntity == null) {
            return false;
        }
        //删除验证码
        this.deleteById(id);
        if (captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

}

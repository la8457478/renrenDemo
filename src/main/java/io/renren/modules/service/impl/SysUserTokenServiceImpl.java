package io.renren.modules.service.impl;


import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.common.utils.R;
import io.renren.modules.mapper.sys.SysUserTokenMapper;
import io.renren.modules.sys.entity.SysUserTokenEntity;
import io.renren.modules.service.SysUserTokenService;
import io.renren.modules.sys.oauth2.TokenGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends BaseService<SysUserTokenEntity> implements SysUserTokenService {

	@Autowired
	private SysUserTokenMapper tokenMapper ;

	@Override
	public CommonMapper<SysUserTokenEntity> getMapper() {
		return tokenMapper;
	}

		//12小时后过期
	private final static int EXPIRE = 3600 * 12;


	@Override
	public R createToken(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		SysUserTokenEntity tokenEntity = this.get(userId);
		if(tokenEntity == null){
			tokenEntity = new SysUserTokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			this.save(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			this.update(tokenEntity);
		}

		R r = R.ok().put("token", token).put("expire", EXPIRE);
		return r;
	}

	@Override
	public void logout(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//修改token
		SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		this.update(tokenEntity);
	}
}

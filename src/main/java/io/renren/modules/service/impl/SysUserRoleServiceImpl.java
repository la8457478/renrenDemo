package io.renren.modules.service.impl;


import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.common.utils.MapUtils;
import io.renren.modules.mapper.sys.SysUserRoleMapper;
import io.renren.modules.sys.entity.SysUserRoleEntity;
import io.renren.modules.service.SysUserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:48
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends BaseService<SysUserRoleEntity> implements SysUserRoleService {
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public CommonMapper<SysUserRoleEntity> getMapper() {
		return sysUserRoleMapper;
	}
	@Override
	public int saveOrUpdate(Long userId, List<Long> roleIdList) {
		//先删除用户与角色关系
		this.deleteByParams(new MapUtils().put("userId", userId));

		if(roleIdList == null || roleIdList.size() == 0){
			return 0;
		}

		//保存用户与角色关系
		List<SysUserRoleEntity> list = new ArrayList<>(roleIdList.size());
		for(Long roleId : roleIdList){
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setUserId(userId);
			sysUserRoleEntity.setRoleId(roleId);
			list.add(sysUserRoleEntity);
		}
		return this.save(list);
	}
	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return sysUserRoleMapper.queryRoleIdList(userId);
	}
}

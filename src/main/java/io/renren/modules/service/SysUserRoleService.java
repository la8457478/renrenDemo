package io.renren.modules.service;


import io.renren.common.base.service.IBaseService;
import io.renren.modules.sys.entity.SysUserRoleEntity;

import java.util.List;



/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:24
 */
public interface SysUserRoleService extends IBaseService<SysUserRoleEntity> {

	int saveOrUpdate(Long userId, List<Long> roleIdList);

    List<Long> queryRoleIdList(Long userId);

    //	/**
//	 * 根据用户ID，获取角色ID列表
//	 */
//	List<Long> queryRoleIdList(Long userId);
//
//	/**
//	 * 根据角色ID数组，批量删除
//	 */
//	int deleteBatch(Long[] roleIds);
}

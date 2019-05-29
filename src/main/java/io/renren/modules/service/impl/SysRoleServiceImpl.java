package io.renren.modules.service.impl;


import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.modules.mapper.sys.SysRoleMapper;
import io.renren.modules.sys.entity.SysRoleEntity;
import io.renren.modules.service.SysRoleService;
import io.renren.modules.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseService<SysRoleEntity> implements SysRoleService {
    @Autowired
    private SysRoleMapper mapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public CommonMapper<SysRoleEntity> getMapper() {
        return mapper;
    }

    @Override
    public List<Long> queryRoleIdList(Long createUserId) {
        return mapper.queryRoleIdList(createUserId);
    }


    /**
     * 检查权限是否越权
     */
    private void checkPrems(SysRoleEntity role) {
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (role.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //判断是否越权
        if (!menuIdList.containsAll(role.getMenuIdList())) {
            throw new RRException("新增角色的权限，已超出你的权限范围");
        }
    }


}

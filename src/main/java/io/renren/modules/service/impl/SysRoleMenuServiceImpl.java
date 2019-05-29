package io.renren.modules.service.impl;


import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.modules.mapper.sys.SysRoleMenuMapper;
import io.renren.modules.sys.entity.SysRoleMenuEntity;
import io.renren.modules.service.SysRoleMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 角色与菜单对应关系
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:44:35
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends BaseService<SysRoleMenuEntity> implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuMapper mapper;

    @Override
    public CommonMapper<SysRoleMenuEntity> getMapper() {
        return mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        //先删除角色与菜单关系
        deleteBatch(new Long[] {roleId});

        if (menuIdList.size() == 0) {
            return;
        }

        //保存角色与菜单关系
        List<SysRoleMenuEntity> list = new ArrayList<>(menuIdList.size());
        for (Long menuId : menuIdList) {
            SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
            sysRoleMenuEntity.setMenuId(menuId);
            sysRoleMenuEntity.setRoleId(roleId);

            list.add(sysRoleMenuEntity);
        }
        this.save(list);
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return mapper.queryMenuIdList(roleId);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return mapper.deleteBatch(roleIds);
    }

}

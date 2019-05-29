package io.renren.modules.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.renren.common.base.mapper.CommonMapper;
import io.renren.common.base.service.BaseService;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.modules.mapper.sys.SysUserMapper;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.service.SysRoleService;
import io.renren.modules.service.SysUserRoleService;
import io.renren.modules.service.SysUserService;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseService<SysUserEntity> implements SysUserService {
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public CommonMapper<SysUserEntity> getMapper() {
        return sysUserMapper;
    }


    @Override
    public PageInfo queryPage(Map<String, Object> params) {
        PageHelper.startPage(params);
        List<SysUserEntity> sysUserEntityList = queryByParams(params);
        return new PageInfo(sysUserEntityList);
    }

    @Override
    public List<String> queryAllPerms(Long userId) {
        return sysUserMapper.queryAllPerms(userId);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return sysUserMapper.queryAllMenuId(userId);
    }

    @Override
    public SysUserEntity queryByUserName(String username) {
        return sysUserMapper.queryByUserName(username);
    }

    @Override
    @Transactional
    public int save(SysUserEntity user) {
        user.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
        user.setSalt(salt);
        this.save(user);

        //检查角色是否越权
        checkRole(user);

        //保存用户与角色关系
        return sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    @Transactional
    public int update(SysUserEntity user) {
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        } else {
            user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
        }
        this.update(user);

        //检查角色是否越权
        checkRole(user);

        //保存用户与角色关系
        return sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    public void deleteBatch(Long[] userId) {
        this.deleteByIds(userId);
    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity) > 0;
    }

    /**
     * 检查角色是否越权
     */
    private void checkRole(SysUserEntity user) {
        if (user.getRoleIdList() == null || user.getRoleIdList().size() == 0) {
            return;
        }
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        if (user.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户创建的角色列表
        List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());

        //判断是否越权
        if (!roleIdList.containsAll(user.getRoleIdList())) {
            throw new RRException("新增用户所选角色，不是本人创建");
        }
    }
}

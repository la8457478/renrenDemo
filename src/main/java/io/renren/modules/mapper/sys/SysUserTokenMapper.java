package io.renren.modules.mapper.sys;


import io.renren.common.base.mapper.CommonMapper;
import io.renren.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface SysUserTokenMapper extends CommonMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);
	
}

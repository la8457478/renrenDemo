package io.renren.modules.sys.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;


/**
 * 系统用户Token
 */
@Table(name = "sys_user_token")
@Data
public class SysUserTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    @Id
    @KeySql(dialect = IdentityDialect.MYSQL)
    private Long userId;
    //token
    private String token;
    //过期时间
    private Date expireTime;
    //更新时间
    private Date updateTime;

}

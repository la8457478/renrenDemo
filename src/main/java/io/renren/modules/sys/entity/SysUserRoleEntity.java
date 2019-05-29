package io.renren.modules.sys.entity;



import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

/**
 * 用户与角色对应关系
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:39
 */
@Table(name = "sys_user_role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @KeySql(dialect = IdentityDialect.MYSQL)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

}

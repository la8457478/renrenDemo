package io.renren.modules.sys.entity;



import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:13
 */
@Table(name="sys_role_menu")
@Data
public class SysRoleMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@KeySql(dialect = IdentityDialect.MYSQL)
	private Long id;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 菜单ID
	 */
	private Long menuId;


}

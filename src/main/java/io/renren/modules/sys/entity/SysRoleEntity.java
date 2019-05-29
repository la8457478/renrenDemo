package io.renren.modules.sys.entity;



import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:27:38
 */
@Table(name = "sys_role")
@Data
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID
	 */
	@Id
	@KeySql(dialect = IdentityDialect.MYSQL)
	private Long roleId;

	/**
	 * 角色名称
	 */
	@NotBlank(message="角色名称不能为空")
	private String roleName;
	/**
	 * 创建者ID
	 */
	private Long createUserId;

	@Transient
	private List<Long> menuIdList;
	/**
	 * 创建时间
	 */
	private Date createTime;

}

package io.renren.modules.sys.entity;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
@Table(name = "sys_user")
@Data
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	@Id
	@KeySql(dialect = IdentityDialect.MYSQL)
	private Long userId;

	/**
	 * 用户名
	 */
	@NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String username;

	/**
	 * 密码
	 */
	@NotBlank(message="密码不能为空", groups = AddGroup.class)
	private String password;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 邮箱
	 */
	@NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
	@Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	
	/**
	 * 角色ID列表
	 */
	@Transient
	private List<Long> roleIdList;
	
	/**
	 * 创建者ID
	 */
	private Long createUserId;

	/**
	 * 创建时间
	 */
	private Date createTime;

}

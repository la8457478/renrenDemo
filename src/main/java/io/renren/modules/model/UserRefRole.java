package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user_ref_role")
public class UserRefRole {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
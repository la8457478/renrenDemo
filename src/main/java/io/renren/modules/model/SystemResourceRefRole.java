package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "system_resource_ref_role")
public class SystemResourceRefRole {
    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name = "role_id")
    private Long roleId;

    /**
     * @return resource_id
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
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
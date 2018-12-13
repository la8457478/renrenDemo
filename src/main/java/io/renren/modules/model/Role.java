package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long cdt;

    private String creator;

    @Column(name = "auto_dock_score")
    private Integer autoDockScore;

    @Column(name = "check_access")
    private Boolean checkAccess;

    private String description;

    @Column(name = "group_dock_score")
    private Integer groupDockScore;

    @Column(name = "handle_access")
    private Boolean handleAccess;

    private String name;

    @Column(name = "query_access")
    private Boolean queryAccess;

    @Column(name = "reform_access")
    private Boolean reformAccess;

    @Column(name = "parent_id")
    private Long parentId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return cdt
     */
    public Long getCdt() {
        return cdt;
    }

    /**
     * @param cdt
     */
    public void setCdt(Long cdt) {
        this.cdt = cdt;
    }

    /**
     * @return creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return auto_dock_score
     */
    public Integer getAutoDockScore() {
        return autoDockScore;
    }

    /**
     * @param autoDockScore
     */
    public void setAutoDockScore(Integer autoDockScore) {
        this.autoDockScore = autoDockScore;
    }

    /**
     * @return check_access
     */
    public Boolean getCheckAccess() {
        return checkAccess;
    }

    /**
     * @param checkAccess
     */
    public void setCheckAccess(Boolean checkAccess) {
        this.checkAccess = checkAccess;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return group_dock_score
     */
    public Integer getGroupDockScore() {
        return groupDockScore;
    }

    /**
     * @param groupDockScore
     */
    public void setGroupDockScore(Integer groupDockScore) {
        this.groupDockScore = groupDockScore;
    }

    /**
     * @return handle_access
     */
    public Boolean getHandleAccess() {
        return handleAccess;
    }

    /**
     * @param handleAccess
     */
    public void setHandleAccess(Boolean handleAccess) {
        this.handleAccess = handleAccess;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return query_access
     */
    public Boolean getQueryAccess() {
        return queryAccess;
    }

    /**
     * @param queryAccess
     */
    public void setQueryAccess(Boolean queryAccess) {
        this.queryAccess = queryAccess;
    }

    /**
     * @return reform_access
     */
    public Boolean getReformAccess() {
        return reformAccess;
    }

    /**
     * @param reformAccess
     */
    public void setReformAccess(Boolean reformAccess) {
        this.reformAccess = reformAccess;
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
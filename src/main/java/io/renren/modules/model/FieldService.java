package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "field_service")
public class FieldService {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "design_no")
    private String designNo;

    @Column(name = "field_desc")
    private String fieldDesc;

    @Column(name = "handle_desc")
    private String handleDesc;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    private String mold;

    private String professional;

    private String theme;

    @Column(name = "project_id")
    private Long projectId;

    private Long user;

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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return design_no
     */
    public String getDesignNo() {
        return designNo;
    }

    /**
     * @param designNo
     */
    public void setDesignNo(String designNo) {
        this.designNo = designNo;
    }

    /**
     * @return field_desc
     */
    public String getFieldDesc() {
        return fieldDesc;
    }

    /**
     * @param fieldDesc
     */
    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    /**
     * @return handle_desc
     */
    public String getHandleDesc() {
        return handleDesc;
    }

    /**
     * @param handleDesc
     */
    public void setHandleDesc(String handleDesc) {
        this.handleDesc = handleDesc;
    }

    /**
     * @return last_update_time
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * @return mold
     */
    public String getMold() {
        return mold;
    }

    /**
     * @param mold
     */
    public void setMold(String mold) {
        this.mold = mold;
    }

    /**
     * @return professional
     */
    public String getProfessional() {
        return professional;
    }

    /**
     * @param professional
     */
    public void setProfessional(String professional) {
        this.professional = professional;
    }

    /**
     * @return theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * @return project_id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * @return user
     */
    public Long getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(Long user) {
        this.user = user;
    }
}
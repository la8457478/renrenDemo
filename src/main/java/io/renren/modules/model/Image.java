package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long cdt;

    private String creator;

    private String desrcription;

    @Column(name = "image_url")
    private String imageUrl;

    private String name;

    @Column(name = "upload_time")
    private String uploadTime;

    @Column(name = "issue_id")
    private Long issueId;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "extra_desc_id")
    private Long extraDescId;

    @Column(name = "field_service_id")
    private Long fieldServiceId;

    private Integer type;

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
     * @return desrcription
     */
    public String getDesrcription() {
        return desrcription;
    }

    /**
     * @param desrcription
     */
    public void setDesrcription(String desrcription) {
        this.desrcription = desrcription;
    }

    /**
     * @return image_url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
     * @return upload_time
     */
    public String getUploadTime() {
        return uploadTime;
    }

    /**
     * @param uploadTime
     */
    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * @return issue_id
     */
    public Long getIssueId() {
        return issueId;
    }

    /**
     * @param issueId
     */
    public void setIssueId(Long issueId) {
        this.issueId = issueId;
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
     * @return extra_desc_id
     */
    public Long getExtraDescId() {
        return extraDescId;
    }

    /**
     * @param extraDescId
     */
    public void setExtraDescId(Long extraDescId) {
        this.extraDescId = extraDescId;
    }

    /**
     * @return field_service_id
     */
    public Long getFieldServiceId() {
        return fieldServiceId;
    }

    /**
     * @param fieldServiceId
     */
    public void setFieldServiceId(Long fieldServiceId) {
        this.fieldServiceId = fieldServiceId;
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }
}
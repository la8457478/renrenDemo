package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "extra_desc")
public class ExtraDesc {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long cdt;

    private String creator;

    private String message;

    @Column(name = "issue_id")
    private Long issueId;

    @Column(name = "create_time")
    private String createTime;

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
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
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
     * @return create_time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
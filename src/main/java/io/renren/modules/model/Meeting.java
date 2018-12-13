package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "complate_time")
    private Date complateTime;

    private String name;

    private Integer state;

    @Column(name = "detailsphase_id")
    private Long detailsphaseId;

    @Column(name = "meet_template_id")
    private Long meetTemplateId;

    private String remark;

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
     * @return complate_time
     */
    public Date getComplateTime() {
        return complateTime;
    }

    /**
     * @param complateTime
     */
    public void setComplateTime(Date complateTime) {
        this.complateTime = complateTime;
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
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return detailsphase_id
     */
    public Long getDetailsphaseId() {
        return detailsphaseId;
    }

    /**
     * @param detailsphaseId
     */
    public void setDetailsphaseId(Long detailsphaseId) {
        this.detailsphaseId = detailsphaseId;
    }

    /**
     * @return meet_template_id
     */
    public Long getMeetTemplateId() {
        return meetTemplateId;
    }

    /**
     * @param meetTemplateId
     */
    public void setMeetTemplateId(Long meetTemplateId) {
        this.meetTemplateId = meetTemplateId;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
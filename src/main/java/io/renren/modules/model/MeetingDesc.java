package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "meeting_desc")
public class MeetingDesc {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "complate_time")
    private String complateTime;

    private String remark;

    @Column(name = "meeting_id")
    private Long meetingId;

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
    public String getComplateTime() {
        return complateTime;
    }

    /**
     * @param complateTime
     */
    public void setComplateTime(String complateTime) {
        this.complateTime = complateTime;
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
     * @return meeting_id
     */
    public Long getMeetingId() {
        return meetingId;
    }

    /**
     * @param meetingId
     */
    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }
}
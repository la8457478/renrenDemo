package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "adjust_time")
public class AdjustTime {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "end_time")
    private String endTime;

    private Integer no;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "detailsphase_id")
    private Long detailsphaseId;

    private String remark;

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
     * @return end_time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return no
     */
    public Integer getNo() {
        return no;
    }

    /**
     * @param no
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * @return start_time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
}
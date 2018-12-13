package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "detailsphase")
public class Detailsphase {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "actualcompletion_time")
    private Date actualcompletionTime;

    @Column(name = "complet_remark")
    private String completRemark;

    @Column(name = "plan_end_date")
    private Date planEndDate;

    @Column(name = "plan_start_date")
    private Date planStartDate;

    private String remark;

    @Column(name = "designphase_id")
    private Long designphaseId;

    @Column(name = "designphase_state_id")
    private Long designphaseStateId;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "user_id")
    private Long userId;

    private Integer terms;

    @Column(name = "operate_state")
    private Integer operateState;

    private Long creator;

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
     * @return actualcompletion_time
     */
    public Date getActualcompletionTime() {
        return actualcompletionTime;
    }

    /**
     * @param actualcompletionTime
     */
    public void setActualcompletionTime(Date actualcompletionTime) {
        this.actualcompletionTime = actualcompletionTime;
    }

    /**
     * @return complet_remark
     */
    public String getCompletRemark() {
        return completRemark;
    }

    /**
     * @param completRemark
     */
    public void setCompletRemark(String completRemark) {
        this.completRemark = completRemark;
    }

    /**
     * @return plan_end_date
     */
    public Date getPlanEndDate() {
        return planEndDate;
    }

    /**
     * @param planEndDate
     */
    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    /**
     * @return plan_start_date
     */
    public Date getPlanStartDate() {
        return planStartDate;
    }

    /**
     * @param planStartDate
     */
    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
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
     * @return designphase_id
     */
    public Long getDesignphaseId() {
        return designphaseId;
    }

    /**
     * @param designphaseId
     */
    public void setDesignphaseId(Long designphaseId) {
        this.designphaseId = designphaseId;
    }

    /**
     * @return designphase_state_id
     */
    public Long getDesignphaseStateId() {
        return designphaseStateId;
    }

    /**
     * @param designphaseStateId
     */
    public void setDesignphaseStateId(Long designphaseStateId) {
        this.designphaseStateId = designphaseStateId;
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
     * @return terms
     */
    public Integer getTerms() {
        return terms;
    }

    /**
     * @param terms
     */
    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    /**
     * @return operate_state
     */
    public Integer getOperateState() {
        return operateState;
    }

    /**
     * @param operateState
     */
    public void setOperateState(Integer operateState) {
        this.operateState = operateState;
    }

    /**
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }
}
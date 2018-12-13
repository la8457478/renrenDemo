package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long cdt;

    private String creator;

    private String area;

    @Column(name = "buidings_no")
    private Integer buidingsNo;

    private String business;

    private String content;

    private String description;

    @Column(name = "finish_improve_time")
    private String finishImproveTime;

    @Column(name = "improve_desc")
    private String improveDesc;

    @Column(name = "is_reduce_score")
    private Boolean isReduceScore;

    private String level;

    private Integer loft;

    private String major;

    @Column(name = "plan_improve_time")
    private String planImproveTime;

    @Column(name = "reduce_score_user")
    private String reduceScoreUser;

    private String source;

    private Integer status;

    private Integer term;

    private Integer unit;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "checkuser_id")
    private Long checkuserId;

    @Column(name = "level_one_problem")
    private String levelOneProblem;

    @Column(name = "level_two_problem")
    private String levelTwoProblem;

    @Column(name = "level_three_problem")
    private String levelThreeProblem;

    @Column(name = "create_time")
    private String createTime;

    private String no;

    @Column(name = "last_cdt")
    private Long lastCdt;

    @Column(name = "dock_type")
    private Integer dockType;

    @Column(name = "improve_remark")
    private String improveRemark;

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
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return buidings_no
     */
    public Integer getBuidingsNo() {
        return buidingsNo;
    }

    /**
     * @param buidingsNo
     */
    public void setBuidingsNo(Integer buidingsNo) {
        this.buidingsNo = buidingsNo;
    }

    /**
     * @return business
     */
    public String getBusiness() {
        return business;
    }

    /**
     * @param business
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
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
     * @return finish_improve_time
     */
    public String getFinishImproveTime() {
        return finishImproveTime;
    }

    /**
     * @param finishImproveTime
     */
    public void setFinishImproveTime(String finishImproveTime) {
        this.finishImproveTime = finishImproveTime;
    }

    /**
     * @return improve_desc
     */
    public String getImproveDesc() {
        return improveDesc;
    }

    /**
     * @param improveDesc
     */
    public void setImproveDesc(String improveDesc) {
        this.improveDesc = improveDesc;
    }

    /**
     * @return is_reduce_score
     */
    public Boolean getIsReduceScore() {
        return isReduceScore;
    }

    /**
     * @param isReduceScore
     */
    public void setIsReduceScore(Boolean isReduceScore) {
        this.isReduceScore = isReduceScore;
    }

    /**
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return loft
     */
    public Integer getLoft() {
        return loft;
    }

    /**
     * @param loft
     */
    public void setLoft(Integer loft) {
        this.loft = loft;
    }

    /**
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return plan_improve_time
     */
    public String getPlanImproveTime() {
        return planImproveTime;
    }

    /**
     * @param planImproveTime
     */
    public void setPlanImproveTime(String planImproveTime) {
        this.planImproveTime = planImproveTime;
    }

    /**
     * @return reduce_score_user
     */
    public String getReduceScoreUser() {
        return reduceScoreUser;
    }

    /**
     * @param reduceScoreUser
     */
    public void setReduceScoreUser(String reduceScoreUser) {
        this.reduceScoreUser = reduceScoreUser;
    }

    /**
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return term
     */
    public Integer getTerm() {
        return term;
    }

    /**
     * @param term
     */
    public void setTerm(Integer term) {
        this.term = term;
    }

    /**
     * @return unit
     */
    public Integer getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(Integer unit) {
        this.unit = unit;
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
     * @return checkuser_id
     */
    public Long getCheckuserId() {
        return checkuserId;
    }

    /**
     * @param checkuserId
     */
    public void setCheckuserId(Long checkuserId) {
        this.checkuserId = checkuserId;
    }

    /**
     * @return level_one_problem
     */
    public String getLevelOneProblem() {
        return levelOneProblem;
    }

    /**
     * @param levelOneProblem
     */
    public void setLevelOneProblem(String levelOneProblem) {
        this.levelOneProblem = levelOneProblem;
    }

    /**
     * @return level_two_problem
     */
    public String getLevelTwoProblem() {
        return levelTwoProblem;
    }

    /**
     * @param levelTwoProblem
     */
    public void setLevelTwoProblem(String levelTwoProblem) {
        this.levelTwoProblem = levelTwoProblem;
    }

    /**
     * @return level_three_problem
     */
    public String getLevelThreeProblem() {
        return levelThreeProblem;
    }

    /**
     * @param levelThreeProblem
     */
    public void setLevelThreeProblem(String levelThreeProblem) {
        this.levelThreeProblem = levelThreeProblem;
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

    /**
     * @return no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * @return last_cdt
     */
    public Long getLastCdt() {
        return lastCdt;
    }

    /**
     * @param lastCdt
     */
    public void setLastCdt(Long lastCdt) {
        this.lastCdt = lastCdt;
    }

    /**
     * @return dock_type
     */
    public Integer getDockType() {
        return dockType;
    }

    /**
     * @param dockType
     */
    public void setDockType(Integer dockType) {
        this.dockType = dockType;
    }

    /**
     * @return improve_remark
     */
    public String getImproveRemark() {
        return improveRemark;
    }

    /**
     * @param improveRemark
     */
    public void setImproveRemark(String improveRemark) {
        this.improveRemark = improveRemark;
    }
}
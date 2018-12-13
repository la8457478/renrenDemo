package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "score_flow")
public class ScoreFlow {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "dock_score")
    private Integer dockScore;

    @Column(name = "dock_time")
    private String dockTime;

    private Integer score;

    private Integer type;

    @Column(name = "issue_id")
    private Long issueId;

    private Long operator;

    private String user;

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
     * @return dock_score
     */
    public Integer getDockScore() {
        return dockScore;
    }

    /**
     * @param dockScore
     */
    public void setDockScore(Integer dockScore) {
        this.dockScore = dockScore;
    }

    /**
     * @return dock_time
     */
    public String getDockTime() {
        return dockTime;
    }

    /**
     * @param dockTime
     */
    public void setDockTime(String dockTime) {
        this.dockTime = dockTime;
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
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
     * @return operator
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }
}
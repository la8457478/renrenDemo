package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "score_result")
public class ScoreResult {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "fact_score")
    private Integer factScore;

    private String month;

    @Column(name = "note_score")
    private Integer noteScore;

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
     * @return fact_score
     */
    public Integer getFactScore() {
        return factScore;
    }

    /**
     * @param factScore
     */
    public void setFactScore(Integer factScore) {
        this.factScore = factScore;
    }

    /**
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return note_score
     */
    public Integer getNoteScore() {
        return noteScore;
    }

    /**
     * @param noteScore
     */
    public void setNoteScore(Integer noteScore) {
        this.noteScore = noteScore;
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
package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "designphase")
public class Designphase {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "modify_time_one_visible")
    private Boolean modifyTimeOneVisible;

    @Column(name = "modify_time_two_visible")
    private Boolean modifyTimeTwoVisible;

    private String name;

    @Column(name = "plan_time_visible")
    private Boolean planTimeVisible;

    @Column(name = "parent_id")
    private Long parentId;

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
     * @return modify_time_one_visible
     */
    public Boolean getModifyTimeOneVisible() {
        return modifyTimeOneVisible;
    }

    /**
     * @param modifyTimeOneVisible
     */
    public void setModifyTimeOneVisible(Boolean modifyTimeOneVisible) {
        this.modifyTimeOneVisible = modifyTimeOneVisible;
    }

    /**
     * @return modify_time_two_visible
     */
    public Boolean getModifyTimeTwoVisible() {
        return modifyTimeTwoVisible;
    }

    /**
     * @param modifyTimeTwoVisible
     */
    public void setModifyTimeTwoVisible(Boolean modifyTimeTwoVisible) {
        this.modifyTimeTwoVisible = modifyTimeTwoVisible;
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
     * @return plan_time_visible
     */
    public Boolean getPlanTimeVisible() {
        return planTimeVisible;
    }

    /**
     * @param planTimeVisible
     */
    public void setPlanTimeVisible(Boolean planTimeVisible) {
        this.planTimeVisible = planTimeVisible;
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
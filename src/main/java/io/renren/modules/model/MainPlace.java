package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "main_place")
public class MainPlace {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String area;

    private String building;

    private String loft;

    private String model;

    private String name;

    private String remark;

    private String term;

    private String type;

    private String unit;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "project_id")
    private Long projectId;

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
     * @return building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * @param building
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * @return loft
     */
    public String getLoft() {
        return loft;
    }

    /**
     * @param loft
     */
    public void setLoft(String loft) {
        this.loft = loft;
    }

    /**
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
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
     * @return term
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
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
}
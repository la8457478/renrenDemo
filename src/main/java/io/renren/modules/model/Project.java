package io.renren.modules.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long cdt;

    private String creator;

    private Integer buildings;

    private String city;

    private String name;

    private String province;

    private Integer terms;

    private Long company;

    private String images;

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
     * @return buildings
     */
    public Integer getBuildings() {
        return buildings;
    }

    /**
     * @param buildings
     */
    public void setBuildings(Integer buildings) {
        this.buildings = buildings;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
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
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
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
     * @return company
     */
    public Long getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(Long company) {
        this.company = company;
    }

    /**
     * @return images
     */
    public String getImages() {
        return images;
    }

    /**
     * @param images
     */
    public void setImages(String images) {
        this.images = images;
    }
}
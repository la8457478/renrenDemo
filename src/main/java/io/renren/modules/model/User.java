package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long cdt;

    private String creator;

    @Column(name = "account_expiring_date")
    private Date accountExpiringDate;

    @Column(name = "credentials_expiring_date")
    private Date credentialsExpiringDate;

    private String email;

    private Boolean locked;

    private String name;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    private Integer score;

    private String username;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "major_id")
    private Long majorId;

    @Column(name = "role_id")
    private Long roleId;

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
     * @return account_expiring_date
     */
    public Date getAccountExpiringDate() {
        return accountExpiringDate;
    }

    /**
     * @param accountExpiringDate
     */
    public void setAccountExpiringDate(Date accountExpiringDate) {
        this.accountExpiringDate = accountExpiringDate;
    }

    /**
     * @return credentials_expiring_date
     */
    public Date getCredentialsExpiringDate() {
        return credentialsExpiringDate;
    }

    /**
     * @param credentialsExpiringDate
     */
    public void setCredentialsExpiringDate(Date credentialsExpiringDate) {
        this.credentialsExpiringDate = credentialsExpiringDate;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return company_id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return major_id
     */
    public Long getMajorId() {
        return majorId;
    }

    /**
     * @param majorId
     */
    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
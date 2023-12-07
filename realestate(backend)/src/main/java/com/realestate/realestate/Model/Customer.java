package com.realestate.realestate.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String id;

    @ManyToOne
//    @JoinColumn(name = "logo_id",referencedColumnName = "id")
    private Logo logo;

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    @ManyToOne
//   @JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyName companyId;
    @Column(name = "type")
    private String type;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "personFirstName")
    private String personFirstName;
    @Column(name = "personLastName")
    private String personLastName;
    @Column(name = "personFirstKana")
    private String personFirstKana;
    @Column(name = "personLastKana")
    private String personLastKana;
    @Column(name = "department")
    private String department;
    @Column(name = "mobileFirst")
    private String mobileFirst;
    @Column(name = "mobileSecond")
    private String mobileSecond;
    @Column(name = "mobileThird")
    private String mobileThird;
    @Column(name = "mailAdd", length = 100)
    private String mailAdd;
    @Column(name = "fax1")
    private String fax1;
    @Column(name = "fax2")
    private String fax2;
    @Column(name = "fax3")
    private String fax3;
    @Column(name = "postalFirst")
    private String postalFirst;
    @Column(name = "postalSecond")
    private String postalSecond;
    @Column(name = "address")
    private String address;

    public String getPersonFullName() {
        return personFullName;
    }

    public void setPersonFullName(String personFullName) {
        this.personFullName = personFullName;
    }

    public String getPersonFullNameKana() {
        return personFullNameKana;
    }

    public void setPersonFullNameKana(String personFullNameKana) {
        this.personFullNameKana = personFullNameKana;
    }

    @Column(name = "remark")
    private String remark;

    @Column(name = "personFullName")
    private String personFullName;

    @Column(name = "personFullNameKana")
    private String personFullNameKana;
    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public CompanyName getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyName companyId) {
        this.companyId = companyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonFirstKana() {
        return personFirstKana;
    }

    public void setPersonFirstKana(String personFirstKana) {
        this.personFirstKana = personFirstKana;
    }

    public String getPersonLastKana() {
        return personLastKana;
    }

    public void setPersonLastKana(String personLastKana) {
        this.personLastKana = personLastKana;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobileFirst() {
        return mobileFirst;
    }

    public void setMobileFirst(String mobileFirst) {
        this.mobileFirst = mobileFirst;
    }

    public String getMobileSecond() {
        return mobileSecond;
    }

    public void setMobileSecond(String mobileSecond) {
        this.mobileSecond = mobileSecond;
    }

    public String getMobileThird() {
        return mobileThird;
    }

    public void setMobileThird(String mobileThird) {
        this.mobileThird = mobileThird;
    }

    public String getMailAdd() {
        return mailAdd;
    }

    public void setMailAdd(String mailAdd) {
        this.mailAdd = mailAdd;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getFax3() {
        return fax3;
    }

    public void setFax3(String fax3) {
        this.fax3 = fax3;
    }

    public String getPostalFirst() {
        return postalFirst;
    }

    public void setPostalFirst(String postalFirst) {
        this.postalFirst = postalFirst;
    }

    public String getPostalSecond() {
        return postalSecond;
    }

    public void setPostalSecond(String postalSecond) {
        this.postalSecond = postalSecond;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PrePersist
    protected void onCreate() {
        LocalDateTime created = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        createdDate = Date.from(created.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime modified = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        modifiedDate = Date.from(modified.atZone(ZoneId.systemDefault()).toInstant());
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }
    public  Customer(){}


}

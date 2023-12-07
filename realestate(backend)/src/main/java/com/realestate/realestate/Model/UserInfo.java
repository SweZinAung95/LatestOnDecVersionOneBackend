package com.realestate.realestate.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Table(name = "userInfo")
public class UserInfo {

    @Id
    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @ManyToOne
//    @JoinColumn(name = "logo_id",referencedColumnName = "id")
    private Logo logo;
//    @Column
//    private String companyName;
    @ManyToOne
//   @JoinColumn(name = "company_id",referencedColumnName = "id")
   private CompanyName companyId;
    @Column(name = "type")
    private String type;
    @Column(name = "first_name")
    private String firstName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_namekana")
    private String firstNamekana;

    @Column(name = "last_namekana")
    private String lastNamekana;


    @Column( name = "gender")
    private String gender;

    @Column( name = "dateOfBirth")
    private String dateOfBirth;

    @Column( name = "department")
    private String department;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "phone3")
    private String phone3;

    @Column(name = "email_id")
    private String email;

    @Column( name = "password")
    private String password;

    @Column(name = "postalcode1")
    private String postalcode1;

    @Column(name = "postalcode2")
    private String postalcode2;

    @Column(name = "address")
    private String address;

    @Column(name = "startDate")
    private String startDate;

    @Column( name = "endDate")
    private String endDate;

    @Column( name = "roleType")
    private String roleType;

    @Column( name = "bankName")
    private String bankName;

    @Column( name = "branch")
    private String branch;

    @Column( name = "accountType")
    private String accountType;

    @Column( name = "accountNumber")
    private String accountNumber;

    @Column( name = "accountName")
    private String accountName;

    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public String getApportionment() {
        return apportionment;
    }

    public void setApportionment(String apportionment) {
        this.apportionment = apportionment;
    }

    @Column( name = "apportionment")
    private String apportionment; // for 按分


    @PrePersist
    protected void onCreate() {
        LocalDateTime created = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        createdDate = Date.from(created.atZone(ZoneId.systemDefault()).toInstant());
//        createdDate = new Date();
//        modifiedDate = new Date();
        LocalDateTime modified = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        modifiedDate = Date.from(modified.atZone(ZoneId.systemDefault()).toInstant());
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }

    public  UserInfo(){}

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public CompanyName getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyName companyId) {
        this.companyId = companyId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNamekana() {
        return firstNamekana;
    }

    public void setFirstNamekana(String firstNamekana) {
        this.firstNamekana = firstNamekana;
    }

    public String getLastNamekana() {
        return lastNamekana;
    }

    public void setLastNamekana(String lastNamekana) {
        this.lastNamekana = lastNamekana;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostalcode1() {
        return postalcode1;
    }

    public void setPostalcode1(String postalcode1) {
        this.postalcode1 = postalcode1;
    }

    public String getPostalcode2() {
        return postalcode2;
    }

    public void setPostalcode2(String postalcode2) {
        this.postalcode2 = postalcode2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
    }




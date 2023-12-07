package com.realestate.realestate.Model;

public class LoginResponses {
    private  String id;
    private String userType;
    private  Logo logo;
    private  CompanyName companyName;
    private String firstName;
    private String lastName;
    private  String phone1;
    private String phone2;
    private  String phone3;

    public String getId() {
        return id;
    }

    public Logo getLogo() {
        return logo;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyName companyName) {
        this.companyName = companyName;
    }

    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
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

    public LoginResponses() {
    }

    public LoginResponses(String id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public LoginResponses(String id, String userType, Logo logo, CompanyName companyName, String firstName, String lastName, String phone1, String phone2, String phone3) {
        this.id = id;
        this.userType = userType;
        this.logo = logo;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
    }

    //    public LoginResponse(String userType) {
//        this.userType = userType;
//    }
}
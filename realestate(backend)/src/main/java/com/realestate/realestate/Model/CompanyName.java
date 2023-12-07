package com.realestate.realestate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "companyName")
public class CompanyName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "companyName")
    private String companyName;

    public Long getId() {
        return id;
    }

    public CompanyName(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyName() {
    }

    public CompanyName(String companyName) {
        this.companyName = companyName;
    }
}

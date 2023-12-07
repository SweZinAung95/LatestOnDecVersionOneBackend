package com.realestate.realestate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private String tenantFirstName;

    @Column
    private String tenantLastName;

    @Column
    private String tenantFirstKana;

    @Column
    private String tenantLastKana;

    @Column
    private String tenantTelFirst;

    @Column
    private String tenatntTelSecond;

    @Column
    private String tenantTelThird;

    @Column
    private String tenantFurikomisaki;

    private Tenant()
    {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantFirstName() {
        return tenantFirstName;
    }

    public void setTenantFirstName(String tenantFirstName) {
        this.tenantFirstName = tenantFirstName;
    }

    public String getTenantLastName() {
        return tenantLastName;
    }

    public void setTenantLastName(String tenantLastName) {
        this.tenantLastName = tenantLastName;
    }

    public String getTenantFirstKana() {
        return tenantFirstKana;
    }

    public void setTenantFirstKana(String tenantFirstKana) {
        this.tenantFirstKana = tenantFirstKana;
    }

    public String getTenantLastKana() {
        return tenantLastKana;
    }

    public void setTenantLastKana(String tenantLastKana) {
        this.tenantLastKana = tenantLastKana;
    }

    public String getTenantTelFirst() {
        return tenantTelFirst;
    }

    public void setTenantTelFirst(String tenantTelFirst) {
        this.tenantTelFirst = tenantTelFirst;
    }

    public String getTenatntTelSecond() {
        return tenatntTelSecond;
    }

    public void setTenatntTelSecond(String tenatntTelSecond) {
        this.tenatntTelSecond = tenatntTelSecond;
    }

    public String getTenantTelThird() {
        return tenantTelThird;
    }

    public void setTenantTelThird(String tenantTelThird) {
        this.tenantTelThird = tenantTelThird;
    }

    public String getTenantFurikomisaki() {
        return tenantFurikomisaki;
    }

    public void setTenantFurikomisaki(String tenantFurikomisaki) {
        this.tenantFurikomisaki = tenantFurikomisaki;
    }

    public Tenant(Long id, String tenantFirstName, String tenantLastName, String tenantFirstKana, String tenantLastKana, String tenantTelFirst, String tenatntTelSecond, String tenantTelThird, String tenantFurikomisaki) {
        this.id = id;
        this.tenantFirstName = tenantFirstName;
        this.tenantLastName = tenantLastName;
        this.tenantFirstKana = tenantFirstKana;
        this.tenantLastKana = tenantLastKana;
        this.tenantTelFirst = tenantTelFirst;
        this.tenatntTelSecond = tenatntTelSecond;
        this.tenantTelThird = tenantTelThird;
        this.tenantFurikomisaki = tenantFurikomisaki;
    }
}

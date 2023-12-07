package com.realestate.realestate.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "PaymentCheck")
public class PaymentCheck {
    @Id
    @Column(unique = true)
    private String id;

    @ManyToOne
    private Logo logo;
    @ManyToOne
    private CompanyName companyId;

    @Column(name = "contractId")
    private String contractId;
    @Column(name = "room")
    private String room;
    @Column(name = "propertyName")
    private String propertyName;
    @Column(name = "ownerName")
    private String ownerName;
    @Column(name = "tenantName")
    private String tenantName;

    @Column(name = "accountName")
    private String accountName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "status")
    private String status;
    @Column(name = "month")
    private Date month;
    @Column(name = "expectedAmount")
    private BigDecimal expectedAmount;
    @Column(name ="income")
    private BigDecimal income;
    @Column(name = "remark")
    private String remark;
    @Column(name = "contractType")
    private String contractType;
    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @PrePersist
    protected void onCreate() {
        LocalDateTime created = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        createdDate = Date.from(created.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime modified = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        modifiedDate = Date.from(modified.atZone(ZoneId.systemDefault()).toInstant());
    }
    @ManyToOne
    @JoinColumn(name = "pm_report_id")
    private PMReport pmReport;

    public PMReport getPmReport() {
        return pmReport;
    }

    public void setPmReport(PMReport pmReport) {
        this.pmReport = pmReport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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


    public String getRoom() {
        return room;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public BigDecimal getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(BigDecimal expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
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

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }
    public  PaymentCheck(){}
}

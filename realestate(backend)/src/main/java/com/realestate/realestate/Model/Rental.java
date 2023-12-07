package com.realestate.realestate.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "rental")
public class Rental {
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserInfo owner;
    @ManyToOne
    @JoinColumn(name = "pm_report_id")
    private PMReport pmReport;
    @Id
    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @Column
    private String room;
    @Column
    private String classification;
    @Column
    private String tenantName;
    @Column
    private BigDecimal areaMeter;
    @Column
    private  BigDecimal areaTsubo;
    @Column
    private BigDecimal rentTsubo;
    @Column
    private  BigDecimal totalRent;
    @Column
    private BigDecimal serviceFeesTsubo;
    @Column
    private  BigDecimal serviceFeesTotal;
    @Column
    private BigDecimal deposit;
    @Column
    private  BigDecimal toalDeposit;
    @Column
    private Date contractStartDate;
    @Column
    private Date contractEndDate;
    @Column
    private  BigDecimal renewalFees;

    public UserInfo getOwner() {
        return owner;
    }

    public void setOwner(UserInfo owner) {
        this.owner = owner;
    }

    public PMReport getPmReport() {
        return pmReport;
    }

    public void setPmReport(PMReport pmReport) {
        this.pmReport = pmReport;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public BigDecimal getAreaMeter() {
        return areaMeter;
    }

    public void setAreaMeter(BigDecimal areaMeter) {
        this.areaMeter = areaMeter;
    }

    public BigDecimal getAreaTsubo() {
        return areaTsubo;
    }

    public void setAreaTsubo(BigDecimal areaTsubo) {
        this.areaTsubo = areaTsubo;
    }

    public BigDecimal getRentTsubo() {
        return rentTsubo;
    }

    public void setRentTsubo(BigDecimal rentTsubo) {
        this.rentTsubo = rentTsubo;
    }

    public BigDecimal getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(BigDecimal totalRent) {
        this.totalRent = totalRent;
    }

    public BigDecimal getServiceFeesTsubo() {
        return serviceFeesTsubo;
    }

    public void setServiceFeesTsubo(BigDecimal serviceFeesTsubo) {
        this.serviceFeesTsubo = serviceFeesTsubo;
    }

    public BigDecimal getServiceFeesTotal() {
        return serviceFeesTotal;
    }

    public void setServiceFeesTotal(BigDecimal serviceFeesTotal) {
        this.serviceFeesTotal = serviceFeesTotal;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getToalDeposit() {
        return toalDeposit;
    }

    public void setToalDeposit(BigDecimal toalDeposit) {
        this.toalDeposit = toalDeposit;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getRenewalFees() {
        return renewalFees;
    }

    public void setRenewalFees(BigDecimal renewalFees) {
        this.renewalFees = renewalFees;
    }

    public String getRentalRemarks() {
        return rentalRemarks;
    }

    public void setRentalRemarks(String rentalRemarks) {
        this.rentalRemarks = rentalRemarks;
    }

    @Column
    private String rentalRemarks;
}

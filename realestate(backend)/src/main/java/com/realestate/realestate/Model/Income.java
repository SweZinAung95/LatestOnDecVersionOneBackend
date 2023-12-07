package com.realestate.realestate.Model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "income")
public class Income {
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserInfo owner;

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

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigDecimal getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public BigDecimal getBicycleParkingFee() {
        return bicycleParkingFee;
    }

    public void setBicycleParkingFee(BigDecimal bicycleParkingFee) {
        this.bicycleParkingFee = bicycleParkingFee;
    }

    public BigDecimal getSignboardFees() {
        return signboardFees;
    }

    public void setSignboardFees(BigDecimal signboardFees) {
        this.signboardFees = signboardFees;
    }

    public BigDecimal getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(BigDecimal parkingFee) {
        this.parkingFee = parkingFee;
    }

    public BigDecimal getKeymoney() {
        return keymoney;
    }

    public void setKeymoney(BigDecimal keymoney) {
        this.keymoney = keymoney;
    }

    public BigDecimal getShikiken() {
        return shikiken;
    }

    public void setShikiken(BigDecimal shikiken) {
        this.shikiken = shikiken;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getRenewalFee() {
        return renewalFee;
    }

    public void setRenewalFee(BigDecimal renewalFee) {
        this.renewalFee = renewalFee;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getOthers() {
        return others;
    }

    public void setOthers(BigDecimal others) {
        this.others = others;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getIncomeRemarks() {
        return incomeRemarks;
    }

    public void setIncomeRemarks(String incomeRemarks) {
        this.incomeRemarks = incomeRemarks;
    }

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
    private String tenantName;
    @Column
    private Date month;
    @Column
    private BigDecimal rent;
    @Column
    private BigDecimal managementFee;
    @Column
    private BigDecimal bicycleParkingFee;
    @Column
    private  BigDecimal signboardFees;

    @Column
    private BigDecimal parkingFee;
    @Column
    private BigDecimal keymoney;
    @Column
    private BigDecimal shikiken;
    @Column
    private BigDecimal deposit;
    @Column
    private BigDecimal renewalFee;
    @Column
    private BigDecimal repairCost;
    @Column
    private BigDecimal penaltyFee;
    @Column
    private BigDecimal tax;
    @Column
    private BigDecimal others;
    @Column
    private BigDecimal totalIncome;
    @Column
    private String incomeRemarks;

}

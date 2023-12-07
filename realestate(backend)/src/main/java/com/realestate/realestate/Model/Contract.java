package com.realestate.realestate.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @ManyToOne
//    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyName companyId;

//    @ManyToOne
////    @JoinColumn(name = "logo_id",referencedColumnName = "id")
//    private Logo logo;

    //    public Logo getLogo() {
//        return logo;
//    }
//
//    public void setLogo(Logo logo) {
//        this.logo = logo;
//    }
    @ManyToOne
    @JoinColumn(name = "pm_report_id")
    private PMReport pmReport;

    public PMReport getPmReport() {
        return pmReport;
    }

    public void setPmReport(PMReport pmReport) {
        this.pmReport = pmReport;
    }

    @Column
    private String propertyName;

    @Column
    private String roomno;

    @Column
    private String ownerName;

    @Column
    private  String ownerKana;





    //borrower info

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_id",referencedColumnName = "id")
    private Borrower borrower;


    //lender info
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lender_id",referencedColumnName = "id")
    private Lender lender;
    //tenant info

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id",referencedColumnName = "id")
    private Tenant tenant;

    //contract info
    @Column
    private LocalDate contractStartDate;

    @Column
    private  LocalDate contractEndDate;

    @Column
    private String contractLength;

    @Column
    private String contractMemo;



    @Column
    private String classification;

    @Column
    private BigDecimal taxRate;

    @Column
    private BigDecimal rent;

    @Column
    private  String rentTax;

    @Column
    private BigDecimal managementFee;

    @Column
    private String managementFeeTax;

    @Column
    private BigDecimal parkingFee;

    @Column
    private String parkingFeeTax;

    @Column
    private  BigDecimal bicycleParkingFee;

    @Column
    private String bicycleParkingFeeTax;

    @Column
    private BigDecimal keymoney;

    @Column
    private String keymoneyTax;

    @Column
    private BigDecimal shikiken;

    @Column
    private  String shikikenTax;

    @Column
    private  BigDecimal deposit;

    @Column
    private String depositTax;

    @Column
    private  BigDecimal renewalFee;

    @Column
    private  String renewalFeeTax;

    @Column
    private Boolean departureTime;

    @Column
    private BigDecimal repairCost;

    @Column
    private String repairCostTax;

    @Column
    private BigDecimal penaltyFee;

    @Column
    private  String penaltyFeeTax;

    @Column
    private BigDecimal signboardFee;

    @Column
    private String signboardFeeTax;

    @Column
    private BigDecimal brokerageFee;

    @Column
    private String brokerageFeeTax;

    @Column
    private BigDecimal totalCost;

    @Column
    private  String bankName;

    @Column
    private String branchName;

    @Column
    private String accountType;

    @Column
    private String accountNo;

    @Column
    private  String accountName;

    @Column
    private String apportionment;

    @Column
    private String tenantFullName;

    @Column
    private  String tenantFullNameKana;

    @ManyToOne
    @JoinColumn(name = "pic_id")
    private UserInfo pic;

    @OneToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column
    private String picName;

    @Column
    private String picNameKana;

    @Column
    private String mobileFirst;

    @Column
    private String mobileSecond;

    @Column
    private String mobileThird;

    @Column
    private String department;

    @Column
    private String createdName;

    @Column
    private String modifiedName;

    // Use LocalDate instead of Date
    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    private LocalDate createdDate;

    // Use LocalDate instead of Date
    @LastModifiedDate
    @Column(name = "modified_dt")
    private LocalDate modifiedDate;

    @PrePersist
    protected void onCreate() {
        LocalDateTime created = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        createdDate = created.toLocalDate();
        modifiedDate = created.toLocalDate();
    }

    @PreUpdate
    protected void onUpdate() {
        LocalDateTime modified = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        modifiedDate = modified.toLocalDate();
    }


    public Contract() {
    }

    public CompanyName getCompanyName() {
        return companyId;
    }

    public void setCompanyName(CompanyName companyName) {
        this.companyId = companyId;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public CompanyName getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyName companyId) {
        this.companyId = companyId;
    }

    public Boolean getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Boolean departureTime) {
        this.departureTime = departureTime;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerKana() {
        return ownerKana;
    }

    public void setOwnerKana(String ownerKana) {
        this.ownerKana = ownerKana;
    }

//    public Date getContractStartDate() {
//        return contractStartDate;
//    }
//
//    public void setContractStartDate(Date contractStartDate) {
//        this.contractStartDate = contractStartDate;
//    }
//
//    public Date getContractEndDate() {

//        return contractEndDate;
//    }
//
//    public void setContractEndDate(Date contractEndDate) {
//        this.contractEndDate = contractEndDate;
//    }


    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractLength() {
        return contractLength;
    }

    public void setContractLength(String contractLength) {
        this.contractLength = contractLength;
    }

    public String getContractMemo() {
        return contractMemo;
    }

    public void setContractMemo(String contractMemo) {
        this.contractMemo = contractMemo;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public String getRentTax() {
        return rentTax;
    }

    public void setRentTax(String rentTax) {
        this.rentTax = rentTax;
    }

    public BigDecimal getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public String getManagementFeeTax() {
        return managementFeeTax;
    }

    public void setManagementFeeTax(String managementFeeTax) {
        this.managementFeeTax = managementFeeTax;
    }

    public BigDecimal getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(BigDecimal parkingFee) {
        this.parkingFee = parkingFee;
    }

    public String getParkingFeeTax() {
        return parkingFeeTax;
    }

    public void setParkingFeeTax(String parkingFeeTax) {
        this.parkingFeeTax = parkingFeeTax;
    }

    public BigDecimal getBicycleParkingFee() {
        return bicycleParkingFee;
    }

    public void setBicycleParkingFee(BigDecimal bicycleParkingFee) {
        this.bicycleParkingFee = bicycleParkingFee;
    }

    public String getBicycleParkingFeeTax() {
        return bicycleParkingFeeTax;
    }

    public void setBicycleParkingFeeTax(String bicycleParkingFeeTax) {
        this.bicycleParkingFeeTax = bicycleParkingFeeTax;
    }

    public BigDecimal getKeymoney() {
        return keymoney;
    }

    public void setKeymoney(BigDecimal keymoney) {
        this.keymoney = keymoney;
    }

    public String getKeymoneyTax() {
        return keymoneyTax;
    }

    public void setKeymoneyTax(String keymoneyTax) {
        this.keymoneyTax = keymoneyTax;
    }

    public BigDecimal getShikiken() {
        return shikiken;
    }

    public void setShikiken(BigDecimal shikiken) {
        this.shikiken = shikiken;
    }

    public String getShikikenTax() {
        return shikikenTax;
    }

    public void setShikikenTax(String shikikenTax) {
        this.shikikenTax = shikikenTax;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getDepositTax() {
        return depositTax;
    }

    public void setDepositTax(String depositTax) {
        this.depositTax = depositTax;
    }

    public BigDecimal getRenewalFee() {
        return renewalFee;
    }

    public void setRenewalFee(BigDecimal renewalFee) {
        this.renewalFee = renewalFee;
    }

    public String getRenewalFeeTax() {
        return renewalFeeTax;
    }

    public void setRenewalFeeTax(String renewalFeeTax) {
        this.renewalFeeTax = renewalFeeTax;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public String getRepairCostTax() {
        return repairCostTax;
    }

    public void setRepairCostTax(String repairCostTax) {
        this.repairCostTax = repairCostTax;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public String getPenaltyFeeTax() {
        return penaltyFeeTax;
    }

    public void setPenaltyFeeTax(String penaltyFeeTax) {
        this.penaltyFeeTax = penaltyFeeTax;
    }

    public BigDecimal getSignboardFee() {
        return signboardFee;
    }

    public void setSignboardFee(BigDecimal signboardFee) {
        this.signboardFee = signboardFee;
    }

    public String getSignboardFeeTax() {
        return signboardFeeTax;
    }

    public void setSignboardFeeTax(String signboardFeeTax) {
        this.signboardFeeTax = signboardFeeTax;
    }

    public BigDecimal getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(BigDecimal brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getBrokerageFeeTax() {
        return brokerageFeeTax;
    }

    public void setBrokerageFeeTax(String brokerageFeeTax) {
        this.brokerageFeeTax = brokerageFeeTax;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getTenantFullName() {
        return tenantFullName;
    }

    public void setTenantFullName(String tenantFullName) {
        this.tenantFullName = tenantFullName;
    }

    public String getTenantFullNameKana() {
        return tenantFullNameKana;
    }

    public void setTenantFullNameKana(String tenantFullNameKana) {
        this.tenantFullNameKana = tenantFullNameKana;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getApportionment() {
        return apportionment;
    }

    public void setApportionment(String apportionment) {
        this.apportionment = apportionment;
    }

    public UserInfo getPic() {
        return pic;
    }

    public void setPic(UserInfo pic) {
        this.pic = pic;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicNameKana() {
        return picNameKana;
    }

    public void setPicNameKana(String picNameKana) {
        this.picNameKana = picNameKana;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Lender getLender() {
        return lender;
    }

    public void setLender(Lender lender) {
        this.lender = lender;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}

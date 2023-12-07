package com.realestate.realestate.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @ManyToOne
//    @JoinColumn(name = "logo_id",referencedColumnName = "id")
    private Logo logo;
    @ManyToOne//(cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyName companyId;
    //    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserInfo userId;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
    @Column
    private String contractData;
    @Column
    private String companyPostalFirst;
    @Column
    private String companyPostalSecond;
    @Column
    private String companyAddress;
    @Column
    private String personName;
    @Column
    private String mobileFirst;
    @Column
    private String mobileSecond;
    @Column
    private String mobileThird;
    @Column
    private String propertyid;
    @Column
    private String propertyName;
    @Column
    private String roomNo;
    @Column
    private String floor;
    @Column
    private String buildingPostalFirst;
    @Column
    private String buildingPostalLast;
    @Column
    private String address;
    @Column
    private String lenderCooperate;
    @Column
    private String lenderPersonName;

    @Column
    private String billingDate;
    @Column
    private String paymentDueDate;

//    @CreatedDate
//    @Column(name = "billing_dt", updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date billingDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invlist_id",referencedColumnName = "id")
    private InvoiceMoneyList invoiceMoneyList;
    @Column
    private String information;
    @Column
    private String bankName;
    @Column
    private String branchName;
    @Column
    private String accountType;
    @Column
    private String accountNo;
    @Column
    private String accountName;
    @Column
    private String status;
    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_dt")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    @PrePersist
    protected void onCreate() {
//        LocalDateTime created = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
//        createdDate = Date.from(created.atZone(ZoneId.systemDefault()).toInstant());
//        LocalDateTime modified = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
//        modifiedDate = Date.from(modified.atZone(ZoneId.systemDefault()).toInstant());

       // billingDate = new Date();
        createdDate = new Date();
        modifiedDate = new Date();
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

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContractData() {
        return contractData;
    }

    public void setContractData(String contractData) {
        this.contractData = contractData;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getCompanyPostalFirst() {
        return companyPostalFirst;
    }

    public void setCompanyPostalFirst(String companyPostalFirst) {
        this.companyPostalFirst = companyPostalFirst;
    }

    public String getCompanyPostalSecond() {
        return companyPostalSecond;
    }

    public void setCompanyPostalSecond(String companyPostalSecond) {
        this.companyPostalSecond = companyPostalSecond;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public String getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(String propertyid) {
        this.propertyid = propertyid;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuildingPostalFirst() {
        return buildingPostalFirst;
    }

    public void setBuildingPostalFirst(String buildingPostalFirst) {
        this.buildingPostalFirst = buildingPostalFirst;
    }

    public String getBuildingPostalLast() {
        return buildingPostalLast;
    }

    public void setBuildingPostalLast(String buildingPostalLast) {
        this.buildingPostalLast = buildingPostalLast;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLenderCooperate() {
        return lenderCooperate;
    }

    public void setLenderCooperate(String lenderCooperate) {
        this.lenderCooperate = lenderCooperate;
    }

    public String getLenderPersonName() {
        return lenderPersonName;
    }

    public void setLenderPersonName(String lenderPersonName) {
        this.lenderPersonName = lenderPersonName;
    }

    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public InvoiceMoneyList getInvoiceMoneyList() {
        return invoiceMoneyList;
    }

    public void setInvoiceMoneyList(InvoiceMoneyList invoiceMoneyList) {
        this.invoiceMoneyList = invoiceMoneyList;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

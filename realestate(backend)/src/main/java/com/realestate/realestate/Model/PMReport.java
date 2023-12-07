package com.realestate.realestate.Model;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pm_report")
public class PMReport {
    @Id
    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @ManyToOne
//    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyName companyId;
    @ManyToOne
    private Logo logo;
    @Column
    private String propertyName;
    @Column
    private String ownerName;
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
    @ManyToOne
    @JoinColumn(name = "pic_id")
    private UserInfo pic;
    @OneToMany(mappedBy = "pmReport")
    private List<Contract> contracts;
    @OneToMany(mappedBy = "pmReport")
    private List<Property> properties;
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @OneToMany(mappedBy = "pmReport")
    private List<PaymentCheck> paymentChecks;
    @Column
    private Date targetMonth;
    @Column
    private String mail;
    @Column
    private String createdName;
    @Column
    private String modifiedName;
    // Use LocalDate instead of Date
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
        LocalDateTime created = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        createdDate = Date.from(created.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime modified = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        modifiedDate = Date.from(modified.atZone(ZoneId.systemDefault()).toInstant());
    }
    @Column
    private BigDecimal totalExpense;

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

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
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

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<PaymentCheck> getPaymentChecks() {
        return paymentChecks;
    }

    public void setPaymentChecks(List<PaymentCheck> paymentChecks) {
        this.paymentChecks = paymentChecks;
    }

    public Date getTargetMonth() {
        return targetMonth;
    }

    public void setTargetMonth(Date targetMonth) {
        this.targetMonth = targetMonth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    @Column
    private BigDecimal totalIncome;

}

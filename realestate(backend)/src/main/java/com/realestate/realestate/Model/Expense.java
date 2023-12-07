package com.realestate.realestate.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {
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
    private String expenseDetail;
    @Column
    private String voucher;
    @Column
    private Date expenseDate;
    @Column
    private BigDecimal expenseMoney;
    @Column
    private BigDecimal expenseTax;
    @Column
    private BigDecimal expenseTotal;

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

    public String getExpenseDetail() {
        return expenseDetail;
    }

    public void setExpenseDetail(String expenseDetail) {
        this.expenseDetail = expenseDetail;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public BigDecimal getExpenseMoney() {
        return expenseMoney;
    }

    public void setExpenseMoney(BigDecimal expenseMoney) {
        this.expenseMoney = expenseMoney;
    }

    public BigDecimal getExpenseTax() {
        return expenseTax;
    }

    public void setExpenseTax(BigDecimal expenseTax) {
        this.expenseTax = expenseTax;
    }

    public BigDecimal getExpenseTotal() {
        return expenseTotal;
    }

    public void setExpenseTotal(BigDecimal expenseTotal) {
        this.expenseTotal = expenseTotal;
    }

    public String getExpenseRemarks() {
        return expenseRemarks;
    }

    public void setExpenseRemarks(String expenseRemarks) {
        this.expenseRemarks = expenseRemarks;
    }

    @Column
    private String expenseRemarks;




}

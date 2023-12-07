package com.realestate.realestate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "borrower")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
//   @JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyName companyId;

    @Column
    public  String borrowerType;

    @Column
    public String borrowerFirstName;

    @Column
    public String borrowerLastName;

    @Column
    public String borrowerFirstKana;

    @Column
    public String borrowerLastKana;

    @Column
    public String borrowerTelFirst;

    @Column
    public String borrowerTelSecond;

    @Column
    public  String borrowerTelThird;

    @Column
    public String borrowerPostalFirst;

    @Column
    public String borrowerPostalSecond;

    @Column
    public String borrowerAddress;

    @Column
    public String borrowerMemo;

    @Column
    public String borrowerCooperate;

    @Column
    public String bcKana;

    @Column
    public String bcpicFirstName;

    @Column
    public String bcpicLastName;

    @Column
    public String bcpicFirstKana;

    @Column
    public String bcpicLastKana;

    @Column
    public String bcMail;

    @Column
    public String bcTelFirst;

    @Column
    public String bcTelSecond;

    @Column
    public String bcTelThird;

    @Column
    public String bcPostalFirst;

    @Column
    public String bcPostalSecond;

    @Column
    public String bcAddress;

    @Column
    public String bcMemo;

    public Borrower() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyName getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyName companyId) {
        this.companyId = companyId;
    }

    public String getBorrowerType() {
        return borrowerType;
    }

    public void setBorrowerType(String borrowerType) {
        this.borrowerType = borrowerType;
    }

    public String getBorrowerFirstName() {
        return borrowerFirstName;
    }

    public void setBorrowerFirstName(String borrowerFirstName) {
        this.borrowerFirstName = borrowerFirstName;
    }

    public String getBorrowerLastName() {
        return borrowerLastName;
    }

    public void setBorrowerLastName(String borrowerLastName) {
        this.borrowerLastName = borrowerLastName;
    }

    public String getBorrowerFirstKana() {
        return borrowerFirstKana;
    }

    public void setBorrowerFirstKana(String borrowerFirstKana) {
        this.borrowerFirstKana = borrowerFirstKana;
    }

    public String getBorrowerLastKana() {
        return borrowerLastKana;
    }

    public void setBorrowerLastKana(String borrowerLastKana) {
        this.borrowerLastKana = borrowerLastKana;
    }

    public String getBorrowerTelFirst() {
        return borrowerTelFirst;
    }

    public void setBorrowerTelFirst(String borrowerTelFirst) {
        this.borrowerTelFirst = borrowerTelFirst;
    }

    public String getBorrowerTelSecond() {
        return borrowerTelSecond;
    }

    public void setBorrowerTelSecond(String borrowerTelSecond) {
        this.borrowerTelSecond = borrowerTelSecond;
    }

    public String getBorrowerTelThird() {
        return borrowerTelThird;
    }

    public void setBorrowerTelThird(String borrowerTelThird) {
        this.borrowerTelThird = borrowerTelThird;
    }

    public String getBorrowerPostalFirst() {
        return borrowerPostalFirst;
    }

    public void setBorrowerPostalFirst(String borrowerPostalFirst) {
        this.borrowerPostalFirst = borrowerPostalFirst;
    }

    public String getBorrowerPostalSecond() {
        return borrowerPostalSecond;
    }

    public void setBorrowerPostalSecond(String borrowerPostalSecond) {
        this.borrowerPostalSecond = borrowerPostalSecond;
    }

    public String getBorrowerAddress() {
        return borrowerAddress;
    }

    public void setBorrowerAddress(String borrowerAddress) {
        this.borrowerAddress = borrowerAddress;
    }

    public String getBorrowerMemo() {
        return borrowerMemo;
    }

    public void setBorrowerMemo(String borrowerMemo) {
        this.borrowerMemo = borrowerMemo;
    }

    public String getBorrowerCooperate() {
        return borrowerCooperate;
    }

    public void setBorrowerCooperate(String borrowerCooperate) {
        this.borrowerCooperate = borrowerCooperate;
    }

    public String getBcKana() {
        return bcKana;
    }

    public void setBcKana(String bcKana) {
        this.bcKana = bcKana;
    }

    public String getBcpicFirstName() {
        return bcpicFirstName;
    }

    public void setBcpicFirstName(String bcpicFirstName) {
        this.bcpicFirstName = bcpicFirstName;
    }

    public String getBcpicLastName() {
        return bcpicLastName;
    }

    public void setBcpicLastName(String bcpicLastName) {
        this.bcpicLastName = bcpicLastName;
    }

    public String getBcpicFirstKana() {
        return bcpicFirstKana;
    }

    public void setBcpicFirstKana(String bcpicFirstKana) {
        this.bcpicFirstKana = bcpicFirstKana;
    }

    public String getBcpicLastKana() {
        return bcpicLastKana;
    }

    public void setBcpicLastKana(String bcpicLastKana) {
        this.bcpicLastKana = bcpicLastKana;
    }

    public String getBcMail() {
        return bcMail;
    }

    public void setBcMail(String bcMail) {
        this.bcMail = bcMail;
    }

    public String getBcTelFirst() {
        return bcTelFirst;
    }

    public void setBcTelFirst(String bcTelFirst) {
        this.bcTelFirst = bcTelFirst;
    }

    public String getBcTelSecond() {
        return bcTelSecond;
    }

    public void setBcTelSecond(String bcTelSecond) {
        this.bcTelSecond = bcTelSecond;
    }

    public String getBcTelThird() {
        return bcTelThird;
    }

    public void setBcTelThird(String bcTelThird) {
        this.bcTelThird = bcTelThird;
    }

    public String getBcPostalFirst() {
        return bcPostalFirst;
    }

    public void setBcPostalFirst(String bcPostalFirst) {
        this.bcPostalFirst = bcPostalFirst;
    }

    public String getBcPostalSecond() {
        return bcPostalSecond;
    }

    public void setBcPostalSecond(String bcPostalSecond) {
        this.bcPostalSecond = bcPostalSecond;
    }

    public String getBcAddress() {
        return bcAddress;
    }

    public void setBcAddress(String bcAddress) {
        this.bcAddress = bcAddress;
    }

    public String getBcMemo() {
        return bcMemo;
    }

    public void setBcMemo(String bcMemo) {
        this.bcMemo = bcMemo;
    }

    public Borrower(Long id,String borrowerType, String borrowerFirstName, String borrowerLastName, String borrowerFirstKana, String borrowerLastKana, String borrowerTelFirst, String borrowerTelSecond, String borrowerTelThird, String borrowerPostalFirst, String borrowerPostalSecond, String borrowerAddress, String borrowerMemo, String borrowerCooperate, String bcKana, String bcpicFirstName, String bcpicLastName, String bcpicFirstKana, String bcpicLastKana, String bcMail, String bcTelFirst, String bcTelSecond, String bcTelThird, String bcPostalFirst, String bcPostalSecond, String bcAddress, String bcMemo) {
        this.id = id;
//        this.companyId = companyId;
        this.borrowerType = borrowerType;
        this.borrowerFirstName = borrowerFirstName;
        this.borrowerLastName = borrowerLastName;
        this.borrowerFirstKana = borrowerFirstKana;
        this.borrowerLastKana = borrowerLastKana;
        this.borrowerTelFirst = borrowerTelFirst;
        this.borrowerTelSecond = borrowerTelSecond;
        this.borrowerTelThird = borrowerTelThird;
        this.borrowerPostalFirst = borrowerPostalFirst;
        this.borrowerPostalSecond = borrowerPostalSecond;
        this.borrowerAddress = borrowerAddress;
        this.borrowerMemo = borrowerMemo;
        this.borrowerCooperate = borrowerCooperate;
        this.bcKana = bcKana;
        this.bcpicFirstName = bcpicFirstName;
        this.bcpicLastName = bcpicLastName;
        this.bcpicFirstKana = bcpicFirstKana;
        this.bcpicLastKana = bcpicLastKana;
        this.bcMail = bcMail;
        this.bcTelFirst = bcTelFirst;
        this.bcTelSecond = bcTelSecond;
        this.bcTelThird = bcTelThird;
        this.bcPostalFirst = bcPostalFirst;
        this.bcPostalSecond = bcPostalSecond;
        this.bcAddress = bcAddress;
        this.bcMemo = bcMemo;
    }
}

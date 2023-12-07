package com.realestate.realestate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "lender")
public class Lender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private String lenderType;

    @Column
    private  String lenderFirstName;

    @Column
    private  String lenderLastName;

    @Column
    private  String lenderFirstKana;

    @Column
    private String lenderLastKana;

    @Column
    private  String lenderTelFirst;

    @Column
    private  String lenderTelSecond;

    @Column
    private String lenderTelThird;

    @Column
    private String lenderPostalFirst;

    @Column
    private String lenderPostalSecond;

    @Column
    private String lenderAddress;

    @Column
    private String lenderMemo;

    @Column
    private String lenderCooperate;

    @Column
    private String lcKana;

    @Column
    private String lcpicFirstName;

    @Column
    private String lcpicLastName;

    @Column
    private  String lcpicFirstKana;

    @Column
    private String lcpicLastKana;

    @Column
    private String lcMail;

    @Column
    private String lcTelFIrst;

    @Column
    private String lcTelSecond;

    @Column
    private String lcTelThird;

    @Column
    private String lcPostalFirst;

    @Column
    private String lcPostalSecond;

    @Column
    private String lcAddress;

    @Column
    private String lcMemo;

    public Lender(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLenderType() {
        return lenderType;
    }

    public void setLenderType(String lenderType) {
        this.lenderType = lenderType;
    }

    public String getLenderFirstName() {
        return lenderFirstName;
    }

    public void setLenderFirstName(String lenderFirstName) {
        this.lenderFirstName = lenderFirstName;
    }

    public String getLenderLastName() {
        return lenderLastName;
    }

    public void setLenderLastName(String lenderLastName) {
        this.lenderLastName = lenderLastName;
    }

    public String getLenderFirstKana() {
        return lenderFirstKana;
    }

    public void setLenderFirstKana(String lenderFirstKana) {
        this.lenderFirstKana = lenderFirstKana;
    }

    public String getLenderLastKana() {
        return lenderLastKana;
    }

    public void setLenderLastKana(String lenderLastKana) {
        this.lenderLastKana = lenderLastKana;
    }

    public String getLenderTelFirst() {
        return lenderTelFirst;
    }

    public void setLenderTelFirst(String lenderTelFirst) {
        this.lenderTelFirst = lenderTelFirst;
    }

    public String getLenderTelSecond() {
        return lenderTelSecond;
    }

    public void setLenderTelSecond(String lenderTelSecond) {
        this.lenderTelSecond = lenderTelSecond;
    }

    public String getLenderTelThird() {
        return lenderTelThird;
    }

    public void setLenderTelThird(String lenderTelThird) {
        this.lenderTelThird = lenderTelThird;
    }

    public String getLenderPostalFirst() {
        return lenderPostalFirst;
    }

    public void setLenderPostalFirst(String lenderPostalFirst) {
        this.lenderPostalFirst = lenderPostalFirst;
    }

    public String getLenderPostalSecond() {
        return lenderPostalSecond;
    }

    public void setLenderPostalSecond(String lenderPostalSecond) {
        this.lenderPostalSecond = lenderPostalSecond;
    }

    public String getLenderAddress() {
        return lenderAddress;
    }

    public void setLenderAddress(String lenderAddress) {
        this.lenderAddress = lenderAddress;
    }

    public String getLenderMemo() {
        return lenderMemo;
    }

    public void setLenderMemo(String lenderMemo) {
        this.lenderMemo = lenderMemo;
    }

    public String getLenderCooperate() {
        return lenderCooperate;
    }

    public void setLenderCooperate(String lenderCooperate) {
        this.lenderCooperate = lenderCooperate;
    }

    public String getLcKana() {
        return lcKana;
    }

    public void setLcKana(String lcKana) {
        this.lcKana = lcKana;
    }

    public String getLcpicFirstName() {
        return lcpicFirstName;
    }

    public void setLcpicFirstName(String lcpicFirstName) {
        this.lcpicFirstName = lcpicFirstName;
    }

    public String getLcpicLastName() {
        return lcpicLastName;
    }

    public void setLcpicLastName(String lcpicLastName) {
        this.lcpicLastName = lcpicLastName;
    }

    public String getLcpicFirstKana() {
        return lcpicFirstKana;
    }

    public void setLcpicFirstKana(String lcpicFirstKana) {
        this.lcpicFirstKana = lcpicFirstKana;
    }

    public String getLcpicLastKana() {
        return lcpicLastKana;
    }

    public void setLcpicLastKana(String lcpicLastKana) {
        this.lcpicLastKana = lcpicLastKana;
    }

    public String getLcMail() {
        return lcMail;
    }

    public void setLcMail(String lcMail) {
        this.lcMail = lcMail;
    }

    public String getLcTelFIrst() {
        return lcTelFIrst;
    }

    public void setLcTelFIrst(String lcTelFIrst) {
        this.lcTelFIrst = lcTelFIrst;
    }

    public String getLcTelSecond() {
        return lcTelSecond;
    }

    public void setLcTelSecond(String lcTelSecond) {
        this.lcTelSecond = lcTelSecond;
    }

    public String getLcTelThird() {
        return lcTelThird;
    }

    public void setLcTelThird(String lcTelThird) {
        this.lcTelThird = lcTelThird;
    }

    public String getLcPostalFirst() {
        return lcPostalFirst;
    }

    public void setLcPostalFirst(String lcPostalFirst) {
        this.lcPostalFirst = lcPostalFirst;
    }

    public String getLcPostalSecond() {
        return lcPostalSecond;
    }

    public void setLcPostalSecond(String lcPostalSecond) {
        this.lcPostalSecond = lcPostalSecond;
    }

    public String getLcAddress() {
        return lcAddress;
    }

    public void setLcAddress(String lcAddress) {
        this.lcAddress = lcAddress;
    }

    public String getLcMemo() {
        return lcMemo;
    }

    public void setLcMemo(String lcMemo) {
        this.lcMemo = lcMemo;
    }

    public Lender(Long id, String lenderType, String lenderFirstName, String lenderLastName, String lenderFirstKana, String lenderLastKana, String lenderTelFirst, String lenderTelSecond, String lenderTelThird, String lenderPostalFirst, String lenderPostalSecond, String lenderAddress, String lenderMemo, String lenderCooperate, String lcKana, String lcpicFirstName, String lcpicLastName, String lcpicFirstKana, String lcpicLastKana, String lcMail, String lcTelFIrst, String lcTelSecond, String lcTelThird, String lcPostalFirst, String lcPostalSecond, String lcAddress, String lcMemo) {
        this.id = id;
        this.lenderType = lenderType;
        this.lenderFirstName = lenderFirstName;
        this.lenderLastName = lenderLastName;
        this.lenderFirstKana = lenderFirstKana;
        this.lenderLastKana = lenderLastKana;
        this.lenderTelFirst = lenderTelFirst;
        this.lenderTelSecond = lenderTelSecond;
        this.lenderTelThird = lenderTelThird;
        this.lenderPostalFirst = lenderPostalFirst;
        this.lenderPostalSecond = lenderPostalSecond;
        this.lenderAddress = lenderAddress;
        this.lenderMemo = lenderMemo;
        this.lenderCooperate = lenderCooperate;
        this.lcKana = lcKana;
        this.lcpicFirstName = lcpicFirstName;
        this.lcpicLastName = lcpicLastName;
        this.lcpicFirstKana = lcpicFirstKana;
        this.lcpicLastKana = lcpicLastKana;
        this.lcMail = lcMail;
        this.lcTelFIrst = lcTelFIrst;
        this.lcTelSecond = lcTelSecond;
        this.lcTelThird = lcTelThird;
        this.lcPostalFirst = lcPostalFirst;
        this.lcPostalSecond = lcPostalSecond;
        this.lcAddress = lcAddress;
        this.lcMemo = lcMemo;
    }
}



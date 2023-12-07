package com.realestate.realestate.Service.BankFormat;


import com.realestate.realestate.Model.BankFormat;

import java.util.List;

public interface BankFormatService {

    public BankFormat addBankFormat(BankFormat bankFormat);

    BankFormat addCreatedDateAndModifiedDateBankFormat(BankFormat bankFormat);

    public List<BankFormat> getBankFormatAll();

    public BankFormat getBankFormatById(String id);

    public BankFormat updateBankFormat(String id , BankFormat bankFormat);

    public void deleteBankFormat(String id);

    public BankFormat getBankFormatByName(String bankName);
}

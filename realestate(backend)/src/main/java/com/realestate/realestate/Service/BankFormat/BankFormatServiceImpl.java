package com.realestate.realestate.Service.BankFormat;

import com.realestate.realestate.Model.BankFormat;
import com.realestate.realestate.Repository.BankFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BankFormatServiceImpl implements BankFormatService {
    @Autowired
    BankFormatRepository bankFormatRepository;

    @Override
    public BankFormat addBankFormat(BankFormat bankFormat) {
        String bankFormatId = generateCustomId();
        bankFormat.setId(bankFormatId);
        return bankFormatRepository.save(bankFormat);
    }
    @Override
    public BankFormat addCreatedDateAndModifiedDateBankFormat(BankFormat bankFormat) {

        return bankFormatRepository.save(bankFormat);
    }

    private String generateCustomId() {
        BankFormat lastBankFormat= bankFormatRepository.findTopByOrderByIdDesc();
        if (lastBankFormat != null) {
            String lastId = lastBankFormat.getId();
            String numericPart = lastId.substring(1); // Exclude the "C" character
            int numericValue = Integer.parseInt(numericPart) + 1;
            String newNumericPart = String.format("%04d", numericValue);
            return "B" + newNumericPart;
        } else {
            return "B0001"; // Initial ID if no users exist
        }
    }
    @Override
    public List<BankFormat> getBankFormatAll() {
        return (List<BankFormat>)bankFormatRepository.findAll();
    }

    @Override
    public BankFormat getBankFormatById(String id) {
        return bankFormatRepository.findById(id).get();
    }

    @Override
    public BankFormat updateBankFormat(String id, BankFormat bankFormat) {
        BankFormat bankFormat1=bankFormatRepository.findById((id)).get();
        if (bankFormat1 != null) {
            bankFormat1.setBankName(bankFormat.getBankName());
            bankFormat1.setContent(bankFormat.getContent());
            bankFormat1.setDate(bankFormat.getDate());
            bankFormat1.setIncome(bankFormat.getIncome());
            bankFormat1.setRemark(bankFormat.getRemark());
        }
        return bankFormatRepository.save(bankFormat1);
    }
    @Override
    public void deleteBankFormat(String id) {
        bankFormatRepository.deleteById(id);
    }

    @Override
    public BankFormat getBankFormatByName(String bankName) {
        return bankFormatRepository.getBankFormatByName(bankName);
    }

}

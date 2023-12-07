package com.realestate.realestate.Controller;

import com.realestate.realestate.Model.BankFormat;
import com.realestate.realestate.Model.Customer;
import com.realestate.realestate.Repository.BankFormatRepository;
import com.realestate.realestate.Service.BankFormat.BankFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@EnableJpaRepositories
public class BankFormatController {
    @Autowired
    private BankFormatService bankFormatService;
    @Autowired
    BankFormatRepository bankFormatRepository;
    @PostMapping(value = "/addCreatedDateAndModifiedDateBankFormat")
    public BankFormat addCreatedDateAndModifiedDateBankFormat(@RequestBody BankFormat bankFormat){
        bankFormat.setCreatedDate(new Date());
        bankFormat.setModifiedDate(new Date());
        BankFormat bankFormatAdd= bankFormatService.addCreatedDateAndModifiedDateBankFormat(bankFormat);
        return  bankFormatAdd;
    }
    @PostMapping(value = "/addBankFormat", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  BankFormat addBankFormat(
            @RequestPart("customer") BankFormat bankFormat
    ){
        return bankFormatService.addBankFormat(bankFormat);
    }
    @GetMapping("/bankformatlist")
    public List<BankFormat> getBankFormatAll(){
        return bankFormatService.getBankFormatAll();
    }

    @GetMapping("/bankformatDetail/{id}")
    public BankFormat getBankFormatById(@PathVariable("id") String id){
        return bankFormatService.getBankFormatById(id);
    }
    @PutMapping("/bankformatUpdate/{id}")
    public BankFormat updateBankFormat(@PathVariable("id") String id, @RequestBody BankFormat bankFormat){
        BankFormat updatedBankFormat=bankFormatService.updateBankFormat(id, bankFormat);
        return updatedBankFormat;
    }
    @DeleteMapping("/bankformatDelete/{id}")
    public String deleteBankFormat(@PathVariable("id") String id){
        bankFormatService.deleteBankFormat(id);
        return "User Deleted Successfully...";
    }
    @GetMapping("/bankformatName/{bankName}")
    public BankFormat getBankFormatByName(@PathVariable("bankName") String bankName){
        System.out.println("Bank Name"+bankName);
        return bankFormatService.getBankFormatByName(bankName);
    }

}

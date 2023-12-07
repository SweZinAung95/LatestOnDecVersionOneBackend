package com.realestate.realestate.Controller;

import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.CompanyRepository;
import com.realestate.realestate.Repository.ContractAndPaymentRepository;
import com.realestate.realestate.Repository.LogoRepository;
import com.realestate.realestate.Repository.PaymentCheckRespository;
import com.realestate.realestate.Service.PaymentCheck.PaymentCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@EnableJpaRepositories
public class PaymentCheckController {
    @Autowired
    private PaymentCheckService paymentCheckService;
    @Autowired
    PaymentCheckRespository paymentCheckRespository;
    @Autowired
    LogoRepository logoRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ContractAndPaymentRepository contractAndPaymentRepository;
    @PostMapping(value ="/upload")
    public ResponseEntity<Void> uploadCSVData( @RequestPart("csvData") List<PaymentCheck> csvData,
                                               @RequestParam("logoId") Long logoId ,// Extract the logo ID from the request
                                               @RequestParam("companyId") Long companyId) {
        try {
            for (PaymentCheck item : csvData) {
                // Perform the query using data from the current item
                String accountName = item.getAccountName(); // Get the tenant name from the item
                // Check if accountName contains カ）
                if (accountName != null &&
                        (accountName.contains("カ）") || accountName.contains(" 支店") || accountName.contains("振込 １ ") || accountName.contains("振込 "))) {
                    accountName = accountName
                            .replace("カ）", "")
                            .replace(" 支店", "")
                            .replace("振込 １ ", "")
                            .replace("振込 ", "");
                }
                accountName = accountName.replaceAll("\\d", ""); // This removes all numeric characters
                item.setAccountName(accountName);
                BigDecimal inputAmount = item.getIncome(); // Get the input amount from the item
                System.out.println("This is testing From Payment"+accountName);
                CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
                if(existingCompany !=null){
                    item.setCompanyId(existingCompany);
                }
                if(logoId!=null){
                    Logo existingLogo = logoRepository.findById(logoId).orElse(null);
                    if (existingLogo != null) {
                        item.setLogo(existingLogo);
                    }
                }
                List<Object []> queryResults = contractAndPaymentRepository.getOwnerAndManualCheckByInputNameAndAmount(accountName, inputAmount);
                for (Object[] row : queryResults) {
                    item.setOwnerName((String) row[0]);
                    item.setTenantName((String) row[3]);
                    item.setPropertyName((String) row[4]);
                    item.setRoom((String) row[5]);
                    item.setContractId((String) row[6]);
                    item.setContractType((String) row[7]);
                    item.setExpectedAmount((BigDecimal) row[8]);
                    item.setStatus((String) row[9]);
                    // Set createdDate and modifiedDate
                    item.setCreatedDate(new Date());
                    item.setModifiedDate(new Date());
                    paymentCheckService.addPaymentCheck(item);
                }
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/paymentCheckByCompanyId/{companyId}")
    public List<PaymentCheck> getPaymentCheckByCompanyId(
            @PathVariable("companyId") Long companyId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Replace with the actual date format you're receiving

        List<Object[]> queryResult= paymentCheckRespository.getPaymentCheck(companyId);
        List<PaymentCheck> paymentChecks = new ArrayList<>();
        for (Object[] row : queryResult) {
            PaymentCheck paymentCheck = new PaymentCheck();
            paymentCheck.setOwnerName((String) row[0]);
            paymentCheck.setTenantName((String) row[1]);
            paymentCheck.setPropertyName((String) row[2]);
            paymentCheck.setRoom((String) row[3]);
            try {
                Date date = dateFormat.parse((String) row[4]);
                paymentCheck.setMonth(date);
                System.out.println("This is testing From Payment" + date);
            } catch (ParseException e) {
                // Handle the parsing exception, e.g., log the error
            }
            paymentCheck.setExpectedAmount((BigDecimal) row[5]);
            paymentCheck.setIncome((BigDecimal) row[6]);
            paymentCheck.setStatus((String) row[7]);
            paymentCheck.setRemark((String) row[8]);
            paymentCheck.setContractType((String) row[9]);
            paymentCheck.setContractId((String) row[10]);
            paymentCheck.setId((String) row[11]);
            paymentChecks.add(paymentCheck);
        }
        return paymentChecks;
    }
    @PostMapping(value = "/addCreatedDateAndModifiedDatePaymentCheck")
    public PaymentCheck addCreatedDateAndModifiedDatePaymentCheck(@RequestBody PaymentCheck paymentCheck){
        paymentCheck.setCreatedDate(new Date());
        paymentCheck.setModifiedDate(new Date());
        PaymentCheck paymentCheckAdd= paymentCheckService.addCreatedDateAndModifiedDatePaymentCheck(paymentCheck);
        return  paymentCheckAdd;
    }
    @PostMapping(value = "/addPaymentCheck", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<Void> addPaymentCheck(
            @RequestPart("paymentCheck") List<PaymentCheck> incomeCheck,
            @RequestParam("logoId") Long logoId ,// Extract the logo ID from the request
            @RequestParam("companyId") Long companyId
    ){
        try {
            for (PaymentCheck item : incomeCheck) {
                CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
                if(existingCompany !=null){
                    item.setCompanyId(existingCompany);
                }
                if(logoId!=null){
                    Logo existingLogo = logoRepository.findById(logoId).orElse(null);
                    if (existingLogo != null) {
                        item.setLogo(existingLogo);
                    }
                }
                String id=item.getId();
                if ("N000".equals(id)){
                    item.setMonth(new Date());
                    paymentCheckService.addPaymentCheck(item);
                }else{
                    paymentCheckService.updatePaymentCheck(id,item);
                }

            }

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

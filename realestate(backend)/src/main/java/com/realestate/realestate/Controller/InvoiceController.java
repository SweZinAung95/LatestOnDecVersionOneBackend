package com.realestate.realestate.Controller;

import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.CompanyRepository;
import com.realestate.realestate.Repository.ContractRepository;
import com.realestate.realestate.Service.Invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ContractRepository contractRepository;
    //    @PostMapping("/addInvoice")
    @PostMapping(value = "/addInvoice",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Invoice addInvoice(@RequestPart("invoiceInfo") Invoice invoice,
                              @RequestPart("invoiceList") InvoiceMoneyList invMoneyList,
                              @RequestParam("companyId") Long companyId
//                              @RequestParam("contractId") String contractId
    ){
        try{
            InvoiceMoneyList invoiceMoneyList1 = new InvoiceMoneyList(invMoneyList.getId(),invMoneyList.getCompanyId(),
                    invMoneyList.getRent(),invMoneyList.getRentTax(),invMoneyList.getRentTotal(), invMoneyList.getRentUsagePeriod(),
                    invMoneyList.getBrokerageFee(),invMoneyList.getBrokerageFeeTax(), invMoneyList.getBrokerageFeeTotal(),invMoneyList.getBrokerageFeeUsagePeriod(),
                    invMoneyList.getServiceFee(),invMoneyList.getServiceFeeTax(),invMoneyList.getServiceFeeTotal(),invMoneyList.getServiceFeeUsagePeriod(),
                    invMoneyList.getParkingFee(),invMoneyList.getParkingFeeTax(),invMoneyList.getParkingFeeTotal(),invMoneyList.getParkingStartDate(),invMoneyList.getParkingEndDate(),
                    invMoneyList.getBicycleParkingFee(),invMoneyList.getBicycleParkingFeeTax(),invMoneyList.getBicycleParkingFeeTotal(),invMoneyList.getBicycleParkingStartDate(),invMoneyList.getBicycleParkingEndDate(),
                    invMoneyList.getKeymoney(),invMoneyList.getKeymoneyTax(),invMoneyList.getKeymoneyTotal(),invMoneyList.getKeymoneyStartDate(),invMoneyList.getKeymoneyEndDate(),
                    invMoneyList.getShikikin(),invMoneyList.getShikikinTax(),invMoneyList.getShikikinTotal(),invMoneyList.getShikikinStartDate(),invMoneyList.getShikikinEndDate(),
                    invMoneyList.getDeposit(),invMoneyList.getDepositTax(),invMoneyList.getDepositTotal(),invMoneyList.getDepositStartDate(),invMoneyList.getDepositEndDate(),
                    invMoneyList.getRenewalFee(),invMoneyList.getRenewalFeeTax(),invMoneyList.getRenewalFeeTotal(),invMoneyList.getRenewalFeeStartDate(),invMoneyList.getRenewalFeeEndDate(),
                    invMoneyList.getRepairCost(),invMoneyList.getRepairCostTax(),invMoneyList.getRepairCostTotal(),invMoneyList.getRepairCostStartDate(),invMoneyList.getRepairCostEndDate(),
                    invMoneyList.getPenaltyFee(),invMoneyList.getPenaltyFeeTax(),invMoneyList.getPenaltyFeeTotal(),invMoneyList.getPenaltyFeeStartDate(),invMoneyList.getPenaltyFeeEndDate(),
                    invMoneyList.getSignboard(),invMoneyList.getSignboardTax(),invMoneyList.getSignboardTotal(),invMoneyList.getSignboardStartDate(),invMoneyList.getSignboardEndDate(),
                    invMoneyList.getElectricBill(),invMoneyList.getElectricBillTax(),invMoneyList.getElectricUsageAmount(),invMoneyList.getElectricBillTotal(),invMoneyList.getElectricBillStartDate(),invMoneyList.getElectricBillEndDate(),
                    invMoneyList.getWaterBill(),invMoneyList.getWaterBillTax(),invMoneyList.getWaterUsageAmount(),invMoneyList.getWaterBillTotal(),invMoneyList.getWaterBillStartDate(),invMoneyList.getWaterBillEndDate(),
                    invMoneyList.getGasBill(),invMoneyList.getGasBillTax(),invMoneyList.getGasUsageAmount(),invMoneyList.getGasBillTotal(),invMoneyList.getGasBillStartDate(),invMoneyList.getGasBillEndDate(),
                    invMoneyList.getConstructionBill(),invMoneyList.getConstructionBillTax(),invMoneyList.getConstructionBillTotal(),invMoneyList.getConstructionBillUsagePeriod(),
                    invMoneyList.getWorkNameFirst(),invMoneyList.getWorkAmountFirst(),invMoneyList.getWorkTaxFirst(),invMoneyList.getWorkAmountTotalFirst(),invMoneyList.getWorkUsagePeriodFirst(),
                    invMoneyList.getWorkNameSecond(),invMoneyList.getWorkAmountSecond(),invMoneyList.getWorkTaxsecond(),invMoneyList.getWorkTotalSecond(),invMoneyList.getWorkUsagePeriodSecond(),
                    invMoneyList.getTotal());
            invoice.setInvoiceMoneyList(invoiceMoneyList1);
            CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
//           Contract contract = contractRepository.findById(contractId).orElse(null);
            if(existingCompany !=null){
                invoice.setCompanyId(existingCompany);
//               invoice.setContractId(contract);
            }
            return invoiceService.addInvoice(invoice);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @GetMapping("/propertiesByBorrowerType/{companyId}")
    public List<Property> getPropertyByBorrowerType(
            @PathVariable("companyId") Long companyId) {
        System.out.println(companyId);
        List<Property> properties= invoiceService.findPropertiesByBorrowerType(companyId);
        return properties;

    }
    @GetMapping("/contractsByBorrowerType/{companyId}")
    public List<Contract> getContractsByBorrowerType(
            @PathVariable("companyId") Long companyId) {
        System.out.println("Contract BorrowerType work "+companyId);
        List<Contract> contracts= invoiceService.findContractsByBorrowerType(companyId);
        System.out.println("Contract BorrowerType output "+invoiceService.findContractsByBorrowerType(companyId));
        return contracts;
    }

    @GetMapping("/invoicesAndInvoiceListsByCompanyId/{companyId}")
    public List<Invoice> getInvoicesAndInvoiceListsByCompanyId(@PathVariable("companyId") Long companyId) {
        System.out.println("This is invoice list output data list "+invoiceService.findInvoicesAndInvoiceListsByCompanyId(companyId));
       // System.out.println(companyId);
        List<Invoice> invData= invoiceService.findInvoicesAndInvoiceListsByCompanyId(companyId);
        return invData;
    }

    @GetMapping("/searchInvoiceList/{companyId}/{propertyName}/{lenderPersonName}")
    public List<Invoice>findAllInvoiceByPropertyNameAndLenderPersonName(@PathVariable("companyId") Long companyId,@PathVariable("propertyName") String propertyName,@PathVariable("lenderPersonName") String lenderPersonName) {
        List<Invoice> searchInvoice = invoiceService.findInvoiceByPropertyNameAndLenderPersonName(companyId,propertyName, lenderPersonName);
        System.out.println("Hello Invoice PDF Collection "+companyId);
        System.out.println("Hello Invoice PDF Collection "+propertyName);

        return searchInvoice;
    }

    @GetMapping("/invoiceDetail/{id}")
    public Invoice getInvoiceById(@PathVariable("id") String id){
        System.out.println("Get Detail invoice data "+invoiceService.getInvoiceById(id));
        return invoiceService.getInvoiceById(id);
    }

    @PutMapping("/updateInvoice/{id}")
    public Invoice updateInvoice(  @PathVariable("id") String id,
                                   @RequestPart("invoiceInfo") Invoice invoice,
                                   @RequestPart("invoiceList") InvoiceMoneyList invMoneyList){
//        try {
//            return invoiceService.updateInvoice(id, invoice);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
        try{
            InvoiceMoneyList invoiceMoneyList1 = new InvoiceMoneyList(invMoneyList.getId(),invMoneyList.getCompanyId(),
                    invMoneyList.getRent(),invMoneyList.getRentTax(),invMoneyList.getRentTotal(), invMoneyList.getRentUsagePeriod(),
                    invMoneyList.getBrokerageFee(),invMoneyList.getBrokerageFeeTax(), invMoneyList.getBrokerageFeeTotal(),invMoneyList.getBrokerageFeeUsagePeriod(),
                    invMoneyList.getServiceFee(),invMoneyList.getServiceFeeTax(),invMoneyList.getServiceFeeTotal(),invMoneyList.getServiceFeeUsagePeriod(),
                    invMoneyList.getParkingFee(),invMoneyList.getParkingFeeTax(),invMoneyList.getParkingFeeTotal(),invMoneyList.getParkingStartDate(),invMoneyList.getParkingEndDate(),
                    invMoneyList.getBicycleParkingFee(),invMoneyList.getBicycleParkingFeeTax(),invMoneyList.getBicycleParkingFeeTotal(),invMoneyList.getBicycleParkingStartDate(),invMoneyList.getBicycleParkingEndDate(),
                    invMoneyList.getKeymoney(),invMoneyList.getKeymoneyTax(),invMoneyList.getKeymoneyTotal(),invMoneyList.getKeymoneyStartDate(),invMoneyList.getKeymoneyEndDate(),
                    invMoneyList.getShikikin(),invMoneyList.getShikikinTax(),invMoneyList.getShikikinTotal(),invMoneyList.getShikikinStartDate(),invMoneyList.getShikikinEndDate(),
                    invMoneyList.getDeposit(),invMoneyList.getDepositTax(),invMoneyList.getDepositTotal(),invMoneyList.getDepositStartDate(),invMoneyList.getDepositEndDate(),
                    invMoneyList.getRenewalFee(),invMoneyList.getRenewalFeeTax(),invMoneyList.getRenewalFeeTotal(),invMoneyList.getRenewalFeeStartDate(),invMoneyList.getRenewalFeeEndDate(),
                    invMoneyList.getRepairCost(),invMoneyList.getRepairCostTax(),invMoneyList.getRepairCostTotal(),invMoneyList.getRepairCostStartDate(),invMoneyList.getRepairCostEndDate(),
                    invMoneyList.getPenaltyFee(),invMoneyList.getPenaltyFeeTax(),invMoneyList.getPenaltyFeeTotal(),invMoneyList.getPenaltyFeeStartDate(),invMoneyList.getPenaltyFeeEndDate(),
                    invMoneyList.getSignboard(),invMoneyList.getSignboardTax(),invMoneyList.getSignboardTotal(),invMoneyList.getSignboardStartDate(),invMoneyList.getSignboardEndDate(),
                    invMoneyList.getElectricBill(),invMoneyList.getElectricBillTax(),invMoneyList.getElectricUsageAmount(),invMoneyList.getElectricBillTotal(),invMoneyList.getElectricBillStartDate(),invMoneyList.getElectricBillEndDate(),
                    invMoneyList.getWaterBill(),invMoneyList.getWaterBillTax(),invMoneyList.getWaterUsageAmount(),invMoneyList.getWaterBillTotal(),invMoneyList.getWaterBillStartDate(),invMoneyList.getWaterBillEndDate(),
                    invMoneyList.getGasBill(),invMoneyList.getGasBillTax(),invMoneyList.getGasUsageAmount(),invMoneyList.getGasBillTotal(),invMoneyList.getGasBillStartDate(),invMoneyList.getGasBillEndDate(),
                    invMoneyList.getConstructionBill(),invMoneyList.getConstructionBillTax(),invMoneyList.getConstructionBillTotal(),invMoneyList.getConstructionBillUsagePeriod(),
                    invMoneyList.getWorkNameFirst(),invMoneyList.getWorkAmountFirst(),invMoneyList.getWorkTaxFirst(),invMoneyList.getWorkAmountTotalFirst(),invMoneyList.getWorkUsagePeriodFirst(),
                    invMoneyList.getWorkNameSecond(),invMoneyList.getWorkAmountSecond(),invMoneyList.getWorkTaxsecond(),invMoneyList.getWorkTotalSecond(),invMoneyList.getWorkUsagePeriodSecond(),
                    invMoneyList.getTotal());
            invoice.setInvoiceMoneyList(invoiceMoneyList1);
           // CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
//           Contract contract = contractRepository.findById(contractId).orElse(null);
//            if(existingCompany !=null){
//                invoice.setCompanyId(existingCompany);
////               invoice.setContractId(contract);
//            }

            System.out.println("This is Update Invoice "+invoiceService.updateInvoice(id,invoice));
            return invoiceService.updateInvoice(id,invoice);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/deleteInvoice/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable String id) {
        try {
            invoiceService.deleteInvoice(id);
            return ResponseEntity.ok().build(); // Return a 200 OK response
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Cannot delete property due to foreign key references.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

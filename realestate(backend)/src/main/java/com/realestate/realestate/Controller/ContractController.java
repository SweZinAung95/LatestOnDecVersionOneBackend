package com.realestate.realestate.Controller;


import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.CompanyRepository;
import com.realestate.realestate.Repository.LogoRepository;
import com.realestate.realestate.Service.Contract.ContractService;
import com.realestate.realestate.Service.UserInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    LogoRepository logoRepository;

    @PostMapping("/addContract")
    public Contract addContract( @RequestPart("contract") Contract contract,
                                 @RequestPart("borrowerId") Borrower borrowerId,
                                 @RequestPart("lenderId") Lender lenderId,
                                 @RequestPart("tenantId") Tenant tenantId,
                                 @RequestParam("companyId") Long companyId) {
        try {
//            Borrower borrower = new Borrower(borrowerId.getId(), borrowerId.getBorrowerType(), borrowerId.getBorrowerFirstName(),
//                    borrowerId.getBorrowerLastName(), borrowerId.getBorrowerFirstKana(), borrowerId.getBorrowerLastKana(),
//                    borrowerId.getBorrowerTelFirst(), borrowerId.getBorrowerTelSecond(), borrowerId.getBorrowerTelThird(),
//                    borrowerId.getBorrowerPostalFirst(), borrowerId.getBorrowerPostalSecond(), borrowerId.getBorrowerAddress(),
//                    borrowerId.getBorrowerMemo(), borrowerId.getBorrowerCooperate(), borrowerId.getBcKana(), borrowerId.getBcpicFirstName(),
//                    borrowerId.getBcpicLastName(), borrowerId.getBcpicLastKana(), borrowerId.getBcpicFirstKana(), borrowerId.getBcTelFirst(),
//                    borrowerId.getBcTelFirst(), borrowerId.getBcTelSecond(), borrowerId.getBcTelThird(), borrowerId.getBcPostalFirst(),
//                    borrowerId.getBcPostalSecond(), borrowerId.getBcAddress(), borrowerId.getBcMemo());
//            contract.setBorrower(borrower);
            Borrower borrower=new Borrower(borrowerId.getId(),
                    borrowerId.getBorrowerType(),
                    borrowerId.getBorrowerFirstName(),
                    borrowerId.getBorrowerLastName(),
                    borrowerId.getBorrowerFirstKana(),
                    borrowerId.getBorrowerLastKana(),
                    borrowerId.getBorrowerTelFirst(),
                    borrowerId.getBorrowerTelSecond(),
                    borrowerId.getBorrowerTelThird(),
                    borrowerId.getBorrowerPostalFirst(),
                    borrowerId.getBorrowerPostalSecond(),
                    borrowerId.getBorrowerAddress(),
                    borrowerId.getBorrowerMemo(),
                    borrowerId.getBorrowerCooperate(),
                    borrowerId.getBcKana(),
                    borrowerId.getBcpicFirstName(),
                    borrowerId.getBcpicLastName(),
                    borrowerId.getBcpicFirstKana(),
                    borrowerId.getBcpicLastKana(),
                    borrowerId.getBcMail(),
                    borrowerId.getBcTelFirst(),
                    borrowerId.getBcTelSecond(),
                    borrowerId.getBcTelThird(),
                    borrowerId.getBcPostalFirst(),
                    borrowerId.getBcPostalSecond(),
                    borrowerId.getBcAddress(),
                    borrowerId.getBcMemo());
            contract.setBorrower(borrower);
            Lender lender = new Lender(lenderId.getId(),
                    lenderId.getLenderType(),
                    lenderId.getLenderFirstName(),
                    lenderId.getLenderLastName(),
                    lenderId.getLenderFirstKana(), lenderId.getLenderLastKana(),
                    lenderId.getLenderTelFirst(), lenderId.getLenderTelSecond(), lenderId.getLenderTelThird(),
                    lenderId.getLenderPostalFirst(), lenderId.getLenderPostalSecond(), lenderId.getLenderAddress(),
                    lenderId.getLenderMemo(),
                    lenderId.getLenderCooperate(),
                    lenderId.getLcKana(),
                    lenderId.getLcpicFirstName(), lenderId.getLcpicLastName(),
                    lenderId.getLcpicFirstKana(), lenderId.getLcpicLastKana(),
                    lenderId.getLcMail(), lenderId.getLcTelFIrst(), lenderId.getLcTelSecond(), lenderId.getLcTelThird(),
                    lenderId.getLcPostalFirst(), lenderId.getLcPostalSecond(), lenderId.getLcAddress(), lenderId.getLcMemo());
            contract.setLender(lender);
            Tenant tenant = new Tenant(tenantId.getId(), tenantId.getTenantFirstName(), tenantId.getTenantLastName(),
                    tenantId.getTenantFirstKana(), tenantId.getTenantLastKana(), tenantId.getTenantTelFirst(),
                    tenantId.getTenatntTelSecond(), tenantId.getTenantTelThird(), tenantId.getTenantFurikomisaki()
            );
            contract.setTenant(tenant);
            CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
            if(existingCompany !=null) {
                contract.setCompanyId(existingCompany);
//
            }
            return contractService.addContract(contract);
//            Contract contract1 = contractService.addContract(contract);

        } catch (Exception e) {
//            System.out.println(image1.getSize());
//            System.out.println(image2.getSize());
            System.out.println(contract);
            System.out.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/contracts")
    public List<Contract> getContract(){
        System.out.println("Contracts..");
        return contractService.getContract();
    }

    @GetMapping("/contract/{id}")
    public Contract getContractById(@PathVariable("id") String id){

        return contractService.getContractById(id);
    }

//    @PutMapping("/updateContract/{id}")
//    public Contract updateContract(@PathVariable("id") String id, @RequestBody Contract contract){
//        Contract updatedContract;
//        updatedContract = contractService.updateContract(id, contract);
//        return updatedContract;
//    }

    @DeleteMapping("/deleteContract/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable String id) {
        try {
            contractService.deleteContract(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Cannot delete contract due to foreign key references.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
//    public String deleteContract(@PathVariable("id") Long id){
//        contractService.deleteContract(id);
//        return "Contract Deleted Successfully...";
//    }

    //    @GetMapping("/contractsByCompanyName/{companyName}")
////    public List<Contract> getContractsByCompanyName(
////            @PathVariable("companyName") String companyName) {
////        System.out.println(companyName);
////        List<Contract> contracts= contractService.findAllContractsByCompanyName(companyName);
////        return contracts;
////
////    }
//    @GetMapping("/contractsByCompanyId/{companyId}")
//    public List<Contract> getContractsByCompanyId(
//            @PathVariable("companyId") Long companyId) {
//        System.out.println(companyId);
//        List<Contract> contracts= contractService.findAllContractsByCompanyId(companyId);
//        return contracts;
//
//    }
    @GetMapping("/contractsByCompanyId/{companyId}")
    public List<Contract> getContractsByCompanyId(
            @PathVariable("companyId") Long companyId) {
        List<Contract> contracts = contractService.findAllContractsByCompanyId(companyId);

        // Extract Property objects from the contracts
        return contracts;
    }

//    @GetMapping("/test")
//    public void testContractMethods() {
//        Long companyId = 2L; // Replace with the actual company ID you want to query
//        contractService.testContractMethods(companyId);
//    }


}

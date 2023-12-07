package com.realestate.realestate.Service.Contract;

import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ContractServiceImpl  implements  ContractService{
    @Autowired
    ContractRepository contractRepository;
    @Override
    public Contract addContract(Contract contract) {
        String customId=generateCustomId();

        //set the customID in the entity
        contract.setId(customId);
        BigDecimal total = BigDecimal.ZERO; // Initialize total to zero

        total = total.add(contract.getRent());
        total = total.add(contract.getManagementFee());
        total = total.add(contract.getBicycleParkingFee());
        total = total.add(contract.getParkingFee());
        total = total.add(contract.getKeymoney());
        total = total.add(contract.getShikiken());
        total = total.add(contract.getDeposit());
        total = total.add(contract.getRenewalFee());
        total = total.add(contract.getRepairCost());
        total = total.add(contract.getPenaltyFee());
        total = total.add(contract.getSignboardFee());
        total = total.add(contract.getBrokerageFee());

        contract.setTotalCost(total);

        String tenantName= contract.getTenant().getTenantFirstName()+" "+contract.getTenant().getTenantLastName();
        String tenantNameKana=contract.getTenant().getTenantFirstKana()+" "+contract.getTenant().getTenantLastKana();

        contract.setTenantFullName(tenantName);
        contract.setTenantFullNameKana(tenantNameKana);



        //save the Property entity
        return contractRepository.save(contract);

    }
private String generateCustomId() {
    Contract lastContract = contractRepository.findTopByOrderByIdDesc();
    if (lastContract != null) {
        String lastId = lastContract.getId();
        String numericPart = lastId.substring(1); // Exclude the "C" character
        int numericValue = Integer.parseInt(numericPart) + 1;
        String newNumericPart = String.format("%04d", numericValue);
        return "C" + newNumericPart;
    } else {
        return "C0001"; // Initial ID if no users exist
    }
}

    @Override
    public  List<Contract> getContract(){
        return  (List<Contract>) contractRepository.findAll();
    }
    @Override
    public  Contract getContractById(String id){
        return contractRepository.findById(id).get();
    }

    @Override
    public void deleteContract(String id){
        contractRepository.deleteById(id);
    }
    @Override
    public List<Contract> findAllContractsByCompanyId(Long companyId) {
        return contractRepository.findAllContractsByCompanyId(companyId);
    }

    @Override
    public void testContractMethods(Long companyId) {

    }

//    public void testContractMethods(Long companyId) {
//        List<Contract> contractsByCompanyId = contractRepository.findAllContractsByCompanyId(companyId);
//        Contract topContract = contractRepository.findTopByOrderByIdDesc();
//
//        // Print the results to the console or log them
//        System.out.println("Contracts by Company ID: " + contractsByCompanyId);
//        System.out.println("Top Contract by ID Desc: " + topContract);
//    }

}



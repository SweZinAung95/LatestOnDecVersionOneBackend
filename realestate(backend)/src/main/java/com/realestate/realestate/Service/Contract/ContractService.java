package com.realestate.realestate.Service.Contract;

import com.realestate.realestate.Model.Contract;
import com.realestate.realestate.Model.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {
    public Contract addContract(Contract contract);
    public List<Contract> getContract();
    public Contract getContractById(String id);
//    public Contract updateContract(String id , Contract contract);

    public void deleteContract(String id);
    //    public List<Contract> findAllContractsByCompanyName(String companyName);
    public List<Contract> findAllContractsByCompanyId(Long companyId);
//    public List<Object[]> findAllContractsByBorrowerType(Long companyId);

    void testContractMethods(Long companyId);
}

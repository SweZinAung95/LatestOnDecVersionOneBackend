package com.realestate.realestate.Service.Invoice;

import com.realestate.realestate.Model.Contract;
import com.realestate.realestate.Model.Invoice;
import com.realestate.realestate.Model.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceServiceInterface {
    public Invoice addInvoice(Invoice invoice);
    public List<Property> findPropertiesByBorrowerType(Long companyId);
    public List<Contract> findContractsByBorrowerType(Long companyId);
    public List<Invoice> findInvoicesAndInvoiceListsByCompanyId(Long companyId);
    public Invoice getInvoiceById(String id);
    public Invoice updateInvoice(String id , Invoice invoice);
    List<Invoice> findInvoiceByPropertyNameAndLenderPersonName(Long companyId, String propertyName, String lenderPersonName);
    public void deleteInvoice(String id);
}

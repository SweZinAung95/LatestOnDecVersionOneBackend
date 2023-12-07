package com.realestate.realestate.Service.Customer;

import com.realestate.realestate.Model.Customer;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public interface CustomerService {
    public Customer addCustomer(Customer customer);

    Customer addCreatedDateAndModifiedDateCustomer(Customer customer);

    public List<Customer> getCustomer();

    public Customer getCustomerById(String id);

    public Customer updateCustomer(String id , Customer customer);

    public void deleteCustomer(String id);

    List<Customer> findAllCustomersByCompanyId(Long companyId);
}

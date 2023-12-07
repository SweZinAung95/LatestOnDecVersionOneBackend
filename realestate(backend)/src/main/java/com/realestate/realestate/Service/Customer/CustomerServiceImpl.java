package com.realestate.realestate.Service.Customer;


import com.realestate.realestate.Model.CompanyName;
import com.realestate.realestate.Model.Customer;
import com.realestate.realestate.Model.Logo;
import com.realestate.realestate.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        String customId = generateCustomId();
        customer.setId(customId);
        String fullName = customer.getPersonFirstName() + " " + customer.getPersonLastName();
        String fullNameKana = customer.getPersonFirstKana() + " " + customer.getPersonLastKana();
        customer.setPersonFullName(fullName);
        customer.setPersonFullNameKana(fullNameKana);
        return customerRepository.save(customer);
    }

    @Override
    public Customer addCreatedDateAndModifiedDateCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    private String generateCustomId() {
        Customer lastCustomer= customerRepository.findTopByOrderByIdDesc();
        if (lastCustomer != null) {
            String lastId = lastCustomer.getId();
            String numericPart = lastId.substring(1); // Exclude the "C" character
            int numericValue = Integer.parseInt(numericPart) + 1;
            String newNumericPart = String.format("%04d", numericValue);
            return "T" + newNumericPart;
        } else {
            return "T0001"; // Initial ID if no users exist
        }
    }

    @Override
    public List<Customer> getCustomer() {
        return (List<Customer>)customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        Customer customer1=customerRepository.findById((id)).get();
        if (customer1 != null) {

            Logo logoImage = customer1.getLogo();
            if (logoImage == null) {
                logoImage = new Logo();
                customer1.setLogo(logoImage);
            }
            logoImage.setImage(customer.getLogo().getImage());
            logoImage.setName(customer.getLogo().getName());
            logoImage.setType(customer.getLogo().getType());

            CompanyName companyId = customer1.getCompanyId();
            if(companyId== null){
                companyId = new CompanyName();
                customer1.setCompanyId(companyId);
            }
            companyId.setCompanyName(customer.getCompanyId().getCompanyName());
            customer1.setType(customer.getType());
            customer1.setCompanyName(customer.getCompanyName());
            customer1.setPersonFirstName(customer.getPersonFirstName());
            customer1.setPersonLastName(customer.getPersonLastName());
            customer1.setPersonFirstKana(customer.getPersonFirstKana());
            customer1.setPersonLastKana(customer.getPersonLastKana());
            customer1.setDepartment(customer.getDepartment());
            customer1.setMobileFirst(customer.getMobileFirst());
            customer1.setMobileSecond(customer.getMobileSecond());
            customer1.setMobileThird(customer.getMobileThird());
            customer1.setMailAdd(customer.getMailAdd());
            customer1.setFax1(customer.getFax1());
            customer1.setFax2(customer.getFax2());
            customer1.setFax3(customer.getFax3());
            customer1.setPostalFirst(customer.getPostalFirst());
            customer1.setPostalSecond(customer.getPostalSecond());
            customer1.setAddress(customer.getAddress());
            customer1.setRemark(customer.getRemark());
            customer1.setPersonFullName(customer.getPersonFullName());
            customer1.setPersonFullNameKana(customer.getPersonFullNameKana());
        }
        return customerRepository.save(customer1);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllCustomersByCompanyId(Long companyId) {
        return customerRepository.findAllCustomersByCompanyId(companyId);
    }

}
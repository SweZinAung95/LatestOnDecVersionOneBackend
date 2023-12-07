package com.realestate.realestate.Controller;

import com.realestate.realestate.Model.CompanyName;
import com.realestate.realestate.Model.Customer;
import com.realestate.realestate.Model.Logo;
import com.realestate.realestate.Repository.CompanyRepository;
import com.realestate.realestate.Repository.LogoRepository;
import com.realestate.realestate.Service.Customer.CustomerService;
import com.realestate.realestate.Service.UserInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@EnableJpaRepositories
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    LogoRepository logoRepository;
    @Autowired
    CompanyRepository companyRepository;
    @PostMapping(value = "/addCreatedDateAndModifiedDateCustomer")
    public Customer addCreatedDateAndModifiedDateCustomer(@RequestBody Customer customer){
        customer.setCreatedDate(new Date());
        customer.setModifiedDate(new Date());
        Customer customerAdd= customerService.addCreatedDateAndModifiedDateCustomer(customer);
        return  customerAdd;
    }
    @PostMapping(value = "/addCustomer", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  Customer addCustomer(
            @RequestPart("customer") Customer customer,
            @RequestParam("logoId") Long logoId ,// Extract the logo ID from the request
            @RequestParam("companyId") Long companyId
    ){
        try {
            CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
            if(existingCompany !=null){
                customer.setCompanyId(existingCompany);
            }
            if(logoId!=null){
                Logo existingLogo = logoRepository.findById(logoId).orElse(null);
                if (existingLogo != null) {
                    customer.setLogo(existingLogo);
                }
            } else {
            }
            return customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        System.out.println("Users..");
        return customerService.getCustomer();
    }

    @GetMapping("/customerDetail/{id}")
    public Customer getCustomerById(@PathVariable("id") String id){
        return customerService.getCustomerById(id);
    }
    @PutMapping("/customerUpdate/{id}")
    public Customer updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer){
        Customer updatedCustomer=customerService.updateCustomer(id, customer);
        return updatedCustomer;
    }
    @DeleteMapping("/customerDelete/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
        return "User Deleted Successfully...";
    }
    @GetMapping("/customersByCompanyId/{companyId}")
    public List<Customer> getCustomersByCompanyId(
            @PathVariable("companyId") Long companyId) {
        System.out.println(companyId);
        List<Customer> customers= customerService.findAllCustomersByCompanyId(companyId);
        return customers;

    }
}

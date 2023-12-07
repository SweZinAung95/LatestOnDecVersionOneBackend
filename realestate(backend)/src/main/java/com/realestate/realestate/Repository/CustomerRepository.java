package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.Customer;
import com.realestate.realestate.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    Customer findTopByOrderByIdDesc();
    @Query("SELECT c FROM Customer c WHERE c.companyName = companyName")
    List<Property> findByCompanyName(String customerName);

    @Query("SELECT c FROM Customer c WHERE c.companyId.id = :companyId")
    List<Customer> findAllCustomersByCompanyId(@Param("companyId") Long companyId);

}

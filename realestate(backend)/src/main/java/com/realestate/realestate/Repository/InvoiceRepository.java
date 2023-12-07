package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.Contract;
import com.realestate.realestate.Model.Invoice;
import com.realestate.realestate.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    Invoice findTopByOrderByIdDesc();
    @Query("SELECT p " +
            "FROM Property p " +
//            "JOIN Contract c ON c.companyId.id = p.companyId.id " +
            "JOIN Contract c ON c.property.Id = p.Id " +
            "WHERE c.companyId.id = :companyId AND c.borrower.borrowerType = 'BH'")
//    @Query("SELECT c FROM Contract c WHERE c.companyId.id = :companyId AND c.borrower.borrowerType = 'BH'")
    List<Property> findPropertiesByBorrowerType(@Param("companyId") Long companyId);

    @Query("SELECT c FROM Contract c WHERE c.companyId.id = :companyId AND c.borrower.borrowerType = 'BH'")
    List<Contract> findContractsByBorrowerType(@Param("companyId") Long companyId);

//    @Query("SELECT i, il FROM Invoice i JOIN InvoiceMoneyList il "+
//            "ON il.id = i.invoiceMoneyList.id WHERE i.companyId.id = :companyId")
    @Query("SELECT i "+
            "FROM Invoice i "+
            "WHERE i.companyId.id = :companyId")
    List<Invoice> findInvoicesAndInvoiceListsByCompanyId(@Param("companyId") Long companyId);

    @Query("SELECT i FROM Invoice i WHERE i.propertyName = :propertyName AND i.lenderPersonName = :lenderPersonName AND i.companyId.id = :companyId")
    List<Invoice> findAllInvoiceByPropertyNameAndLenderPersonName(@Param("companyId") Long companyId, @Param("propertyName") String propertyName, @Param("lenderPersonName") String lenderPersonName);
}

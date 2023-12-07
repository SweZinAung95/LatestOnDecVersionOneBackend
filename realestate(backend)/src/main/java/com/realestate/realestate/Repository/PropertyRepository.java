package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.Property;
import com.realestate.realestate.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PropertyRepository extends JpaRepository<Property, String> {
//    @Query("SELECT p FROM Property p WHERE p.propertyName = propertyName  p.propertyType = propertyType")
//
//    List<Property> findByPropertyNameAndType(String propertyName, String propertyType);
    @Query("SELECT p FROM Property p WHERE p.propertyName = propertyName")
   List<Property> findByPropertyName(String propertyName);
    @Query("SELECT p FROM Property p WHERE p.propertyType = propertyType")
    List<Property> findByPropertyType(String propertyType);
    @Query("SELECT p FROM Property p " +
            "WHERE (:propertyName is null or p.propertyName = :propertyName) " +
            "AND (:propertyType is null or p.propertyType = :propertyType)")
    List<Property> searchEntities( String propertyName,
                                     String propertyType);
//    @Query("SELECT p FROM Property p WHERE p.companyName = :companyName")
//    List<Property> findAllPropertiesByCompanyName(String companyName);
    @Query("SELECT p FROM Property p WHERE p.companyId.id = :companyId")
    List<Property> findAllPropertiesByCompanyId(@Param("companyId") Long companyId);
    @Query("SELECT p FROM Property p WHERE p.companyId.id = :companyId AND p.propertyName = :propertyName")
    List<Property> findAllOwnersByCompanyIdWithPropertyId(@Param("companyId") Long companyId,
                                                          @Param("propertyName") String propertyName);
    //請求書物件情報のため使う機能
//    @Query("SELECT p FROM Property p JOIN p.contract c WHERE c.contractId = :contractId")
//    Property findPropertyByContractId(@Param("contractId") String contractId);

//請求書物件情報のため使う機能
//    @Query("SELECT p.floor AS floor,p.room AS room,p.propertyName AS propertyName "+
//            "FROM Property p "+
//            "JOIN Contract c ON c.companyId.id = p.companyId.id "+
//            //"JOIN CompanyName com ON com.id = p.companyId.id "+
//            "WHERE c.companyId.id = :companyId AND c.borrower.borrowerType = 'BH'")
//    Property findPropertyByContractId(@Param("companyId") Long companyId);


    Property findTopByOrderByIdDesc();

}

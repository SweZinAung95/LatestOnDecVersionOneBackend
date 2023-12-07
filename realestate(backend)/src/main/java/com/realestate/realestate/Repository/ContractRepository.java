package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.Contract;
import com.realestate.realestate.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,String> {
    //    @Query("SELECT c FROM Contract c WHERE c.companyName = :companyName")
//    List<Contract> findAllContractsByCompanyName(String companyName);
    @Query("SELECT c FROM Contract c WHERE c.companyId.id = :companyId")
    List<Contract> findAllContractsByCompanyId(@Param("companyId") Long companyId);

//    @Query(value= "SELECT b.bcpic_first_name bcpic_first_name,b.bcpic_last_name bcpic_last_name,"+
//            "b.borrower_first_name  borrower_first_name,b.borrower_last_name borrower_last_name,b.bc_mail bc_mail,c "+
//            "FROM Contract c join Borrower b ON c.borrower_id =b.id"+
//            "WHERE c.company_id_id = :companyId AND b.borrower_type = 'BH'")
//    List<Object[]> findAllContractsByBorrowerType(@Param("companyId") Long companyId);
//@Query(value = "SELECT b.bcpic_first_name bcpic_first_name, b.bcpic_last_name bcpic_last_name, " +
//        "b.borrower_first_name borrower_first_name, b.borrower_last_name borrower_last_name, " +
//        "b.bc_mail bc_mail, c " +
//        "FROM Contract c JOIN Borrower b ON c.borrower_id = b.id " +
//        "WHERE c.company_id_id = :companyId AND b.borrower_type = 'BH'")
//List<Object[]> findAllContractsByBorrowerType(@Param("companyId") Long companyId);

//    @Query(value = "SELECT c.owner_name owner_name, t.tenant_first_name tenant_first_name, t.tenant_last_name tenant_last_name, CONCAT(t.tenant_first_name, ' ', t.tenant_last_name) as tenant_name, " +
//            " c.property_name property_name, c.room_no room_no,c.id contract_id, b.borrower_type borrower_type, " +
//            "CASE " +
//            "    WHEN b.borrower_type = 'BK' THEN c.total_cost " +
//            "    WHEN b.borrower_type = 'BH' THEN i.total_cost " +
//            "    ELSE NULL " +
//            "END AS expected_amount, " +
//            "CASE " +
//            "    WHEN b.borrower_type = 'BK' THEN " +
//            "        CASE " +
//            "            WHEN c.total_cost = :inputAmount THEN 'OK' " +
//            "            WHEN c.total_cost <> :inputAmount THEN 'NG' " +
//            "            ELSE '未' " +
//            "        END " +
//            "    WHEN b.borrower_type = 'BH' THEN " +
//            "        CASE " +
//            "            WHEN i.total_cost = :inputAmount THEN 'OK' " +
//            "            WHEN i.total_cost <> :inputAmount THEN 'NG' " +
//            "            ELSE '未' " +
//            "        END " +
//            "    ELSE NULL " +
//            "END AS status " +
//            "FROM Contract c " +
//            "JOIN tenant t ON c.tenant_id = t.id " +
//            "JOIN borrower b ON c.borrower_id = b.id " +
//            "LEFT JOIN invoice i ON c.id = i.contract_id_id " +
//            "WHERE t.tenant_furikomisaki = :accountName", nativeQuery = true)
//    List<Object[]> findAllContractsByBorrowerType(@Param("companyId") Long companyId);

    Contract findTopByOrderByIdDesc();

}

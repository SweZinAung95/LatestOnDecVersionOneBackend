package com.realestate.realestate.Repository;
import com.realestate.realestate.Model.Contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface ContractAndPaymentRepository extends JpaRepository<Contract, Long> {
    @Query(value = "SELECT c.owner_name owner_name, t.tenant_first_name tenant_first_name, t.tenant_last_name tenant_last_name, CONCAT(t.tenant_first_name, ' ', t.tenant_last_name) as tenant_name, " +
            " c.property_name property_name, c.room_no room_no,c.id contract_id, b.borrower_type borrower_type, " +
            "CASE " +
            "    WHEN b.borrower_type = 'BK' THEN c.total_cost " +
            "    WHEN b.borrower_type = 'BH' THEN iv.total " +
            "    ELSE NULL " +
            "END AS expected_amount, " +
            "CASE " +
            "    WHEN b.borrower_type = 'BK' THEN " +
            "        CASE " +
            "            WHEN c.total_cost = :inputAmount THEN 'OK' " +
            "            WHEN c.total_cost <> :inputAmount THEN 'NG' " +
            "            ELSE '未' " +
            "        END " +
            "    WHEN b.borrower_type = 'BH' THEN " +
            "        CASE " +
            "            WHEN iv.total = :inputAmount THEN 'OK' " +
            "            WHEN iv.total <> :inputAmount THEN 'NG' " +
            "            ELSE '未' " +
            "        END " +
            "    ELSE NULL " +
            "END AS status " +
            "FROM Contract c " +
            "LEFT JOIN tenant t ON c.tenant_id = t.id " +
            "LEFT JOIN borrower b ON c.borrower_id = b.id " +
            "LEFT JOIN invoice i ON c.id = i.contract_id " +
            "LEFT JOIN invlist iv ON iv.id = i.invlist_id " +
            "WHERE t.tenant_furikomisaki = :accountName ", nativeQuery = true)

    List<Object[]> getOwnerAndManualCheckByInputNameAndAmount(String accountName, BigDecimal inputAmount);


}


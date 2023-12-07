package com.realestate.realestate.Repository;


import com.realestate.realestate.Model.PaymentCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface PaymentCheckRespository extends JpaRepository<PaymentCheck,String> {
    PaymentCheck findTopByOrderByIdDesc();

    @Query(value = "SELECT " +
            "CASE " +
            "    WHEN p.owner_name IS NULL THEN c.owner_name " +
            "    ELSE p.owner_name " +
            "END AS owner_name, " +
            "CASE " +
            "    WHEN p.tenant_name IS NULL THEN CONCAT(t.tenant_first_name, ' ', t.tenant_last_name) " +
            "    ELSE p.tenant_name " +
            "END AS tenant_name, " +
            "CASE " +
            "    WHEN p.property_name IS NULL THEN c.property_name " +
            "    ELSE p.property_name " +
            "END AS property_name, " +
            "CASE " +
            "    WHEN p.room IS NULL THEN c.room_no " +
            "    ELSE p.room " +
            "END AS room, " +
            "CASE " +
            "    WHEN p.month IS NULL THEN '' " +
            "    ELSE p.month " +
            "END AS month, " +
            "CASE " +
            "    WHEN p.expected_amount IS NULL THEN " +
            "        CASE " +
            "        WHEN b.borrower_type = 'BK' THEN c.total_cost " +
            "        WHEN b.borrower_type = 'BH' THEN iv.total " +
            "        ELSE NULL " +
            "        END " +
            " ELSE p.expected_amount END AS expected_amount, " +
            "CASE " +
            "    WHEN p.income IS NULL THEN 0 " +
            "    ELSE p.income " +
            "END AS income, " +
            "CASE " +
            "    WHEN p.status IS NULL THEN '未' " +
            "    ELSE p.status " +
            "END AS status, " +
            "CASE " +
            "    WHEN p.remark IS NULL THEN '' " +
            "    ELSE p.remark " +
            "END AS remark, b.borrower_type borrower_type,c.id contract_id ," +
            "CASE " +
            "    WHEN p.id IS NULL THEN 'N000' " +
            "    ELSE p.id " +
            "END AS id " +
            "FROM contract  c " +
            "LEFT JOIN tenant  t ON c.tenant_id = t.id  " +
            "LEFT JOIN payment_check  p ON c.id = p.contract_id " +
            "LEFT JOIN borrower  b ON c.borrower_id = b.id " +
            "LEFT JOIN invoice i ON c.id = i.contract_id " +
            "LEFT JOIN invlist iv ON iv.id = i.invlist_id WHERE p.company_id_id = :companyId "
            ,nativeQuery = true)
    List<Object[]> getPaymentCheck(@Param("companyId") Long companyId);
}

package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.BankFormat;
import com.realestate.realestate.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankFormatRepository extends JpaRepository<BankFormat, String> {

    BankFormat findTopByOrderByIdDesc();

    @Query("SELECT b FROM BankFormat b WHERE b.bankName = :bankName")
    BankFormat getBankFormatByName(@Param("bankName") String bankName);
}

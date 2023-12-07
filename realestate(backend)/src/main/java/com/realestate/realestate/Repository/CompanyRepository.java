package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.CompanyName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyName,Long> {
}

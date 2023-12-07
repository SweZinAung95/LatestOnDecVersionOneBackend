package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.Borrower;
import com.realestate.realestate.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower,Long> {

}

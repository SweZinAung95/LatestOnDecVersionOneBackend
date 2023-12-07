package com.realestate.realestate.Service.Borrower;

import com.realestate.realestate.Model.Borrower;
import com.realestate.realestate.Model.Contract;
import com.realestate.realestate.Repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    BorrowerRepository borrowerRepository;
    @Override
    public Borrower getBorrowerById(Long id){
        System.out.println("Borrower Data "+borrowerRepository.findById(id).get());
        return borrowerRepository.findById(id).get();
    }
}

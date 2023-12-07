package com.realestate.realestate.Service.Borrower;

import com.realestate.realestate.Model.Borrower;
import org.springframework.stereotype.Service;

@Service
public interface BorrowerService {
    public Borrower getBorrowerById(Long id);
}

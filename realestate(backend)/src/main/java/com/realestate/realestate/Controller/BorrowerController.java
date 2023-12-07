package com.realestate.realestate.Controller;

import com.realestate.realestate.Model.Borrower;
import com.realestate.realestate.Model.Contract;
import com.realestate.realestate.Service.Borrower.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;
    @GetMapping("/borrower/{id}")
    public Borrower getBorrowerById(@PathVariable("id") Long id){

        return borrowerService.getBorrowerById(id);
    }
}

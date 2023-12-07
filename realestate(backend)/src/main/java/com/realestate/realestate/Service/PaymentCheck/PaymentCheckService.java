package com.realestate.realestate.Service.PaymentCheck;


import com.realestate.realestate.Model.Customer;
import com.realestate.realestate.Model.PaymentCheck;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PaymentCheckService{
    public PaymentCheck addPaymentCheck(PaymentCheck paymentCheck);

    PaymentCheck addCreatedDateAndModifiedDatePaymentCheck(PaymentCheck paymentCheck);

    public PaymentCheck updatePaymentCheck(String id,PaymentCheck paymentCheck);


   }

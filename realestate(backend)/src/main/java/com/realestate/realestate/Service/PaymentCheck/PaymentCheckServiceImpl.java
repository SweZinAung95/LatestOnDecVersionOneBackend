package com.realestate.realestate.Service.PaymentCheck;


import com.realestate.realestate.Model.CompanyName;
import com.realestate.realestate.Model.Customer;
import com.realestate.realestate.Model.Logo;
import com.realestate.realestate.Model.PaymentCheck;
import com.realestate.realestate.Repository.PaymentCheckRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentCheckServiceImpl implements PaymentCheckService {
    @Autowired
    PaymentCheckRespository paymentCheckRespository;
    @Override
    public PaymentCheck addPaymentCheck(PaymentCheck paymentCheck) {
        String paymentId = generateCustomId();
        paymentCheck.setId(paymentId);
        return paymentCheckRespository.save(paymentCheck);
    }
    private String generateCustomId() {
        PaymentCheck lastPayment= paymentCheckRespository.findTopByOrderByIdDesc();
        if (lastPayment != null) {
            String lastId = lastPayment.getId();
            String numericPart = lastId.substring(1); // Exclude the "C" character
            int numericValue = Integer.parseInt(numericPart) + 1;
            String newNumericPart = String.format("%04d", numericValue);
            return "N" + newNumericPart;
        } else {
            return "N0001"; // Initial ID if no users exist
        }
    }
    @Override
    public PaymentCheck addCreatedDateAndModifiedDatePaymentCheck(PaymentCheck paymentCheck) {

        return paymentCheckRespository.save(paymentCheck);
    }

    @Override
    public PaymentCheck updatePaymentCheck(String id, PaymentCheck paymentCheck) {
        PaymentCheck paymentCheck1=paymentCheckRespository.findById((id)).get();
        if (paymentCheck1 != null) {

            Logo logoImage = paymentCheck1.getLogo();
            if (logoImage == null) {
                logoImage = new Logo();
                paymentCheck1.setLogo(logoImage);
            }
            logoImage.setImage(paymentCheck.getLogo().getImage());
            logoImage.setName(paymentCheck.getLogo().getName());
            logoImage.setType(paymentCheck.getLogo().getType());

            CompanyName companyId = paymentCheck1.getCompanyId();
            if(companyId== null){
                companyId = new CompanyName();
                paymentCheck1.setCompanyId(companyId);
            }
            companyId.setCompanyName(paymentCheck.getCompanyId().getCompanyName());
            paymentCheck1.setContractId(paymentCheck.getContractId());
            paymentCheck1.setContractType(paymentCheck.getContractType());
            paymentCheck1.setIncome(paymentCheck.getIncome());
            paymentCheck1.setRemark(paymentCheck.getRemark());
            paymentCheck1.setMonth(paymentCheck.getMonth());
            paymentCheck1.setRoom(paymentCheck.getRoom());
            paymentCheck1.setStatus(paymentCheck.getStatus());
            paymentCheck1.setTenantName(paymentCheck.getTenantName());
            paymentCheck1.setPropertyName(paymentCheck.getPropertyName());
            paymentCheck1.setExpectedAmount(paymentCheck.getExpectedAmount());
            paymentCheck1.setOwnerName(paymentCheck.getOwnerName());

        }
        return paymentCheckRespository.save(paymentCheck1);
    }


}

package com.realestate.realestate.Service.Invoice;

import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements InvoiceServiceInterface{
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public Invoice addInvoice(Invoice invoice) {
        String customId=generateCustomId();

        //set the customID in the entity
        invoice.setId(customId);
        invoice.setStatus("未");
        return invoiceRepository.save(invoice);
    }
    private String generateCustomId() {
        Invoice lastContract = invoiceRepository.findTopByOrderByIdDesc();
        if (lastContract != null) {
            String lastId = lastContract.getId();
            String numericPart = lastId.substring(1); // Exclude the "C" character
            int numericValue = Integer.parseInt(numericPart) + 1;
            String newNumericPart = String.format("%04d", numericValue);
            return "I" + newNumericPart;
        } else {
            return "I0001"; // Initial ID if no users exist
        }
    }

    @Override
    public List<Contract> findContractsByBorrowerType(Long companyId) {
        return invoiceRepository.findContractsByBorrowerType(companyId);
    }

    @Override
    public List<Invoice> findInvoicesAndInvoiceListsByCompanyId(Long companyId) {
        System.out.println("Invoice List Service "+invoiceRepository.findInvoicesAndInvoiceListsByCompanyId(companyId));
        return invoiceRepository.findInvoicesAndInvoiceListsByCompanyId(companyId);
    }

    @Override
    public Invoice getInvoiceById(String id) {
        System.out.println("Invoice Detail page data included "+invoiceRepository.findById(id).get());
        return invoiceRepository.findById(id).get();
    }

    @Override
    public Invoice updateInvoice(String id, Invoice invoice) {

        Invoice invoice1 = invoiceRepository.findById(id).orElse(null);
        if (invoice1 != null) {
            CompanyName companyId = invoice1.getCompanyId();
            if (companyId == null) {
                companyId = new CompanyName();
                invoice1.setCompanyId(companyId);
            }
            companyId.setCompanyName(invoice.getCompanyId().getCompanyName());
            invoice1.setCompanyAddress(invoice.getCompanyAddress());
            invoice1.setPersonName(invoice.getPersonName());
            invoice1.setCompanyPostalFirst(invoice.getCompanyPostalFirst());
            invoice1.setCompanyPostalSecond(invoice.getCompanyPostalSecond());
            invoice1.setMobileFirst(invoice.getMobileFirst());
            invoice1.setMobileSecond(invoice.getMobileSecond());
            invoice1.setMobileThird(invoice.getMobileThird());
            invoice1.setLenderCooperate(invoice.getLenderCooperate());
            invoice1.setLenderPersonName(invoice.getLenderPersonName());
            invoice1.setBillingDate(invoice.getBillingDate());
            invoice1.setPaymentDueDate(invoice.getPaymentDueDate());
            invoice1.setPropertyName(invoice.getPropertyName());
            invoice1.setRoomNo(invoice.getRoomNo());
            invoice1.setFloor(invoice.getFloor());
            invoice1.setBuildingPostalFirst(invoice.getBuildingPostalFirst());
            invoice1.setBuildingPostalLast(invoice.getBuildingPostalLast());
            invoice1.setAddress(invoice.getAddress());
            invoice1.setInformation(invoice.getInformation());
            invoice1.setBankName(invoice.getBankName());
            invoice1.setBranchName(invoice.getBranchName());
            invoice1.setAccountName(invoice.getAccountName());
            invoice1.setAccountNo(invoice.getAccountNo());
            invoice1.setAccountType(invoice.getAccountType());


            InvoiceMoneyList invoiceMoneyList = invoice1.getInvoiceMoneyList();
            if (invoiceMoneyList == null) {
                invoiceMoneyList = new InvoiceMoneyList();
                invoice1.setInvoiceMoneyList(invoiceMoneyList);
            }
            invoiceMoneyList.setRent(invoice.getInvoiceMoneyList().getRent());
            invoiceMoneyList.setRentTax(invoice.getInvoiceMoneyList().getRentTax());
            invoiceMoneyList.setRentTotal(invoice.getInvoiceMoneyList().getRentTotal());
            invoiceMoneyList.setRentUsagePeriod(invoice.getInvoiceMoneyList().getRentUsagePeriod());
            invoiceMoneyList.setServiceFee(invoice.getInvoiceMoneyList().getServiceFee());
            invoiceMoneyList.setServiceFeeTax(invoice.getInvoiceMoneyList().getServiceFeeTax());
            invoiceMoneyList.setServiceFeeTotal(invoice.getInvoiceMoneyList().getServiceFeeTotal());
            invoiceMoneyList.setServiceFeeUsagePeriod(invoice.getInvoiceMoneyList().getServiceFeeUsagePeriod());
            invoiceMoneyList.setBrokerageFee(invoice.getInvoiceMoneyList().getBrokerageFee());
            invoiceMoneyList.setBrokerageFeeTax(invoice.getInvoiceMoneyList().getBrokerageFeeTax());
            invoiceMoneyList.setBrokerageFeeTotal(invoice.getInvoiceMoneyList().getBrokerageFeeTotal());
            invoiceMoneyList.setBrokerageFeeUsagePeriod(invoice.getInvoiceMoneyList().getBrokerageFeeUsagePeriod());
            invoiceMoneyList.setParkingFee(invoice.getInvoiceMoneyList().getParkingFee());
            invoiceMoneyList.setParkingFeeTax(invoice.getInvoiceMoneyList().getParkingFeeTax());
            invoiceMoneyList.setParkingFeeTotal(invoice.getInvoiceMoneyList().getParkingFeeTotal());
            invoiceMoneyList.setParkingStartDate(invoice.getInvoiceMoneyList().getParkingStartDate());
            invoiceMoneyList.setParkingEndDate(invoice.getInvoiceMoneyList().getParkingEndDate());
            invoiceMoneyList.setBicycleParkingFee(invoice.getInvoiceMoneyList().getBicycleParkingFee());
            invoiceMoneyList.setBicycleParkingFeeTax(invoice.getInvoiceMoneyList().getBicycleParkingFeeTax());
            invoiceMoneyList.setBicycleParkingFeeTotal(invoice.getInvoiceMoneyList().getBicycleParkingFeeTotal());
            invoiceMoneyList.setBicycleParkingStartDate(invoice.getInvoiceMoneyList().getBicycleParkingStartDate());
            invoiceMoneyList.setBicycleParkingEndDate(invoice.getInvoiceMoneyList().getBicycleParkingEndDate());
            invoiceMoneyList.setKeymoney(invoice.getInvoiceMoneyList().getKeymoney());
            invoiceMoneyList.setKeymoneyTax(invoice.getInvoiceMoneyList().getKeymoneyTax());
            invoiceMoneyList.setKeymoneyTotal(invoice.getInvoiceMoneyList().getKeymoneyTotal());
            invoiceMoneyList.setKeymoneyStartDate(invoice.getInvoiceMoneyList().getKeymoneyStartDate());
            invoiceMoneyList.setKeymoneyEndDate(invoice.getInvoiceMoneyList().getKeymoneyEndDate());
            invoiceMoneyList.setShikikin(invoice.getInvoiceMoneyList().getShikikin());
            invoiceMoneyList.setShikikinTax(invoice.getInvoiceMoneyList().getShikikinTax());
            invoiceMoneyList.setShikikinTotal(invoice.getInvoiceMoneyList().getShikikinTotal());
            invoiceMoneyList.setShikikinStartDate(invoice.getInvoiceMoneyList().getShikikinStartDate());
            invoiceMoneyList.setShikikinEndDate(invoice.getInvoiceMoneyList().getShikikinEndDate());
            invoiceMoneyList.setDeposit(invoice.getInvoiceMoneyList().getDeposit());
            invoiceMoneyList.setDepositTax(invoice.getInvoiceMoneyList().getDepositTax());
            invoiceMoneyList.setDepositTotal(invoice.getInvoiceMoneyList().getDepositTotal());
            invoiceMoneyList.setDepositStartDate(invoice.getInvoiceMoneyList().getDepositStartDate());
            invoiceMoneyList.setDepositEndDate(invoice.getInvoiceMoneyList().getDepositEndDate());
            invoiceMoneyList.setRenewalFee(invoice.getInvoiceMoneyList().getRenewalFee());
            invoiceMoneyList.setRenewalFeeTax(invoice.getInvoiceMoneyList().getRenewalFeeTax());
            invoiceMoneyList.setRenewalFeeTotal(invoice.getInvoiceMoneyList().getRenewalFeeTotal());
            invoiceMoneyList.setRenewalFeeStartDate(invoice.getInvoiceMoneyList().getRenewalFeeStartDate());
            invoiceMoneyList.setRenewalFeeEndDate(invoice.getInvoiceMoneyList().getRenewalFeeEndDate());
            invoiceMoneyList.setRepairCost(invoice.getInvoiceMoneyList().getRepairCost());
            invoiceMoneyList.setRepairCostTax(invoice.getInvoiceMoneyList().getRepairCostTax());
            invoiceMoneyList.setRepairCostTotal(invoice.getInvoiceMoneyList().getRepairCostTotal());
            invoiceMoneyList.setRepairCostStartDate(invoice.getInvoiceMoneyList().getRepairCostStartDate());
            invoiceMoneyList.setRepairCostEndDate(invoice.getInvoiceMoneyList().getRepairCostEndDate());
            invoiceMoneyList.setPenaltyFee(invoice.getInvoiceMoneyList().getPenaltyFee());
            invoiceMoneyList.setPenaltyFeeTax(invoice.getInvoiceMoneyList().getPenaltyFeeTax());
            invoiceMoneyList.setPenaltyFeeTotal(invoice.getInvoiceMoneyList().getPenaltyFeeTotal());
            invoiceMoneyList.setPenaltyFeeStartDate(invoice.getInvoiceMoneyList().getPenaltyFeeStartDate());
            invoiceMoneyList.setPenaltyFeeEndDate(invoice.getInvoiceMoneyList().getPenaltyFeeEndDate());
            invoiceMoneyList.setSignboard(invoice.getInvoiceMoneyList().getSignboard());
            invoiceMoneyList.setSignboardTax(invoice.getInvoiceMoneyList().getSignboardTax());
            invoiceMoneyList.setSignboardTotal(invoice.getInvoiceMoneyList().getSignboardTotal());
            invoiceMoneyList.setSignboardStartDate(invoice.getInvoiceMoneyList().getSignboardStartDate());
            invoiceMoneyList.setSignboardEndDate(invoice.getInvoiceMoneyList().getSignboardEndDate());
            invoiceMoneyList.setElectricBill(invoice.getInvoiceMoneyList().getElectricBill());
            invoiceMoneyList.setElectricBillTax(invoice.getInvoiceMoneyList().getElectricBillTax());
            invoiceMoneyList.setElectricBillTotal(invoice.getInvoiceMoneyList().getElectricBillTotal());
            invoiceMoneyList.setElectricUsageAmount(invoice.getInvoiceMoneyList().getElectricUsageAmount());
            invoiceMoneyList.setElectricBillStartDate(invoice.getInvoiceMoneyList().getElectricBillStartDate());
            invoiceMoneyList.setElectricBillEndDate(invoice.getInvoiceMoneyList().getElectricBillEndDate());
            invoiceMoneyList.setWaterBill(invoice.getInvoiceMoneyList().getWaterBill());
            invoiceMoneyList.setWaterBillTax(invoice.getInvoiceMoneyList().getWaterBillTax());
            invoiceMoneyList.setWaterBillTotal(invoice.getInvoiceMoneyList().getWaterBillTotal());
            invoiceMoneyList.setWaterUsageAmount(invoice.getInvoiceMoneyList().getWaterUsageAmount());
            invoiceMoneyList.setWaterBillStartDate(invoice.getInvoiceMoneyList().getWaterBillStartDate());
            invoiceMoneyList.setWaterBillEndDate(invoice.getInvoiceMoneyList().getWaterBillEndDate());
            invoiceMoneyList.setGasBill(invoice.getInvoiceMoneyList().getGasBill());
            invoiceMoneyList.setGasBillTax(invoice.getInvoiceMoneyList().getGasBillTax());
            invoiceMoneyList.setGasBillTotal(invoice.getInvoiceMoneyList().getGasBillTotal());
            invoiceMoneyList.setGasUsageAmount(invoice.getInvoiceMoneyList().getGasUsageAmount());
            invoiceMoneyList.setGasBillStartDate(invoice.getInvoiceMoneyList().getGasBillStartDate());
            invoiceMoneyList.setGasBillEndDate(invoice.getInvoiceMoneyList().getGasBillEndDate());
            invoiceMoneyList.setConstructionBill(invoice.getInvoiceMoneyList().getConstructionBill());
            invoiceMoneyList.setConstructionBillTax(invoice.getInvoiceMoneyList().getConstructionBillTax());
            invoiceMoneyList.setConstructionBillTotal(invoice.getInvoiceMoneyList().getConstructionBillTotal());
            invoiceMoneyList.setConstructionBillUsagePeriod(invoice.getInvoiceMoneyList().getConstructionBillUsagePeriod());
            invoiceMoneyList.setWorkNameFirst(invoice.getInvoiceMoneyList().getWorkNameFirst());
            invoiceMoneyList.setWorkAmountFirst(invoice.getInvoiceMoneyList().getWorkAmountFirst());
            invoiceMoneyList.setWorkTaxFirst(invoice.getInvoiceMoneyList().getWorkTaxFirst());
            invoiceMoneyList.setWorkAmountTotalFirst(invoice.getInvoiceMoneyList().getWorkAmountTotalFirst());
            invoiceMoneyList.setWorkUsagePeriodFirst(invoice.getInvoiceMoneyList().getWorkUsagePeriodFirst());
            invoiceMoneyList.setWorkNameSecond(invoice.getInvoiceMoneyList().getWorkNameSecond());
            invoiceMoneyList.setWorkAmountSecond(invoice.getInvoiceMoneyList().getWorkAmountSecond());
            invoiceMoneyList.setWorkTaxsecond(invoice.getInvoiceMoneyList().getWorkTaxsecond());
            invoiceMoneyList.setWorkTotalSecond(invoice.getInvoiceMoneyList().getWorkTotalSecond());
            invoiceMoneyList.setWorkUsagePeriodSecond(invoice.getInvoiceMoneyList().getWorkUsagePeriodSecond());
            invoiceMoneyList.setTotal(invoice.getInvoiceMoneyList().getTotal());

        }

        return invoiceRepository.save(invoice1);
    }

    @Override
    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
}

    public List<Property> findPropertiesByBorrowerType(Long companyId) {
        return invoiceRepository.findPropertiesByBorrowerType(companyId);
    }

    @Override
    public List<Invoice> findInvoiceByPropertyNameAndLenderPersonName(Long companyId, String propertyName, String lenderPersonName) {
        return invoiceRepository.findAllInvoiceByPropertyNameAndLenderPersonName(companyId,propertyName,lenderPersonName);
    }
}

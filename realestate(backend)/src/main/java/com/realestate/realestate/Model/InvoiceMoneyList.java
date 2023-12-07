package com.realestate.realestate.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Date;

@Entity
@Table(name = "invlist")
public class InvoiceMoneyList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
//   @JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyName companyId;

    @Column
    private BigDecimal rent;
    @Column
    private BigDecimal rentTax;
    @Column
    private BigDecimal rentTotal;
    @Column
    private String rentUsagePeriod;
    @Column
    private  BigDecimal brokerageFee;
    @Column
    private BigDecimal brokerageFeeTax;
    @Column
    private BigDecimal brokerageFeeTotal;
    @Column
    private String brokerageFeeUsagePeriod;
    @Column
    private  BigDecimal serviceFee;
    @Column
    private BigDecimal serviceFeeTax;
    @Column
    private BigDecimal serviceFeeTotal;
    @Column
    private String serviceFeeUsagePeriod;
    @Column
    private BigDecimal parkingFee;
    @Column
    private BigDecimal parkingFeeTax;
    @Column
    private BigDecimal parkingFeeTotal;
    @Column
    private String parkingStartDate;
    @Column
    private String parkingEndDate;
    @Column
    private BigDecimal bicycleParkingFee;
    @Column
    private BigDecimal bicycleParkingFeeTax;
    @Column
    private BigDecimal bicycleParkingFeeTotal;
    @Column
    private String bicycleParkingStartDate;
    @Column
    private String bicycleParkingEndDate;
    @Column
    private BigDecimal keymoney;
    @Column
    private BigDecimal keymoneyTax;
    @Column
    private BigDecimal keymoneyTotal;
    @Column
    private String keymoneyStartDate;
    @Column
    private String keymoneyEndDate;
    @Column
    private BigDecimal shikikin;
    @Column
    private BigDecimal shikikinTax;
    @Column
    private BigDecimal shikikinTotal;
    @Column
    private String shikikinStartDate;
    @Column
    private String shikikinEndDate;
    @Column
    private BigDecimal deposit;
    @Column
    private BigDecimal depositTax;
    @Column
    private BigDecimal depositTotal;
    @Column
    private String depositStartDate;
    @Column
    private String depositEndDate;
    @Column
    private BigDecimal renewalFee;
    @Column
    private BigDecimal renewalFeeTax;
    @Column
    private BigDecimal renewalFeeTotal;
    @Column
    private String renewalFeeStartDate;
    @Column
    private String renewalFeeEndDate;
    @Column
    private BigDecimal repairCost;
    @Column
    private BigDecimal repairCostTax;
    @Column
    private BigDecimal repairCostTotal;
    @Column
    private String repairCostStartDate;
    @Column
    private String repairCostEndDate;
    @Column
    private BigDecimal penaltyFee;
    @Column
    private BigDecimal penaltyFeeTax;
    @Column
    private BigDecimal penaltyFeeTotal;
    @Column
    private String penaltyFeeStartDate;
    @Column
    private String penaltyFeeEndDate;
    @Column
    private BigDecimal signboard;
    @Column
    private BigDecimal signboardTax;
    @Column
    private BigDecimal signboardTotal;
    @Column
    private String signboardStartDate;
    @Column
    private String signboardEndDate;
    @Column
    private BigDecimal electricBill;
    @Column
    private BigDecimal electricBillTax;
    @Column
    private BigDecimal electricUsageAmount;
    @Column
    private BigDecimal electricBillTotal;
    @Column
    private String electricBillStartDate;
    @Column
    private String electricBillEndDate;
    @Column
    private BigDecimal waterBill;
    @Column
    private BigDecimal waterBillTax;
    @Column
    private BigDecimal waterUsageAmount;
    @Column
    private BigDecimal waterBillTotal;
    @Column
    private String waterBillStartDate;
    @Column
    private String waterBillEndDate;
    @Column
    private BigDecimal gasBill;
    @Column
    private BigDecimal gasBillTax;
    @Column
    private BigDecimal gasUsageAmount;
    @Column
    private BigDecimal gasBillTotal;
    @Column
    private String gasBillStartDate;
    @Column
    private String gasBillEndDate;
    @Column
    private BigDecimal constructionBill;
    @Column
    private BigDecimal constructionBillTax;
    @Column
    private BigDecimal constructionBillTotal;
    @Column
    private String constructionBillUsagePeriod;
    @Column
    private String workNameFirst;
    @Column
    private BigDecimal workAmountFirst;
    @Column
    private BigDecimal workTaxFirst;
    @Column
    private BigDecimal workAmountTotalFirst;
    @Column
    private String workUsagePeriodFirst;
    @Column
    private String workNameSecond;
    @Column
    private BigDecimal workAmountSecond;
    @Column
    private BigDecimal workTaxsecond;
    @Column
    private BigDecimal workTotalSecond;
    @Column
    private String workUsagePeriodSecond;
    @Column
    private BigDecimal total;

    public InvoiceMoneyList() {
    }

    public InvoiceMoneyList(Long id, CompanyName companyId, BigDecimal rent, BigDecimal rentTax, BigDecimal rentTotal, String rentUsagePeriod,
                            BigDecimal brokerageFee, BigDecimal brokerageFeeTax, BigDecimal brokerageFeeTotal, String brokerageFeeUsagePeriod,
                            BigDecimal serviceFee, BigDecimal serviceFeeTax, BigDecimal serviceFeeTotal, String serviceFeeUsagePeriod,
                            BigDecimal parkingFee, BigDecimal parkingFeeTax, BigDecimal parkingFeeTotal, String parkingStartDate, String parkingEndDate,
                            BigDecimal bicycleParkingFee, BigDecimal bicycleParkingFeeTax, BigDecimal bicycleParkingFeeTotal, String bicycleParkingStartDate, String bicycleParkingEndDate,
                            BigDecimal keymoney, BigDecimal keymoneyTax, BigDecimal keymoneyTotal, String keymoneyStartDate, String keymoneyEndDate,
                            BigDecimal shikikin, BigDecimal shikikinTax, BigDecimal shikikinTotal, String shikikinStartDate, String shikikinEndDate,
                            BigDecimal deposit, BigDecimal depositTax, BigDecimal depositTotal, String depositStartDate, String depositEndDate,
                            BigDecimal renewalFee, BigDecimal renewalFeeTax, BigDecimal renewalFeeTotal, String renewalFeeStartDate, String renewalFeeEndDate,
                            BigDecimal repairCost, BigDecimal repairCostTax, BigDecimal repairCostTotal, String repairCostStartDate, String repairCostEndDate,
                            BigDecimal penaltyFee, BigDecimal penaltyFeeTax, BigDecimal penaltyFeeTotal, String penaltyFeeStartDate, String penaltyFeeEndDate,
                            BigDecimal signboard, BigDecimal signboardTax, BigDecimal signboardTotal, String signboardStartDate, String signboardEndDate,
                            BigDecimal electricBill, BigDecimal electricBillTax, BigDecimal electricUsageAmount, BigDecimal electricBillTotal, String electricBillStartDate, String electricBillEndDate,
                            BigDecimal waterBill, BigDecimal waterBillTax, BigDecimal waterUsageAmount, BigDecimal waterBillTotal, String waterBillStartDate, String waterBillEndDate,
                            BigDecimal gasBill, BigDecimal gasBillTax, BigDecimal gasUsageAmount, BigDecimal gasBillTotal, String gasBillStartDate, String gasBillEndDate,
                            BigDecimal constructionBill, BigDecimal constructionBillTax, BigDecimal constructionBillTotal, String constructionBillUsagePeriod,
                            String workNameFirst, BigDecimal workAmountFirst, BigDecimal workTaxFirst, BigDecimal workAmountTotalFirst, String workUsagePeriodFirst,
                            String workNameSecond, BigDecimal workAmountSecond, BigDecimal workTaxsecond, BigDecimal workTotalSecond, String workUsagePeriodSecond,
                            BigDecimal total) {
        this.id = id;
        this.companyId = companyId;
        this.rent = rent;
        this.rentTax = rentTax;
        this.rentTotal = rentTotal;
        this.rentUsagePeriod = rentUsagePeriod;
        this.brokerageFee = brokerageFee;
        this.brokerageFeeTax = brokerageFeeTax;
        this.brokerageFeeTotal = brokerageFeeTotal;
        this.brokerageFeeUsagePeriod = brokerageFeeUsagePeriod;
        this.serviceFee = serviceFee;
        this.serviceFeeTax = serviceFeeTax;
        this.serviceFeeTotal = serviceFeeTotal;
        this.serviceFeeUsagePeriod = serviceFeeUsagePeriod;
        this.parkingFee = parkingFee;
        this.parkingFeeTax = parkingFeeTax;
        this.parkingFeeTotal = parkingFeeTotal;
        this.parkingStartDate = parkingStartDate;
        this.parkingEndDate = parkingEndDate;
        this.bicycleParkingFee = bicycleParkingFee;
        this.bicycleParkingFeeTax = bicycleParkingFeeTax;
        this.bicycleParkingFeeTotal = bicycleParkingFeeTotal;
        this.bicycleParkingStartDate = bicycleParkingStartDate;
        this.bicycleParkingEndDate = bicycleParkingEndDate;
        this.keymoney = keymoney;
        this.keymoneyTax = keymoneyTax;
        this.keymoneyTotal = keymoneyTotal;
        this.keymoneyStartDate = keymoneyStartDate;
        this.keymoneyEndDate = keymoneyEndDate;
        this.shikikin = shikikin;
        this.shikikinTax = shikikinTax;
        this.shikikinTotal = shikikinTotal;
        this.shikikinStartDate = shikikinStartDate;
        this.shikikinEndDate = shikikinEndDate;
        this.deposit = deposit;
        this.depositTax = depositTax;
        this.depositTotal = depositTotal;
        this.depositStartDate = depositStartDate;
        this.depositEndDate = depositEndDate;
        this.renewalFee = renewalFee;
        this.renewalFeeTax = renewalFeeTax;
        this.renewalFeeTotal = renewalFeeTotal;
        this.renewalFeeStartDate = renewalFeeStartDate;
        this.renewalFeeEndDate = renewalFeeEndDate;
        this.repairCost = repairCost;
        this.repairCostTax = repairCostTax;
        this.repairCostTotal = repairCostTotal;
        this.repairCostStartDate = repairCostStartDate;
        this.repairCostEndDate = repairCostEndDate;
        this.penaltyFee = penaltyFee;
        this.penaltyFeeTax = penaltyFeeTax;
        this.penaltyFeeTotal = penaltyFeeTotal;
        this.penaltyFeeStartDate = penaltyFeeStartDate;
        this.penaltyFeeEndDate = penaltyFeeEndDate;
        this.signboard = signboard;
        this.signboardTax = signboardTax;
        this.signboardTotal = signboardTotal;
        this.signboardStartDate = signboardStartDate;
        this.signboardEndDate = signboardEndDate;
        this.electricBill = electricBill;
        this.electricBillTax = electricBillTax;
        this.electricUsageAmount = electricUsageAmount;
        this.electricBillTotal = electricBillTotal;
        this.electricBillStartDate = electricBillStartDate;
        this.electricBillEndDate = electricBillEndDate;
        this.waterBill = waterBill;
        this.waterBillTax = waterBillTax;
        this.waterUsageAmount = waterUsageAmount;
        this.waterBillTotal = waterBillTotal;
        this.waterBillStartDate = waterBillStartDate;
        this.waterBillEndDate = waterBillEndDate;
        this.gasBill = gasBill;
        this.gasBillTax = gasBillTax;
        this.gasUsageAmount = gasUsageAmount;
        this.gasBillTotal = gasBillTotal;
        this.gasBillStartDate = gasBillStartDate;
        this.gasBillEndDate = gasBillEndDate;
        this.constructionBill = constructionBill;
        this.constructionBillTax = constructionBillTax;
        this.constructionBillTotal = constructionBillTotal;
        this.constructionBillUsagePeriod = constructionBillUsagePeriod;
        this.workNameFirst = workNameFirst;
        this.workAmountFirst = workAmountFirst;
        this.workTaxFirst = workTaxFirst;
        this.workAmountTotalFirst = workAmountTotalFirst;
        this.workUsagePeriodFirst = workUsagePeriodFirst;
        this.workNameSecond = workNameSecond;
        this.workAmountSecond = workAmountSecond;
        this.workTaxsecond = workTaxsecond;
        this.workTotalSecond = workTotalSecond;
        this.workUsagePeriodSecond = workUsagePeriodSecond;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyName getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyName companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigDecimal getRentTax() {
        return rentTax;
    }

    public void setRentTax(BigDecimal rentTax) {
        this.rentTax = rentTax;
    }

    public BigDecimal getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(BigDecimal rentTotal) {
        this.rentTotal = rentTotal;
    }

    public String getRentUsagePeriod() {
        return rentUsagePeriod;
    }

    public void setRentUsagePeriod(String rentUsagePeriod) {
        this.rentUsagePeriod = rentUsagePeriod;
    }

    public BigDecimal getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(BigDecimal brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public BigDecimal getBrokerageFeeTax() {
        return brokerageFeeTax;
    }

    public void setBrokerageFeeTax(BigDecimal brokerageFeeTax) {
        this.brokerageFeeTax = brokerageFeeTax;
    }

    public BigDecimal getBrokerageFeeTotal() {
        return brokerageFeeTotal;
    }

    public void setBrokerageFeeTotal(BigDecimal brokerageFeeTotal) {
        this.brokerageFeeTotal = brokerageFeeTotal;
    }

    public String getBrokerageFeeUsagePeriod() {
        return brokerageFeeUsagePeriod;
    }

    public void setBrokerageFeeUsagePeriod(String brokerageFeeUsagePeriod) {
        this.brokerageFeeUsagePeriod = brokerageFeeUsagePeriod;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getServiceFeeTax() {
        return serviceFeeTax;
    }

    public void setServiceFeeTax(BigDecimal serviceFeeTax) {
        this.serviceFeeTax = serviceFeeTax;
    }

    public BigDecimal getServiceFeeTotal() {
        return serviceFeeTotal;
    }

    public void setServiceFeeTotal(BigDecimal serviceFeeTotal) {
        this.serviceFeeTotal = serviceFeeTotal;
    }

    public String getServiceFeeUsagePeriod() {
        return serviceFeeUsagePeriod;
    }

    public void setServiceFeeUsagePeriod(String serviceFeeUsagePeriod) {
        this.serviceFeeUsagePeriod = serviceFeeUsagePeriod;
    }

    public BigDecimal getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(BigDecimal parkingFee) {
        this.parkingFee = parkingFee;
    }

    public BigDecimal getParkingFeeTax() {
        return parkingFeeTax;
    }

    public void setParkingFeeTax(BigDecimal parkingFeeTax) {
        this.parkingFeeTax = parkingFeeTax;
    }

    public BigDecimal getParkingFeeTotal() {
        return parkingFeeTotal;
    }

    public void setParkingFeeTotal(BigDecimal parkingFeeTotal) {
        this.parkingFeeTotal = parkingFeeTotal;
    }

    public String getParkingStartDate() {
        return parkingStartDate;
    }

    public void setParkingStartDate(String parkingStartDate) {
        this.parkingStartDate = parkingStartDate;
    }

    public String getParkingEndDate() {
        return parkingEndDate;
    }

    public void setParkingEndDate(String parkingEndDate) {
        this.parkingEndDate = parkingEndDate;
    }

    public BigDecimal getBicycleParkingFee() {
        return bicycleParkingFee;
    }

    public void setBicycleParkingFee(BigDecimal bicycleParkingFee) {
        this.bicycleParkingFee = bicycleParkingFee;
    }

    public BigDecimal getBicycleParkingFeeTax() {
        return bicycleParkingFeeTax;
    }

    public void setBicycleParkingFeeTax(BigDecimal bicycleParkingFeeTax) {
        this.bicycleParkingFeeTax = bicycleParkingFeeTax;
    }

    public BigDecimal getBicycleParkingFeeTotal() {
        return bicycleParkingFeeTotal;
    }

    public void setBicycleParkingFeeTotal(BigDecimal bicycleParkingFeeTotal) {
        this.bicycleParkingFeeTotal = bicycleParkingFeeTotal;
    }

    public String getBicycleParkingStartDate() {
        return bicycleParkingStartDate;
    }

    public void setBicycleParkingStartDate(String bicycleParkingStartDate) {
        this.bicycleParkingStartDate = bicycleParkingStartDate;
    }

    public String getBicycleParkingEndDate() {
        return bicycleParkingEndDate;
    }

    public void setBicycleParkingEndDate(String bicycleParkingEndDate) {
        this.bicycleParkingEndDate = bicycleParkingEndDate;
    }

    public BigDecimal getKeymoney() {
        return keymoney;
    }

    public void setKeymoney(BigDecimal keymoney) {
        this.keymoney = keymoney;
    }

    public BigDecimal getKeymoneyTax() {
        return keymoneyTax;
    }

    public void setKeymoneyTax(BigDecimal keymoneyTax) {
        this.keymoneyTax = keymoneyTax;
    }

    public BigDecimal getKeymoneyTotal() {
        return keymoneyTotal;
    }

    public void setKeymoneyTotal(BigDecimal keymoneyTotal) {
        this.keymoneyTotal = keymoneyTotal;
    }

    public String getKeymoneyStartDate() {
        return keymoneyStartDate;
    }

    public void setKeymoneyStartDate(String keymoneyStartDate) {
        this.keymoneyStartDate = keymoneyStartDate;
    }

    public String getKeymoneyEndDate() {
        return keymoneyEndDate;
    }

    public void setKeymoneyEndDate(String keymoneyEndDate) {
        this.keymoneyEndDate = keymoneyEndDate;
    }

    public BigDecimal getShikikin() {
        return shikikin;
    }

    public void setShikikin(BigDecimal shikikin) {
        this.shikikin = shikikin;
    }

    public BigDecimal getShikikinTax() {
        return shikikinTax;
    }

    public void setShikikinTax(BigDecimal shikikinTax) {
        this.shikikinTax = shikikinTax;
    }

    public BigDecimal getShikikinTotal() {
        return shikikinTotal;
    }

    public void setShikikinTotal(BigDecimal shikikinTotal) {
        this.shikikinTotal = shikikinTotal;
    }

    public String getShikikinStartDate() {
        return shikikinStartDate;
    }

    public void setShikikinStartDate(String shikikinStartDate) {
        this.shikikinStartDate = shikikinStartDate;
    }

    public String getShikikinEndDate() {
        return shikikinEndDate;
    }

    public void setShikikinEndDate(String shikikinEndDate) {
        this.shikikinEndDate = shikikinEndDate;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getDepositTax() {
        return depositTax;
    }

    public void setDepositTax(BigDecimal depositTax) {
        this.depositTax = depositTax;
    }

    public BigDecimal getDepositTotal() {
        return depositTotal;
    }

    public void setDepositTotal(BigDecimal depositTotal) {
        this.depositTotal = depositTotal;
    }

    public String getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(String depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public String getDepositEndDate() {
        return depositEndDate;
    }

    public void setDepositEndDate(String depositEndDate) {
        this.depositEndDate = depositEndDate;
    }

    public BigDecimal getRenewalFee() {
        return renewalFee;
    }

    public void setRenewalFee(BigDecimal renewalFee) {
        this.renewalFee = renewalFee;
    }

    public BigDecimal getRenewalFeeTax() {
        return renewalFeeTax;
    }

    public void setRenewalFeeTax(BigDecimal renewalFeeTax) {
        this.renewalFeeTax = renewalFeeTax;
    }

    public BigDecimal getRenewalFeeTotal() {
        return renewalFeeTotal;
    }

    public void setRenewalFeeTotal(BigDecimal renewalFeeTotal) {
        this.renewalFeeTotal = renewalFeeTotal;
    }

    public String getRenewalFeeStartDate() {
        return renewalFeeStartDate;
    }

    public void setRenewalFeeStartDate(String renewalFeeStartDate) {
        this.renewalFeeStartDate = renewalFeeStartDate;
    }

    public String getRenewalFeeEndDate() {
        return renewalFeeEndDate;
    }

    public void setRenewalFeeEndDate(String renewalFeeEndDate) {
        this.renewalFeeEndDate = renewalFeeEndDate;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public BigDecimal getRepairCostTax() {
        return repairCostTax;
    }

    public void setRepairCostTax(BigDecimal repairCostTax) {
        this.repairCostTax = repairCostTax;
    }

    public BigDecimal getRepairCostTotal() {
        return repairCostTotal;
    }

    public void setRepairCostTotal(BigDecimal repairCostTotal) {
        this.repairCostTotal = repairCostTotal;
    }

    public String getRepairCostStartDate() {
        return repairCostStartDate;
    }

    public void setRepairCostStartDate(String repairCostStartDate) {
        this.repairCostStartDate = repairCostStartDate;
    }

    public String getRepairCostEndDate() {
        return repairCostEndDate;
    }

    public void setRepairCostEndDate(String repairCostEndDate) {
        this.repairCostEndDate = repairCostEndDate;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public BigDecimal getPenaltyFeeTax() {
        return penaltyFeeTax;
    }

    public void setPenaltyFeeTax(BigDecimal penaltyFeeTax) {
        this.penaltyFeeTax = penaltyFeeTax;
    }

    public BigDecimal getPenaltyFeeTotal() {
        return penaltyFeeTotal;
    }

    public void setPenaltyFeeTotal(BigDecimal penaltyFeeTotal) {
        this.penaltyFeeTotal = penaltyFeeTotal;
    }

    public String getPenaltyFeeStartDate() {
        return penaltyFeeStartDate;
    }

    public void setPenaltyFeeStartDate(String penaltyFeeStartDate) {
        this.penaltyFeeStartDate = penaltyFeeStartDate;
    }

    public String getPenaltyFeeEndDate() {
        return penaltyFeeEndDate;
    }

    public void setPenaltyFeeEndDate(String penaltyFeeEndDate) {
        this.penaltyFeeEndDate = penaltyFeeEndDate;
    }

    public BigDecimal getSignboard() {
        return signboard;
    }

    public void setSignboard(BigDecimal signboard) {
        this.signboard = signboard;
    }

    public BigDecimal getSignboardTax() {
        return signboardTax;
    }

    public void setSignboardTax(BigDecimal signboardTax) {
        this.signboardTax = signboardTax;
    }

    public BigDecimal getSignboardTotal() {
        return signboardTotal;
    }

    public void setSignboardTotal(BigDecimal signboardTotal) {
        this.signboardTotal = signboardTotal;
    }

    public String getSignboardStartDate() {
        return signboardStartDate;
    }

    public void setSignboardStartDate(String signboardStartDate) {
        this.signboardStartDate = signboardStartDate;
    }

    public String getSignboardEndDate() {
        return signboardEndDate;
    }

    public void setSignboardEndDate(String signboardEndDate) {
        this.signboardEndDate = signboardEndDate;
    }

    public BigDecimal getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(BigDecimal electricBill) {
        this.electricBill = electricBill;
    }

    public BigDecimal getElectricBillTax() {
        return electricBillTax;
    }

    public void setElectricBillTax(BigDecimal electricBillTax) {
        this.electricBillTax = electricBillTax;
    }

    public BigDecimal getElectricUsageAmount() {
        return electricUsageAmount;
    }

    public void setElectricUsageAmount(BigDecimal electricUsageAmount) {
        this.electricUsageAmount = electricUsageAmount;
    }

    public BigDecimal getElectricBillTotal() {
        return electricBillTotal;
    }

    public void setElectricBillTotal(BigDecimal electricBillTotal) {
        this.electricBillTotal = electricBillTotal;
    }

    public String getElectricBillStartDate() {
        return electricBillStartDate;
    }

    public void setElectricBillStartDate(String electricBillStartDate) {
        this.electricBillStartDate = electricBillStartDate;
    }

    public String getElectricBillEndDate() {
        return electricBillEndDate;
    }

    public void setElectricBillEndDate(String electricBillEndDate) {
        this.electricBillEndDate = electricBillEndDate;
    }

    public BigDecimal getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(BigDecimal waterBill) {
        this.waterBill = waterBill;
    }

    public BigDecimal getWaterBillTax() {
        return waterBillTax;
    }

    public void setWaterBillTax(BigDecimal waterBillTax) {
        this.waterBillTax = waterBillTax;
    }

    public BigDecimal getWaterUsageAmount() {
        return waterUsageAmount;
    }

    public void setWaterUsageAmount(BigDecimal waterUsageAmount) {
        this.waterUsageAmount = waterUsageAmount;
    }

    public BigDecimal getWaterBillTotal() {
        return waterBillTotal;
    }

    public void setWaterBillTotal(BigDecimal waterBillTotal) {
        this.waterBillTotal = waterBillTotal;
    }

    public String getWaterBillStartDate() {
        return waterBillStartDate;
    }

    public void setWaterBillStartDate(String waterBillStartDate) {
        this.waterBillStartDate = waterBillStartDate;
    }

    public String getWaterBillEndDate() {
        return waterBillEndDate;
    }

    public void setWaterBillEndDate(String waterBillEndDate) {
        this.waterBillEndDate = waterBillEndDate;
    }

    public BigDecimal getGasBill() {
        return gasBill;
    }

    public void setGasBill(BigDecimal gasBill) {
        this.gasBill = gasBill;
    }

    public BigDecimal getGasBillTax() {
        return gasBillTax;
    }

    public void setGasBillTax(BigDecimal gasBillTax) {
        this.gasBillTax = gasBillTax;
    }

    public BigDecimal getGasUsageAmount() {
        return gasUsageAmount;
    }

    public void setGasUsageAmount(BigDecimal gasUsageAmount) {
        this.gasUsageAmount = gasUsageAmount;
    }

    public BigDecimal getGasBillTotal() {
        return gasBillTotal;
    }

    public void setGasBillTotal(BigDecimal gasBillTotal) {
        this.gasBillTotal = gasBillTotal;
    }

    public String getGasBillStartDate() {
        return gasBillStartDate;
    }

    public void setGasBillStartDate(String gasBillStartDate) {
        this.gasBillStartDate = gasBillStartDate;
    }

    public String getGasBillEndDate() {
        return gasBillEndDate;
    }

    public void setGasBillEndDate(String gasBillEndDate) {
        this.gasBillEndDate = gasBillEndDate;
    }

    public BigDecimal getConstructionBill() {
        return constructionBill;
    }

    public void setConstructionBill(BigDecimal constructionBill) {
        this.constructionBill = constructionBill;
    }

    public BigDecimal getConstructionBillTax() {
        return constructionBillTax;
    }

    public void setConstructionBillTax(BigDecimal constructionBillTax) {
        this.constructionBillTax = constructionBillTax;
    }

    public BigDecimal getConstructionBillTotal() {
        return constructionBillTotal;
    }

    public void setConstructionBillTotal(BigDecimal constructionBillTotal) {
        this.constructionBillTotal = constructionBillTotal;
    }

    public String getConstructionBillUsagePeriod() {
        return constructionBillUsagePeriod;
    }

    public void setConstructionBillUsagePeriod(String constructionBillUsagePeriod) {
        this.constructionBillUsagePeriod = constructionBillUsagePeriod;
    }

    public String getWorkNameFirst() {
        return workNameFirst;
    }

    public void setWorkNameFirst(String workNameFirst) {
        this.workNameFirst = workNameFirst;
    }

    public BigDecimal getWorkAmountFirst() {
        return workAmountFirst;
    }

    public void setWorkAmountFirst(BigDecimal workAmountFirst) {
        this.workAmountFirst = workAmountFirst;
    }

    public BigDecimal getWorkTaxFirst() {
        return workTaxFirst;
    }

    public void setWorkTaxFirst(BigDecimal workTaxFirst) {
        this.workTaxFirst = workTaxFirst;
    }

    public BigDecimal getWorkAmountTotalFirst() {
        return workAmountTotalFirst;
    }

    public void setWorkAmountTotalFirst(BigDecimal workAmountTotalFirst) {
        this.workAmountTotalFirst = workAmountTotalFirst;
    }

    public String getWorkUsagePeriodFirst() {
        return workUsagePeriodFirst;
    }

    public void setWorkUsagePeriodFirst(String workUsagePeriodFirst) {
        this.workUsagePeriodFirst = workUsagePeriodFirst;
    }

    public String getWorkNameSecond() {
        return workNameSecond;
    }

    public void setWorkNameSecond(String workNameSecond) {
        this.workNameSecond = workNameSecond;
    }

    public BigDecimal getWorkAmountSecond() {
        return workAmountSecond;
    }

    public void setWorkAmountSecond(BigDecimal workAmountSecond) {
        this.workAmountSecond = workAmountSecond;
    }

    public BigDecimal getWorkTaxsecond() {
        return workTaxsecond;
    }

    public void setWorkTaxsecond(BigDecimal workTaxsecond) {
        this.workTaxsecond = workTaxsecond;
    }

    public BigDecimal getWorkTotalSecond() {
        return workTotalSecond;
    }

    public void setWorkTotalSecond(BigDecimal workTotalSecond) {
        this.workTotalSecond = workTotalSecond;
    }

    public String getWorkUsagePeriodSecond() {
        return workUsagePeriodSecond;
    }

    public void setWorkUsagePeriodSecond(String workUsagePeriodSecond) {
        this.workUsagePeriodSecond = workUsagePeriodSecond;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

package com.realestate.realestate.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.*;
import java.util.Date;

@Entity
@Table(name = "property")
public class Property {

    //    basic information
    @Id
    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @ManyToOne
//    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyName companyId;

    @Column
    private String propertyType;
    @Column
    private String status;
    @Column
    private String propertyName;
    @Column
    private String propertyKana;
    @Column
    private String room;

    @Column
    private String floor;
    @Column
    private String mobileFirst;
    @Column
    private String mobileSecond;
    @Column
    private String mobileThird;
    //    @Column
//    private String situation;
    @Column
    private String ownerName;
    @Column
    private  String ownerKana;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserInfo owner;
    @Column
    private String picName;

    @ManyToOne
    @JoinColumn(name = "pic_id")
    private UserInfo pic;
    //    address-information
    @Column
    private String postalFirst;
    @Column
    private String postalLast;
    @Column
    private String address;
    @Column
    private String line1;
    @Column
    private String station1;
    @Column
    private String line2;
    @Column
    private String station2;
    @Column
    private String busStop1;
    @Column
    private String busStop2;
    @Column
    private String ride1;
    @Column
    private String stroll1;
    @Column
    private String ride2;
    @Column
    private String stroll2;

    //    monetary-infomation





    @Column
    private  BigDecimal taxRate;
    @Column
    private BigDecimal rentTsubo;
    @Column
    private BigDecimal totalRent;
    @Column
    private String rentTax;
    @Column
    private  BigDecimal serviceFeesTsubo;
    @Column
    private  BigDecimal serviceFeesTotal;
    @Column
    private  String serviceFeesTax;
    @Column
    private  BigDecimal parkingFees;
    @Column
    private String parkingFeesTax;
    @Column
    private BigDecimal repairExpenses;
    @Column
    private  String repairTax;
    @Column
    private  BigDecimal deposit;
    @Column
    private String depositTax;
    @Column
    private  BigDecimal keyMoney;
    @Column
    private String keyMoneyTax;
    @Column
    private  BigDecimal toalDeposit;
    @Column
    private String toalDepositTax;
    @Column
    private  BigDecimal restorationFees;
    @Column
    private  String restorationFeesTax;
    @Column
    private  boolean restorationStatus;
    @Column
    private  BigDecimal fireInsuranceFees;
    @Column
    private  String fireInsuranceFeesTax;
    @Column
    private  BigDecimal insuranceYears;
    @Column
    private  BigDecimal renewalFees;
    @Column
    private  String renewalFeesTax;
    @Column
    private  BigDecimal signboardFees;
    @Column
    private  String signboardFeesTax;

    @Column
    private BigDecimal consumptionTax;



    //    detail information
    @Column
    private String ground;
    @Column
    private String underground;
    @Column
    private String structure;
    @Column
    private boolean elevator;
    @Column
    private YearMonth buildingDate;
    @Column
    private boolean newBuild;
    @Column
    private String buildNo;
    @Column
    private String exclusiveArea;
    @Column
    private String exclusiveStatus;
    @Column
    private String layout;
    @Column
    private String layoutStatus;
    @Column
    private String totalUnits;
    @Column
    private String layoutRemarks;

    @Column
    private String classification;
    @Column
    private  BigDecimal  areaMeter;
    @Column
    private  BigDecimal areaTsubo;



    //    equipment information
    @Column
    private String waterSupply;
    @Column
    private String gas;
    @Column
    private String electricity;
    @Column
    private String drainage;
    @Column
    private String pets;
    @Column
    private String diy;

    //    other information
    @Column
    private Boolean bathToilet;
    @Column
    private Boolean lightning;
    @Column
    private Boolean doorPhone;
    @Column
    private Boolean shower;
    @Column
    private Boolean furniture;
    @Column
    private Boolean twoFamily;
    @Column
    private Boolean publicBath;
    @Column
    private Boolean indoorBath;
    @Column
    private Boolean loft;
    @Column
    private Boolean internet;
    @Column
    private Boolean catv;
    @Column
    private Boolean flooring;
    @Column
    private Boolean allElectric;
    @Column
    private Boolean csAntenna;
    @Column
    private Boolean aircon;
    @Column

    private Boolean counterKitchen;
    @Column
    private Boolean bsAntenna;
    @Column
    private Boolean parking;
    @Column
    private Boolean systemKitchen;
    @Column
    private Boolean autoLock;
    @Column
    private Boolean deliveryBox;
    @Column
    private Boolean homeTel;
    @Column
    private Boolean balcony;
    @Column
    private Boolean rosette;

    //    photo information
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id",referencedColumnName = "id")
    private PropertyImage propertyImage;


    //    management-infomation
    @Column
    private String managerName;

    @Column
    private String manageCompany;
    @Column
    private String managementForm;
    @Column
    private String constructCompany;
    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_dt")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;


    public Property(){}
    @PrePersist
    protected void onCreate() {
//        LocalDateTime created = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
//        createdDate = Date.from(created.atZone(ZoneId.systemDefault()).toInstant());
//        LocalDateTime modified = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
//        modifiedDate = Date.from(modified.atZone(ZoneId.systemDefault()).toInstant());
        createdDate = new Date();
        modifiedDate = new Date();

    }

    public PMReport getPmReport() {
        return pmReport;
    }

    public void setPmReport(PMReport pmReport) {
        this.pmReport = pmReport;
    }

    @ManyToOne
    @JoinColumn(name = "pm_report_id")
    private PMReport pmReport;

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }
    public String getId() {
        return Id;
    }

    public CompanyName getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyName companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOwnerKana() {
        return ownerKana;
    }

    public void setOwnerKana(String ownerKana) {
        this.ownerKana = ownerKana;
    }

    public UserInfo getOwner() {
        return owner;
    }

    public void setOwner(UserInfo owner) {
        this.owner = owner;
    }

    public UserInfo getPic() {
        return pic;
    }

    public void setPic(UserInfo pic) {
        this.pic = pic;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyKana() {
        return propertyKana;
    }

    public void setPropertyKana(String propertyKana) {
        this.propertyKana = propertyKana;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMobileFirst() {
        return mobileFirst;
    }

    public void setMobileFirst(String mobileFirst) {
        this.mobileFirst = mobileFirst;
    }

    public String getMobileSecond() {
        return mobileSecond;
    }

    public void setMobileSecond(String mobileSecond) {
        this.mobileSecond = mobileSecond;
    }

    public String getMobileThird() {
        return mobileThird;
    }

    public void setMobileThird(String mobileThird) {
        this.mobileThird = mobileThird;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPostalFirst() {
        return postalFirst;
    }

    public void setPostalFirst(String postalFirst) {
        this.postalFirst = postalFirst;
    }

    public String getPostalLast() {
        return postalLast;
    }

    public void setPostalLast(String postalLast) {
        this.postalLast = postalLast;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getStation1() {
        return station1;
    }

    public void setStation1(String station1) {
        this.station1 = station1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getStation2() {
        return station2;
    }

    public void setStation2(String station2) {
        this.station2 = station2;
    }

    public String getBusStop1() {
        return busStop1;
    }

    public void setBusStop1(String busStop1) {
        this.busStop1 = busStop1;
    }

    public String getBusStop2() {
        return busStop2;
    }

    public void setBusStop2(String busStop2) {
        this.busStop2 = busStop2;
    }

    public String getRide1() {
        return ride1;
    }

    public void setRide1(String ride1) {
        this.ride1 = ride1;
    }

    public String getStroll1() {
        return stroll1;
    }

    public void setStroll1(String stroll1) {
        this.stroll1 = stroll1;
    }

    public String getRide2() {
        return ride2;
    }

    public void setRide2(String ride2) {
        this.ride2 = ride2;
    }

    public String getStroll2() {
        return stroll2;
    }

    public void setStroll2(String stroll2) {
        this.stroll2 = stroll2;
    }

    public BigDecimal getRentTsubo() {
        return rentTsubo;
    }

    public void setRentTsubo(BigDecimal rentTsubo) {
        this.rentTsubo = rentTsubo;
    }

    public BigDecimal getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(BigDecimal totalRent) {
        this.totalRent = totalRent;
    }

    public String getRentTax() {
        return rentTax;
    }

    public void setRentTax(String rentTax) {
        this.rentTax = rentTax;
    }

    public BigDecimal getServiceFeesTsubo() {
        return serviceFeesTsubo;
    }

    public void setServiceFeesTsubo(BigDecimal serviceFeesTsubo) {
        this.serviceFeesTsubo = serviceFeesTsubo;
    }

    public BigDecimal getServiceFeesTotal() {
        return serviceFeesTotal;
    }

    public void setServiceFeesTotal(BigDecimal serviceFeesTotal) {
        this.serviceFeesTotal = serviceFeesTotal;
    }

    public String getServiceFeesTax() {
        return serviceFeesTax;
    }

    public void setServiceFeesTax(String serviceFeesTax) {
        this.serviceFeesTax = serviceFeesTax;
    }

    public BigDecimal getParkingFees() {
        return parkingFees;
    }

    public void setParkingFees(BigDecimal parkingFees) {
        this.parkingFees = parkingFees;
    }

    public String getParkingFeesTax() {
        return parkingFeesTax;
    }

    public void setParkingFeesTax(String parkingFeesTax) {
        this.parkingFeesTax = parkingFeesTax;
    }

    public BigDecimal getRepairExpenses() {
        return repairExpenses;
    }

    public void setRepairExpenses(BigDecimal repairExpenses) {
        this.repairExpenses = repairExpenses;
    }

    public String getRepairTax() {
        return repairTax;
    }

    public void setRepairTax(String repairTax) {
        this.repairTax = repairTax;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getDepositTax() {
        return depositTax;
    }

    public void setDepositTax(String depositTax) {
        this.depositTax = depositTax;
    }

    public BigDecimal getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(BigDecimal keyMoney) {
        this.keyMoney = keyMoney;
    }

    public String getKeyMoneyTax() {
        return keyMoneyTax;
    }

    public void setKeyMoneyTax(String keyMoneyTax) {
        this.keyMoneyTax = keyMoneyTax;
    }

    public BigDecimal getToalDeposit() {
        return toalDeposit;
    }

    public void setToalDeposit(BigDecimal toalDeposit) {
        this.toalDeposit = toalDeposit;
    }

    public String getToalDepositTax() {
        return toalDepositTax;
    }

    public void setToalDepositTax(String toalDepositTax) {
        this.toalDepositTax = toalDepositTax;
    }

    public BigDecimal getRestorationFees() {
        return restorationFees;
    }

    public void setRestorationFees(BigDecimal restorationFees) {
        this.restorationFees = restorationFees;
    }

    public String getRestorationFeesTax() {
        return restorationFeesTax;
    }

    public void setRestorationFeesTax(String restorationFeesTax) {
        this.restorationFeesTax = restorationFeesTax;
    }

    public boolean isRestorationStatus() {
        return restorationStatus;
    }

    public void setRestorationStatus(boolean restorationStatus) {
        this.restorationStatus = restorationStatus;
    }

    public BigDecimal getFireInsuranceFees() {
        return fireInsuranceFees;
    }

    public void setFireInsuranceFees(BigDecimal fireInsuranceFees) {
        this.fireInsuranceFees = fireInsuranceFees;
    }

    public String getFireInsuranceFeesTax() {
        return fireInsuranceFeesTax;
    }

    public void setFireInsuranceFeesTax(String fireInsuranceFeesTax) {
        this.fireInsuranceFeesTax = fireInsuranceFeesTax;
    }

    public BigDecimal getInsuranceYears() {
        return insuranceYears;
    }

    public void setInsuranceYears(BigDecimal insuranceYears) {
        this.insuranceYears = insuranceYears;
    }

    public BigDecimal getRenewalFees() {
        return renewalFees;
    }

    public void setRenewalFees(BigDecimal renewalFees) {
        this.renewalFees = renewalFees;
    }

    public String getRenewalFeesTax() {
        return renewalFeesTax;
    }

    public void setRenewalFeesTax(String renewalFeesTax) {
        this.renewalFeesTax = renewalFeesTax;
    }

    public BigDecimal getSignboardFees() {
        return signboardFees;
    }

    public void setSignboardFees(BigDecimal signboardFees) {
        this.signboardFees = signboardFees;
    }

    public String getSignboardFeesTax() {
        return signboardFeesTax;
    }

    public void setSignboardFeesTax(String signboardFeesTax) {
        this.signboardFeesTax = signboardFeesTax;
    }

    public BigDecimal getConsumptionTax() {
        return consumptionTax;
    }

    public void setConsumptionTax(BigDecimal consumptionTax) {
        this.consumptionTax = consumptionTax;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getUnderground() {
        return underground;
    }

    public void setUnderground(String underground) {
        this.underground = underground;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public YearMonth  getBuildingDate() {
        return buildingDate;
    }

    public void setBuildingDate(YearMonth  buildingDate) {
        this.buildingDate = buildingDate;
    }

    public boolean isNewBuild() {
        return newBuild;
    }

    public void setNewBuild(boolean newBuild) {
        this.newBuild = newBuild;
    }

    public String getBuildNo() {
        return buildNo;
    }

    public void setBuildNo(String buildNo) {
        this.buildNo = buildNo;
    }

    public String getExclusiveArea() {
        return exclusiveArea;
    }

    public void setExclusiveArea(String exclusiveArea) {
        this.exclusiveArea = exclusiveArea;
    }

    public String getExclusiveStatus() {
        return exclusiveStatus;
    }

    public void setExclusiveStatus(String exclusiveStatus) {
        this.exclusiveStatus = exclusiveStatus;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getLayoutStatus() {
        return layoutStatus;
    }

    public void setLayoutStatus(String layoutStatus) {
        this.layoutStatus = layoutStatus;
    }

    public String getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(String totalUnits) {
        this.totalUnits = totalUnits;
    }

    public String getLayoutRemarks() {
        return layoutRemarks;
    }

    public void setLayoutRemarks(String layoutRemarks) {
        this.layoutRemarks = layoutRemarks;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public BigDecimal getAreaMeter() {
        return areaMeter;
    }

    public void setAreaMeter(BigDecimal areaMeter) {
        this.areaMeter = areaMeter;
    }

    public BigDecimal getAreaTsubo() {
        return areaTsubo;
    }

    public void setAreaTsubo(BigDecimal areaTsubo) {
        this.areaTsubo = areaTsubo;
    }

    public String getWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(String waterSupply) {
        this.waterSupply = waterSupply;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    public String getDrainage() {
        return drainage;
    }

    public void setDrainage(String drainage) {
        this.drainage = drainage;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getDiy() {
        return diy;
    }

    public void setDiy(String diy) {
        this.diy = diy;
    }

    public Boolean getBathToilet() {
        return bathToilet;
    }

    public void setBathToilet(Boolean bathToilet) {
        this.bathToilet = bathToilet;
    }

    public Boolean getLightning() {
        return lightning;
    }

    public void setLightning(Boolean lightning) {
        this.lightning = lightning;
    }

    public Boolean getDoorPhone() {
        return doorPhone;
    }

    public void setDoorPhone(Boolean doorPhone) {
        this.doorPhone = doorPhone;
    }

    public Boolean getShower() {
        return shower;
    }

    public void setShower(Boolean shower) {
        this.shower = shower;
    }

    public Boolean getFurniture() {
        return furniture;
    }

    public void setFurniture(Boolean furniture) {
        this.furniture = furniture;
    }

    public Boolean getTwoFamily() {
        return twoFamily;
    }

    public void setTwoFamily(Boolean twoFamily) {
        this.twoFamily = twoFamily;
    }

    public Boolean getPublicBath() {
        return publicBath;
    }

    public void setPublicBath(Boolean publicBath) {
        this.publicBath = publicBath;
    }

    public Boolean getIndoorBath() {
        return indoorBath;
    }

    public void setIndoorBath(Boolean indoorBath) {
        this.indoorBath = indoorBath;
    }

    public Boolean getLoft() {
        return loft;
    }

    public void setLoft(Boolean loft) {
        this.loft = loft;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Boolean getCatv() {
        return catv;
    }

    public void setCatv(Boolean catv) {
        this.catv = catv;
    }

    public Boolean getFlooring() {
        return flooring;
    }

    public void setFlooring(Boolean flooring) {
        this.flooring = flooring;
    }

    public Boolean getAllElectric() {
        return allElectric;
    }

    public void setAllElectric(Boolean allElectric) {
        this.allElectric = allElectric;
    }

    public Boolean getCsAntenna() {
        return csAntenna;
    }

    public void setCsAntenna(Boolean csAntenna) {
        this.csAntenna = csAntenna;
    }

    public Boolean getAircon() {
        return aircon;
    }

    public void setAircon(Boolean aircon) {
        this.aircon = aircon;
    }

    public Boolean getCounterKitchen() {
        return counterKitchen;
    }

    public void setCounterKitchen(Boolean counterKitchen) {
        this.counterKitchen = counterKitchen;
    }

    public Boolean getBsAntenna() {
        return bsAntenna;
    }

    public void setBsAntenna(Boolean bsAntenna) {
        this.bsAntenna = bsAntenna;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getSystemKitchen() {
        return systemKitchen;
    }

    public void setSystemKitchen(Boolean systemKitchen) {
        this.systemKitchen = systemKitchen;
    }

    public Boolean getAutoLock() {
        return autoLock;
    }

    public void setAutoLock(Boolean autoLock) {
        this.autoLock = autoLock;
    }

    public Boolean getDeliveryBox() {
        return deliveryBox;
    }

    public void setDeliveryBox(Boolean deliveryBox) {
        this.deliveryBox = deliveryBox;
    }

    public Boolean getHomeTel() {
        return homeTel;
    }

    public void setHomeTel(Boolean homeTel) {
        this.homeTel = homeTel;
    }

    public Boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
    }

    public Boolean getRosette() {
        return rosette;
    }

    public void setRosette(Boolean rosette) {
        this.rosette = rosette;
    }

    public PropertyImage getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(PropertyImage propertyImage) {
        this.propertyImage = propertyImage;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManageCompany() {
        return manageCompany;
    }

    public void setManageCompany(String manageCompany) {
        this.manageCompany = manageCompany;
    }

    public String getManagementForm() {
        return managementForm;
    }

    public void setManagementForm(String managementForm) {
        this.managementForm = managementForm;
    }

    public String getConstructCompany() {
        return constructCompany;
    }

    public void setConstructCompany(String constructCompany) {
        this.constructCompany = constructCompany;
    }
}

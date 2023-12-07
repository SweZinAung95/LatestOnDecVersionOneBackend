package com.realestate.realestate.Service.Property;

import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyServiceImpl implements  PropertyService{
    @Autowired
    PropertyRepository propertyRepository;


    @Override
    public Property addProperty(Property property) {


//        return propertyRepository.save(property);
        String customId = generateCustomId();

        // Set the custom ID in the entity
        property.setId(customId);

        // Save the Property entity
        return propertyRepository.save(property);
    }

    private String generateCustomId() {
        // Implement custom ID generation logic here
        // For example, query the database for the last used ID and format it
        // You can also use other custom logic
        // Here's a simplified example:
        Property lastProperty = propertyRepository.findTopByOrderByIdDesc();
        if (lastProperty != null) {
            // Extract the numeric part and increment it
            String lastId = lastProperty.getId();
//            String numericPart = lastId.substring(lastId.lastIndexOf('-') + 1);
//            int numericValue = Integer.parseInt(numericPart) + 1;
//
//            // Format the new numeric part with leading zeros
            String numericPart = lastId.substring(1); // Exclude the "U" character
            int numericValue = Integer.parseInt(numericPart) + 1;
            String newNumericPart = String.format("%04d", numericValue);
//            String newNumericPart = String.format("%04d", numericValue);

            return "P" + newNumericPart;
        } else {
            return "P0001";
        }
    }

    @Override
    public List<Property> getProperty() {
        return (List<Property>)propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(String id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public Property updateProperty(String id, Property property) {
//        Property property1 = propertyRepository.findById(id).get();


        Property property1 = propertyRepository.findById(id).orElse(null);

        if (property1 != null) {
            CompanyName companyId = property1.getCompanyId();
            if(companyId== null){
                companyId = new CompanyName();
                property1.setCompanyId(companyId);
            }
            companyId.setCompanyName(property.getCompanyId().getCompanyName());
            property1.setPropertyType(property.getPropertyType());
        property1.setMobileFirst(property.getMobileFirst());
        property1.setMobileSecond(property.getMobileSecond());
        property1.setMobileThird(property.getMobileThird());
//        property1.setSituation(property.getSituation());
        property1.setOwner(property.getOwner());
        property1.setOwnerName(property.getOwnerName());

        property1.setOwnerKana(property.getOwnerKana());
        property1.setPic(property.getPic());
        property1.setPicName(property.getPicName());
        property1.setMobileFirst(property.getMobileFirst());
        property1.setMobileSecond(property.getMobileSecond());
        property1.setMobileThird(property.getMobileThird());
        property1.setPropertyName(property.getPropertyName());
        property1.setPropertyKana(property.getPropertyKana());
        property1.setRoom(property.getRoom());
        property1.setStatus(property.getStatus());
        property1.setFloor(property.getFloor());

        property1.setPostalFirst(property.getPostalFirst());
        property.setPostalLast(property.getPostalLast());
        property1.setAddress(property.getAddress());
        property1.setLine1(property.getLine1());
        property1.setStation1(property.getStation1());
        property1.setLine2(property.getLine2());
        property1.setStation2(property.getStation2());
        property1.setBusStop1(property.getBusStop1());
        property1.setBusStop2(property.getBusStop2());
        property1.setRide1(property.getRide1());
        property1.setStroll1(property.getStroll1());
        property1.setRide2(property.getRide2());
        property1.setStroll2(property.getStroll2());


        property1.setRentTsubo(property.getRentTsubo());
        property1.setTotalRent(property.getTotalRent());
        property1.setRentTax(property.getRentTax());

        property1.setServiceFeesTsubo(property.getServiceFeesTsubo());
        property1.setServiceFeesTotal(property.getServiceFeesTotal());
        property1.setServiceFeesTax(property.getServiceFeesTax());

        property1.setParkingFees(property.getParkingFees());
        property1.setParkingFeesTax(property.getParkingFeesTax());

        property1.setRepairTax(property.getRepairTax());
        property1.setRepairExpenses(property.getRepairExpenses());

        property1.setDeposit(property.getDeposit());
        property1.setDepositTax(property.getDepositTax());

        property1.setKeyMoney(property.getKeyMoney());
        property1.setKeyMoneyTax(property.getKeyMoneyTax());

        property1.setToalDeposit(property.getToalDeposit());
        property1.setToalDepositTax(property.getToalDepositTax());

        property1.setRestorationFees(property.getRestorationFees());
        property1.setRestorationFeesTax(property.getRestorationFeesTax());
        property1.setRestorationStatus(property.isRestorationStatus());

        property1.setFireInsuranceFees(property.getFireInsuranceFees());
        property1.setFireInsuranceFeesTax(property.getFireInsuranceFeesTax());
        property1.setInsuranceYears(property.getInsuranceYears());
//        property1.setInsuranceYears(property.getInsuranceYears());
        property1.setRenewalFees(property.getRenewalFees());
        property1.setRenewalFeesTax(property.getRenewalFeesTax());



        property1.setSignboardFees(property.getSignboardFees());
        property1.setSignboardFeesTax(property.getSignboardFeesTax());
        property1.setConsumptionTax(property.getConsumptionTax());

        property1.setGround(property.getGround());
        property1.setUnderground(property.getUnderground());
        property1.setElevator(property.isElevator());
        property1.setStructure(property.getStructure());
        property1.setBuildingDate(property.getBuildingDate());
//        property1.setBuildingDate(property.getBuildingDate());
        property1.setNewBuild(property.isNewBuild());
        property1.setBuildNo(property.getBuildNo());

        property1.setExclusiveArea(property.getExclusiveArea());
        property1.setExclusiveStatus(property.getExclusiveStatus());
        property1.setLayout(property.getLayout());
        property1.setLayoutStatus(property.getLayoutStatus());
        property1.setTotalUnits(property.getTotalUnits());
        property1.setLayoutRemarks(property.getLayoutRemarks());

        property1.setWaterSupply(property.getWaterSupply());
        property1.setGas(property.getGas());
        property1.setElectricity(property.getElectricity());
        property1.setDrainage(property.getDrainage());
        property1.setPets(property.getPets());
        property1.setDiy(property.getDiy());
        property1.setClassification((property.getClassification()));
        property1.setAreaMeter(property.getAreaMeter());
        property1.setAreaTsubo(property.getAreaTsubo());

        property1.setBathToilet(property.getBathToilet());
        property1.setLightning(property.getLightning());
        property1.setDoorPhone(property.getDoorPhone());
        property1.setShower(property.getShower());
        property1.setFurniture(property.getFurniture());
        property1.setTwoFamily(property.getTwoFamily());
        property1.setPublicBath(property.getPublicBath());
        property1.setIndoorBath(property.getIndoorBath());
        property1.setLoft(property.getLoft());
        property1.setInternet(property.getInternet());
        property1.setCatv(property.getCatv());
        property1.setFlooring(property.getFlooring());
        property1.setAllElectric(property.getAllElectric());
        property1.setCsAntenna(property.getCsAntenna());
        property1.setAircon(property.getAircon());
        property1.setCounterKitchen(property.getCounterKitchen());
        property1.setBsAntenna(property.getBsAntenna());
        property1.setParking(property.getParking());
        property1.setSystemKitchen(property.getSystemKitchen());
        property1.setAutoLock(property.getAutoLock());
        property1.setDeliveryBox(property.getDeliveryBox());
        property1.setHomeTel(property.getHomeTel());
        property1.setBalcony(property.getBalcony());
        property1.setRosette(property.getRosette());



        property1.setManagerName(property.getManagerName());
        property1.setManageCompany(property.getManageCompany());
        property1.setConstructCompany(property.getConstructCompany());
        property1.setManagementForm(property.getManagementForm());


            // ... (other properties)

            // Get the existing PropertyImage or create a new one if it doesn't exist
            PropertyImage propertyImage = property1.getPropertyImage();
            if (propertyImage == null) {
                propertyImage = new PropertyImage();
                property1.setPropertyImage(propertyImage);
            }

            // Update properties of the PropertyImage entity
            propertyImage.setName1(property.getPropertyImage().getName1());
            propertyImage.setType1(property.getPropertyImage().getType1());
            propertyImage.setImage1(property.getPropertyImage().getImage1());
            propertyImage.setName2(property.getPropertyImage().getName2());
            propertyImage.setType2(property.getPropertyImage().getType2());
            propertyImage.setImage2(property.getPropertyImage().getImage2());
            propertyImage.setName3(property.getPropertyImage().getName3());
            propertyImage.setType3(property.getPropertyImage().getType3());
            propertyImage.setImage3(property.getPropertyImage().getImage3());
            propertyImage.setName4(property.getPropertyImage().getName4());
            propertyImage.setType4(property.getPropertyImage().getType4());
            propertyImage.setImage4(property.getPropertyImage().getImage4());
            propertyImage.setName5(property.getPropertyImage().getName5());
            propertyImage.setType5(property.getPropertyImage().getType5());
            propertyImage.setImage5(property.getPropertyImage().getImage5());
            propertyImage.setName6(property.getPropertyImage().getName6());
            propertyImage.setType6(property.getPropertyImage().getType6());
            propertyImage.setImage6(property.getPropertyImage().getImage6());
            propertyImage.setName7(property.getPropertyImage().getName7());
            propertyImage.setType7(property.getPropertyImage().getType7());
            propertyImage.setImage7(property.getPropertyImage().getImage7());
            propertyImage.setName8(property.getPropertyImage().getName8());
            propertyImage.setType8(property.getPropertyImage().getType8());
            propertyImage.setImage8(property.getPropertyImage().getImage8());
        }


        return propertyRepository.save(property1);
    }

    @Override
    public void deleteProperty(String id) {
      propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> searchEntities(String propertyName, String propertyType) {
        return propertyRepository.searchEntities(propertyName,propertyType);
    }

//    @Override
//    public List<Property> findAllPropertiesByCompanyName(String companyName) {
//  return propertyRepository.findAllPropertiesByCompanyName(companyName);
//    }

    @Override
    public List<Property> findAllPropertiesByCompanyId(Long companyId) {
        return propertyRepository.findAllPropertiesByCompanyId(companyId);
    }

    @Override
    public List<Property> findAllOwnersByCompanyIdWithPropertyId(Long companyId, String propertyName) {
        return propertyRepository.findAllOwnersByCompanyIdWithPropertyId(companyId,propertyName);
    }

    //請求書物件情報のため使う機能
}

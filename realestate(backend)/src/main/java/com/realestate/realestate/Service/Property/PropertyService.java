package com.realestate.realestate.Service.Property;

import com.realestate.realestate.Model.Property;
import com.realestate.realestate.Model.UserInfo;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PropertyService {
    public Property addProperty(Property property);
    public List<Property> getProperty();
    public Property getPropertyById(String id);
    public Property updateProperty(String id , Property property);

    public void deleteProperty(String id);
    public  List<Property>searchEntities(String propertyName,String propertyType);
//    public List<Property> findAllPropertiesByCompanyName(String companyName);
    public List<Property> findAllPropertiesByCompanyId(Long companyId);
    public List<Property> findAllOwnersByCompanyIdWithPropertyId(Long companyId,String propertyName);

}

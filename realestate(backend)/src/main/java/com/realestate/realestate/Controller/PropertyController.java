package com.realestate.realestate.Controller;

import com.realestate.realestate.Model.CompanyName;
import com.realestate.realestate.Model.Property;
import com.realestate.realestate.Model.PropertyImage;
import com.realestate.realestate.Model.UserInfo;
import com.realestate.realestate.Repository.CompanyRepository;
import com.realestate.realestate.Service.Property.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class PropertyController {
    @Autowired
    private  PropertyService propertyService;
    @Autowired
    private CompanyRepository companyRepository;
//#spring.servlet.multipart.max-file-size=18MB
//#spring.servlet.multipart.max-request-size=18MB

    @PostMapping(value = "/addProperty",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Property addProperty(@RequestPart("property") Property property,
                                @RequestPart("image1") MultipartFile image1,
                                @RequestPart("image2") MultipartFile image2,
                                @RequestPart("image3") MultipartFile image3,
                                @RequestPart("image4") MultipartFile image4,
                                @RequestPart("image5") MultipartFile image5,
                                @RequestPart("image6") MultipartFile image6,
                                @RequestPart("image7") MultipartFile image7,
                                @RequestPart("image8") MultipartFile image8,
                                @RequestParam("companyId") Long companyId){
        try {
            System.out.print("Image1 Size"+image1.getSize());
            PropertyImage propertyImage = uploadImage(image1, image2,image3,image4,image5,image6,image7,image8);
            property.setPropertyImage(propertyImage);
            CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
            if(existingCompany !=null){
                property.setCompanyId(existingCompany);
            }
            return propertyService.addProperty(property);
        } catch (Exception e) {
            System.out.println(image1.getSize());
            System.out.println(image2.getSize());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PropertyImage uploadImage(MultipartFile image1, MultipartFile image2,MultipartFile image3,
                                     MultipartFile image4,MultipartFile image5,MultipartFile image6,
                                     MultipartFile image7,MultipartFile image8) throws IOException {
        System.out.println(image1.getSize());
        PropertyImage propertyImage = new PropertyImage(

                image1.getOriginalFilename(),
                image1.getContentType(),

                image1.getBytes(),
                image2.getOriginalFilename(),
                image2.getContentType(),

                image2.getBytes(),
                image3.getOriginalFilename(),
                image3.getContentType(),

                image3.getBytes(),

                image4.getOriginalFilename(),
                image4.getContentType(),

                image4.getBytes(),

                image5.getOriginalFilename(),
                image5.getContentType(),

                image5.getBytes(),
                image6.getOriginalFilename(),
                image6.getContentType(),

                image6.getBytes(),
                image7.getOriginalFilename(),
                image7.getContentType(),

                image7.getBytes(),
                image8.getOriginalFilename(),
                image8.getContentType(),

                image8.getBytes()


        );
        return propertyImage;
    }

    @GetMapping("/properties")
    public List<Property> getProperty(){
        System.out.println("Properties..");
        return propertyService.getProperty();
    }

    @GetMapping("/property/{id}")
    public Property getPropertyById(@PathVariable("id") String id){

        return propertyService.getPropertyById(id);
    }

    //    @PutMapping("/updateProperty/{id}")
//    public Property updateProperty(@PathVariable("id") long id, @RequestBody Property property){
//        Property updatedProperty=propertyService.updateProperty(id, property);
//        return updatedProperty;
//    }
    @PutMapping("/updateProperty/{id}")
    public Property updateProperty(  @PathVariable("id") String id,
                                     @RequestPart("property") Property property,
                                     @RequestPart("image1") MultipartFile image1,
                                     @RequestPart("image2") MultipartFile image2,
                                     @RequestPart("image3") MultipartFile image3,
                                     @RequestPart("image4") MultipartFile image4,
                                     @RequestPart("image5") MultipartFile image5,
                                     @RequestPart("image6") MultipartFile image6,
                                     @RequestPart("image7") MultipartFile image7,
                                     @RequestPart("image8") MultipartFile image8){
        try {
            PropertyImage propertyImage = uploadImage(image1, image2,image3,image4,image5,image6,image7,image8);
            property.setPropertyImage(propertyImage);
            return propertyService.updateProperty(id, property);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //    @DeleteMapping("/deleteProperty/{id}")
//    public String deleteProperty(@PathVariable("id") long id){
//        try {
//            propertyService.deleteProperty(id);
//            return "Property Deleted Successfully...";
//        }catch (DataIntegrityViolationException e) {
//            return  "Cannot delete property due to foreign key references.";
//        }
//
//    }
    @DeleteMapping("/deleteProperty/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable String id) {
        try {
            propertyService.deleteProperty(id);
            return ResponseEntity.ok().build(); // Return a 200 OK response
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Cannot delete property due to foreign key references.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //public ResponseEntity<String> deleteUser(@PathVariable long id) {
//    try {
//        propertyService.deleteProperty(id);
//
//        return ResponseEntity.ok("Property deleted successfully");
//    } catch (DataIntegrityViolationException e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Cannot delete property due to foreign key references.");
//    } catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("An error occurred while deleting the property.");
//    }
//}
    @GetMapping("/search")
    public List<Property>searchEntities(String propertyName, String propertyType
    ) {
        List<Property> filteredEntities = propertyService.searchEntities(propertyName, propertyType);
        return filteredEntities;
    }

//    @GetMapping("/propertiesByCompanyName/{companyName}")
//    public List<Property> getPropertiesByCompanyName(
//            @PathVariable("companyName") String companyName) {
//        System.out.println(companyName);
//        List<Property> properties= propertyService.findAllPropertiesByCompanyName(companyName);
//        return properties;
//
//    }
    @GetMapping("/propertiesByCompanyId/{companyId}")
    public List<Property> getPropertiesByCompanyId(
            @PathVariable("companyId") Long companyId) {
        System.out.println(companyId);
        List<Property> properties= propertyService.findAllPropertiesByCompanyId(companyId);
        return properties;

    }


    public List<UserInfo> getOwnersByCompanyIdWithPropertyName(
            @RequestParam("companyId") Long companyId,
            @RequestParam("propertyName") String propertyName) {
        List<Property> properties = propertyService.findAllOwnersByCompanyIdWithPropertyId(companyId,
                propertyName);

        // Assuming Property has a reference to an Owner entity, you can extract the owners from the properties
        List<UserInfo> owners = properties.stream()
                .map(Property::getOwner)
                .collect(Collectors.toList());

        return owners;
    }

}

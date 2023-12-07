package com.realestate.realestate.Controller;

import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.CompanyRepository;
import com.realestate.realestate.Repository.LogoRepository;
import com.realestate.realestate.Service.UserInfo.UserInfoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@EnableJpaRepositories
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    LogoRepository logoRepository;
    @Autowired
    CompanyRepository companyRepository;
    @PostConstruct
    public void initRoleAndUser() {
        userInfoService.initRoleAndUser();
    }
    @PostMapping(value = "/addCreatedDateAndModifiedDate")
    public UserInfo addCreatedDateAndModifiedDate(@RequestBody UserInfo userInfo){
        userInfo.setCreatedDate(new Date());
        userInfo.setModifiedDate(new Date());
        UserInfo userInfo1= userInfoService.addCreatedDateAndModifiedDate(userInfo);
        return  userInfo1;
    }

//    @PostMapping("/createUserInfo")
//    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
//        System.out.println(userInfo);
//
//        UserInfo user= userInfoService.addUserInfo(userInfo);
//        return user;
//    }

    //adding manager user data
    @PostMapping(value = "/createManagerInfo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserInfo addManagerInfo(@RequestPart("manager") UserInfo managerInfo,
                                   @RequestPart("logo") MultipartFile logo,
                                   @RequestPart("companyId")CompanyName companyId) {
        try {


            Logo logoImage = uploadImage(logo);

            CompanyName companyName = saveCompanyName(companyId);
            companyRepository.save(companyName);
            logoRepository.save(logoImage);
            managerInfo.setLogo(logoImage);
            managerInfo.setCompanyId(companyName);

            return userInfoService.addUserInfo(managerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private CompanyName saveCompanyName(CompanyName companyId) {
        CompanyName companyName = new CompanyName(companyId.getId(),companyId.getCompanyName());


        return companyName;
    }

    private Logo uploadImage(MultipartFile logo)  throws IOException {
        Logo logoImage = new Logo(
                logo.getOriginalFilename(),
                logo.getContentType(),

                logo.getBytes()
        );

        return  logoImage;
    }

//adding user data

    @PostMapping(value = "/createUserInfo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserInfo addUserInfo(
            @RequestPart("user") UserInfo userInfo,
            @RequestParam("logoId") Long logoId,
            @RequestParam("companyId") Long companyId
    ) {
        try {
            System.out.println("Logoid"+logoId);
            System.out.println("Hello"+companyId);
            CompanyName existingCompany =companyRepository.findById(companyId).orElse(null);
            if(existingCompany !=null){
                userInfo.setCompanyId(existingCompany);
            }
            if(logoId!=null){
                Logo existingLogo = logoRepository.findById(logoId).orElse(null);
                if (existingLogo != null) {
                    userInfo.setLogo(existingLogo);
                }


            }
            else{

            }
            return userInfoService.addUserInfo(userInfo);


        } catch (Exception e) {
            System.out.println(companyId.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //adding owner data
    @PostMapping(value = "/createOwnerInfo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserInfo addOwnerInfo(
            @RequestPart("owner") UserInfo ownerInfo,
            @RequestParam("logoId") Long logoId,
            @RequestParam("companyId") Long companyId // Extract the logo ID from the request
    ) {
        try {
            CompanyName existingCompany = companyRepository.findById(companyId).orElse(null);

            if(existingCompany !=null){
                ownerInfo.setCompanyId(existingCompany);
            }

            Logo existingLogo = logoRepository.findById(logoId).orElse(null);
            if (existingLogo != null) {
                ownerInfo.setLogo(existingLogo);
            }



            return userInfoService.addUserInfo(ownerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/userLogin")
    public ResponseEntity<LoginResponses> login(@RequestBody LoginRequest loginRequest) {
        //int id = loginRequest.getId();
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // Call AuthService to authenticate the user
        UserInfo user = userInfoService.checkEmailAndPassword(email, password);

        if (user != null) {
            // Create a response object with user type and send it back
            String id1 =user.getId();
            String userType = user.getRoleType();
            Logo logo = user.getLogo();
            CompanyName companyName = user.getCompanyId();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String phone1 = user.getPhone1();
            String phone2 = user.getPhone2();
            String phone3 = user.getPhone3();
            return ResponseEntity.ok(new LoginResponses(id1,userType,logo,companyName,firstName,lastName,phone1,phone2,phone3));
        } else {
            // User authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping(value = "/forgotPassword")
    public ResponseEntity<UserInfo> forgotPassword(@RequestBody String email) {


        // Call AuthService to authenticate the user
        UserInfo user = userInfoService.checkEmail(email);

        if (user != null) {
            // Create a response object with user type and send it back
            String id1 = user.getId();
            String email1 = user.getEmail();
            UserInfo userInfo= userInfoService.getUserById(id1);
            return ResponseEntity.ok(userInfo);
        } else {
            // User authentication on failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/owners")
    public List<UserInfo> getOwners(){
        return userInfoService.getOwners();
    }
    @GetMapping("/pics")
    public List<UserInfo> getPICUsers(){
        return userInfoService.getPICUsers();
    }

    @GetMapping("/manager")
    public List<UserInfo> getManagerUsers(){
        return userInfoService.getManager();
    }

    @GetMapping("/user/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") String id){

        return userInfoService.getUserById(id);
    }

    @PutMapping("/updateUser/{id}")
    public UserInfo updateUser(@PathVariable("id") String id, @RequestBody UserInfo userInfo){
        UserInfo updatedUser=userInfoService.updateUserInfo(id, userInfo);
        return updatedUser;
    }

    //    請求書画面の所属会社の郵便番号と住所ための機能 Line 224~227
    @GetMapping("/userAddressByCompanyId/{id}")
    public List<UserInfo> getUserAddressInfoByCompanyId(@PathVariable("id") Long id){
        System.out.println("User address "+userInfoService.getUserAddressByCompanyId(id));
        return userInfoService.getUserAddressByCompanyId(id);
    }
    @PutMapping("/updateManager/{id}")
    public UserInfo updateManager(  @PathVariable("id") String id,
                                     @RequestPart("manager") UserInfo userInfo,
                                     @RequestPart("logo") MultipartFile logo
                                    ){
        try {
            Logo logoImage = uploadImage(logo);
            userInfo.setLogo(logoImage);
            return userInfoService.updateUserInfo(id, userInfo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            userInfoService.deleteUserInfo(id);
            return ResponseEntity.ok().build(); // Return a 200 OK response
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Cannot delete property due to foreign key references.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @GetMapping("/usersByCompanyName/{companyName}")
//    public List<UserInfo> getUsersByCompanyName
//            (
//            @PathVariable("companyName") String companyName) {
//        System.out.println(companyName);
//        List<UserInfo> users = userInfoService.getUsersByCompanyName(companyName);
//        return users;
//
//    }

//    updated today
    @GetMapping("/usersByCompanyId/{companyId}")
    public List<UserInfo> getUsersByCompanyId
            (
                    @PathVariable("companyId") Long companyId) {
        System.out.println(companyId);
        List<UserInfo> users = userInfoService.getUsersByCompanyId(companyId);
        return users;

    }
    @GetMapping("/ownersByCompanyId/{companyId}")
    public List<UserInfo> getOwnersByCompanyId
            (
                    @PathVariable("companyId") Long companyId) {
        System.out.println(companyId);
        List<UserInfo> users = userInfoService.getOwnersByCompanyId(companyId);
        return users;

    }
//    @GetMapping("/ownersByCompanyIdWithPropertyId/{companyId/propertyId}")
//    public List<UserInfo> getOwnersByCompanyIdWithPropertyId
//            (
//                    @PathVariable("companyId") Long companyId,
//                    @PathVariable("propertyId") Long propertyId) {
//        System.out.println(companyId);
//        List<UserInfo> users = userInfoService.getOwnersByCompanyId(companyId);
//        return users;
//
//    }
//    @GetMapping("/managersByCompanyName/{companyName}")
//    public List<UserInfo> getManagersByCompanyName(
//            @PathVariable("companyName") String companyName) {
//        System.out.println(companyName);
//        List<UserInfo> users = userInfoService.getManagersByCompanyName(companyName);
//        return users;
//
//    }
//    @GetMapping("/ownersByCompanyName/{companyName}")
//    public List<UserInfo> getOwnersByCompanyName(
//            @PathVariable("companyName") String companyName) {
//        System.out.println(companyName);
//        List<UserInfo> users = userInfoService.getOwnersByCompanyName(companyName);
//        return users;
//
//    }
}
package com.realestate.realestate.Service.UserInfo;

import com.realestate.realestate.Model.*;
import com.realestate.realestate.Repository.CompanyRepository;
import com.realestate.realestate.Repository.LogoRepository;
import com.realestate.realestate.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class UserInfoService implements UserInfoServiceInterface{
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private LogoRepository logoRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public UserInfo addUserInfo(UserInfo userInfo) {

//        return userInfoRepository.save(userInfo);
        String customId = generateCustomId();

        // Set the custom ID in the entity
        userInfo.setId(customId);

        // Save the Property entity
        return userInfoRepository.save(userInfo);
    }

//    private String generateCustomId() {
//        // Implement custom ID generation logic here
//        // For example, query the database for the last used ID and format it
//        // You can also use other custom logic
//        // Here's a simplified example:
//        UserInfo lastUser = userInfoRepository.findTopByOrderByIdDesc();
//        if (lastUser != null) {
//            // Extract the numeric part and increment it
//            String lastId = lastUser.getId();
//            String numericPart = lastId.substring(lastId.lastIndexOf('-') + 1);
//            int numericValue = Integer.parseInt(numericPart) + 1;
//
//            // Format the new numeric part with leading zeros
//            String newNumericPart = String.format("%04d", numericValue);
//
//            return "U" + newNumericPart;
//        } else {
//            return "error";
//        }
//    }
   private String generateCustomId() {
    UserInfo lastUser = userInfoRepository.findTopByOrderByIdDesc();
    if (lastUser != null) {
        String lastId = lastUser.getId();
        String numericPart = lastId.substring(1); // Exclude the "U" character
        int numericValue = Integer.parseInt(numericPart) + 1;
        String newNumericPart = String.format("%04d", numericValue);
        return "U" + newNumericPart;
    } else {
        return "U0001"; // Initial ID if no users exist
    }
}

    @Override
    public UserInfo checkEmailAndPassword(String email, String password) {
        UserInfo user = userInfoRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public UserInfo addCreatedDateAndModifiedDate(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);    }

    @Override
    public boolean checkIfDataExists() {
        return userInfoRepository.existsByEmail("admin@gmail.com");    }

    @Override
    public UserInfo checkEmail(String email) {
        UserInfo user = userInfoRepository.findByEmail(email);
        if (user != null) {
            return user;
        }
        // Return null if user not found or password does not match
        return null;
    }

//    public void initRoleAndUser() {
//        if (!checkIfDataExists()) {
//            UserInfo adminUser = new UserInfo();
//            adminUser.setFirstName("Admin");
//            adminUser.setFirstNamekana("Admin");
//            adminUser.setLastName("John");
//            adminUser.setLastNamekana("John");
//            adminUser.setEmail("admin@gmail.com");
//            adminUser.setPassword("1234567890");
//            adminUser.setRoleType("admin");
//            adminUser.setCompanyName("株式会社ウィッツテクノロジー");
//
//            userInfoRepository.save(adminUser);
//        }
//
//    }
    public void initRoleAndUser() {
        if (!checkIfDataExists()) {
            // Create a Logo object for the admin user
            Logo adminLogo = new Logo("Admin Logo", "image/png", getAdminLogoBytes()); // Replace with actual image bytes
            CompanyName companyName = new CompanyName("株式会社ウィッツテクノロジー");
            logoRepository.save(adminLogo);
            companyRepository.save(companyName);
            // Save the logo to get an ID
//            logoRepository.save(adminLogo);

            UserInfo adminUser = new UserInfo();
            adminUser.setId("U0001");
            adminUser.setFirstName("Admin");
            adminUser.setFirstNamekana("Admin");
            adminUser.setLastName("John");
            adminUser.setLastNamekana("John");
            adminUser.setEmail("admin@gmail.com");
            adminUser.setPassword("1234567890");
            adminUser.setRoleType("admin");
            adminUser.setCompanyId(companyName);

            // Set the logo for the admin user
            adminUser.setLogo(adminLogo);

            // Save the admin user
            userInfoRepository.save(adminUser);
        }
    }

    // Replace this method with one that loads the logo image bytes
    private byte[] getAdminLogoBytes() {
        try {
            // Replace "path_to_your_image.png" with the actual path to your logo image file.
            Path imagePath = Paths.get("C:\\Users\\user\\Desktop\\LatestSourceCode_20231121\\RealestateBackend\\realestate(backend)\\img\\logo.png");

            // Read the image bytes from the file
            byte[] imageBytes = Files.readAllBytes(imagePath);

            return imageBytes;
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<UserInfo> getManager() {
        return userInfoRepository.findAllUsersByManager();    }

    @Override
    public UserInfo getUserById(String id) {
        return userInfoRepository.findById(id).get();
    }

    @Override
    public List<UserInfo> getUserInfo() {
        return userInfoRepository.findAll();
    }



    @Override
    public List<UserInfo> getOwners() {
        return userInfoRepository.findAllUsersByOwner();
    }

    @Override
    public List<UserInfo> getPICUsers() {
        return userInfoRepository.findAllUsersByPIC();
    }

    @Override
    public UserInfo authenticateUser(String email, String password) {
        UserInfo user = userInfoRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        // Return null if user not found or password does not match
        return null;



    }

    @Override
    public UserInfo updateUserInfo(String id, UserInfo userInfo) {
        UserInfo userInfo1= userInfoRepository.findById((id)).get();

        if (userInfo1 != null) {

            Logo logoImage = userInfo1.getLogo();
            if (logoImage == null) {
                logoImage = new Logo();
                userInfo1.setLogo(logoImage);
            }
            logoImage.setImage(userInfo.getLogo().getImage());
            logoImage.setName(userInfo.getLogo().getName());
            logoImage.setType(userInfo.getLogo().getType());

            CompanyName companyId = userInfo1.getCompanyId();
            if(companyId== null){
                companyId = new CompanyName();
                userInfo1.setCompanyId(companyId);
            }
            companyId.setCompanyName(userInfo.getCompanyId().getCompanyName());

//            userInfo1.setCompanyName(userInfo.getCompanyName());
            userInfo1.setFirstName(userInfo.getFirstName());
            userInfo1.setFirstNamekana(userInfo.getFirstNamekana());
            userInfo1.setLastName(userInfo.getLastName());
            userInfo1.setLastNamekana(userInfo.getLastNamekana());
            userInfo1.setGender(userInfo.getGender());
            userInfo1.setDepartment(userInfo.getDepartment());
            userInfo1.setAddress(userInfo.getAddress());
            userInfo1.setPhone1(userInfo.getPhone1());
            userInfo1.setPhone2(userInfo.getPhone2());
            userInfo1.setPhone3(userInfo.getPhone3());
            userInfo1.setEmail(userInfo.getEmail());
            userInfo1.setPassword(userInfo.getPassword());
            userInfo1.setPostalcode1(userInfo.getPostalcode1());
            userInfo1.setPostalcode2(userInfo.getPostalcode2());
            userInfo1.setStartDate(userInfo.getStartDate());
            userInfo1.setEndDate(userInfo.getEndDate());
            userInfo1.setBankName(userInfo.getBankName());
            userInfo1.setBranch(userInfo.getBranch());
            userInfo1.setAccountName(userInfo.getAccountName());
            userInfo1.setAccountNumber(userInfo.getAccountNumber());
            userInfo1.setAccountType(userInfo.getAccountType());
            userInfo1.setDateOfBirth(userInfo.getDateOfBirth());
            userInfo1.setApportionment(userInfo.getApportionment());//for 按分
        }
        return userInfoRepository.save(userInfo1);
    }

    @Override
    public void deleteUserInfo(String id) {

        userInfoRepository.deleteById(id);
    }

//    @Override
//    public List<UserInfo> getUsersByCompanyName(String companyName) {
//        return userInfoRepository.findAllUsersByCompanyNameAndRoleType(companyName);
//    }
    @Override
    public List<UserInfo> getUsersByCompanyId(Long companyId) {
        return userInfoRepository.findAllUsersByCompanyIdAndRoleType(companyId);
    }
    @Override
    public List<UserInfo> getOwnersByCompanyId(Long companyId) {
        return userInfoRepository.findAllOwnersByCompanyIdAndRoleType(companyId);
    }

    @Override
    public List<UserInfo> getUserAddressByCompanyId(Long id) {
        List<UserInfo> userAddresses = userInfoRepository.findUserAddressByCompanyId(id);
        System.out.println("This is userAddress service"+userInfoRepository.findUserAddressByCompanyId(id));
        return userAddresses;
    }
//    @Override
//    public List<UserInfo> getManagersByCompanyName(String companyName) {
//        return userInfoRepository.findAllManagersByCompanyNameAndRoleType(companyName);
//    }
//
//    @Override
//    public List<UserInfo> getOwnersByCompanyName(String companyName) {
//        return userInfoRepository.findAllOwnersByCompanyNameAndRoleType(companyName);
//    }

}

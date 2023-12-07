package com.realestate.realestate.Service.UserInfo;

import com.realestate.realestate.Model.CompanyName;
import com.realestate.realestate.Model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserInfoServiceInterface {

    public UserInfo addUserInfo(UserInfo userInfo);
    public UserInfo checkEmailAndPassword(String email, String password);
    public UserInfo addCreatedDateAndModifiedDate(UserInfo userInfo);
    public boolean checkIfDataExists();
    public UserInfo checkEmail(String email);

    public void initRoleAndUser();
    public List<UserInfo>getManager();

    public List<UserInfo>getOwners();
    public  List<UserInfo>getPICUsers();
    UserInfo getUserById(String id);
    public List<UserInfo> getUserInfo();

    UserInfo authenticateUser(String email, String password);
    public UserInfo updateUserInfo(String id , UserInfo userInfo);
    public void deleteUserInfo(String id);

//    public  List<UserInfo>getUsersByCompanyName(String companyName);
    public  List<UserInfo>getUsersByCompanyId(Long companyId);
    public  List<UserInfo>getOwnersByCompanyId(Long companyId);
    public  List<UserInfo> getUserAddressByCompanyId(Long id);

//    public  List<UserInfo>getManagersByCompanyName(String companyName);
//
//    public  List<UserInfo>getOwnersByCompanyName(String companyName);



}

package com.realestate.realestate.Repository;

import com.realestate.realestate.Model.CompanyName;
import com.realestate.realestate.Model.Contract;
import com.realestate.realestate.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'owner'")
    List<UserInfo> findAllUsersByOwner();
    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'user'")
    List<UserInfo> findAllUsersByPIC();
    UserInfo findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'manager'")
    List<UserInfo> findAllUsersByManager();
//    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'user' AND u.companyName = :companyName")
//    List<UserInfo> findAllUsersByCompanyNameAndRoleType(String companyName);
//    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'manager' AND u.companyName = :companyName")
//    List<UserInfo> findAllManagersByCompanyNameAndRoleType(String companyName);
//    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'owner' AND u.companyName = :companyName")
//    List<UserInfo> findAllOwnersByCompanyNameAndRoleType(String companyName);
//    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'user' AND u.companyId = :companyId")
//    List<UserInfo> findAllUsersByCompanyIdAndRoleType(Long companyId);
@Query("SELECT u FROM UserInfo u WHERE u.roleType = 'user' AND u.companyId.id = :companyId")
    List<UserInfo> findAllUsersByCompanyIdAndRoleType(@Param("companyId") Long companyId);
@Query("SELECT u FROM UserInfo u WHERE u.roleType = 'owner' AND u.companyId.id = :companyId")
    List<UserInfo> findAllOwnersByCompanyIdAndRoleType(@Param("companyId") Long companyId);

    //    請求書画面の所属会社の郵便番号と住所ための機能 line 39~40
    @Query("SELECT u FROM UserInfo u WHERE u.roleType = 'manager' AND u.companyId.id = :companyId")
    List<UserInfo> findUserAddressByCompanyId(@Param("companyId") Long companyId);

    UserInfo findTopByOrderByIdDesc();

}

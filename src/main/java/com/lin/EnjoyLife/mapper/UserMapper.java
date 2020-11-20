package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from user where registerTime=#{registerTime}")
    List<User> queryForUser(@Param("registerTime") String registerTime);

    @Select("select * from user where UState=2")
    List<User> accountCheck();

    @Select("select * from user where UserId = #{UserId}")
    User queryUserById(@Param("UserId") String UserId);

    @Insert("insert into user (UserId,Password,UserName,RegisterTime,RealName,Sex,Age,IdentityNumber,Tel,Email,Address,Education,Profession,Question,Answer,UState,ULevel,Balance) values (#{UserId},#{Password},#{UserName},#{RegisterTime},#{RealName},#{Sex},#{Age},#{IdentityNumber},#{Tel},#{Email},#{Address},#{Education},#{Profession},#{Question},#{Answer},#{UState},#{ULevel},#{Balance})")
    Integer addUser(User user);

    @Update("update user set Password=#{Password} where UserId=#{UserId}")
    Integer updateUserPassword(@Param("UserId") String UserId, @Param("Password") String Password);

    @Update("update user set Balance=#{Balance} where UserId=#{UserId}")
    Integer updateUserBalance(@Param("UserId") String UserId, @Param("Balance") Integer Balance);

    @Update("update user set Sex=#{Sex},Tel=#{Tel},Email=#{Email},Address=#{Address},Education=#{Education},Profession=#{Profession} where UserId=#{UserId}")
    Integer updatePersonalInfo(@Param("UserId") String UserId, @Param("Sex") String Sex, @Param("Tel") String Tel, @Param("Email") String Email, @Param("Address") String Address, @Param("Education") String Education, @Param("Profession") String Profession);

    @Update("update user set UserName=#{UserName} where UserId=#{UserId}")
    Integer updateUserName(@Param("UserId") String UserId, @Param("UserName") String UserName);

    @Update("update user set Password=#{Password} where UserId=#{UserId}")
    Integer updatePassword(@Param("UserId") String UserId, @Param("Password") String Password);

    @Update("update user set UserName=#{UserName},Password=#{Password} where UserId=#{UserId}")
    Integer updateUserNameAndPassword(@Param("UserId") String UserId, @Param("UserName") String UserName, @Param("Password") String Password);
}

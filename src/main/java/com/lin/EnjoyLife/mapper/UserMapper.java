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

    @Insert("insert into user (UserId,Password,UserName,RegisterTime,RealName,Sex,Age,IdentityNumber,Tel,Email,Address,Education,Profession,Question,Answer,UState,ULevel) values (#{UserId},#{Password},#{UserName},#{RegisterTime},#{RealName},#{Sex},#{Age},#{IdentityNumber},#{Tel},#{Email},#{Address},#{Education},#{Profession},#{Question},#{Answer},#{UState},#{ULevel})")
    Integer addUser(User user);

    @Update("update user set Password=#{Password} where UserId=#{UserId}")
    Integer updateUserPassword(@Param("UserId") String UserId,@Param("Password") String Password);
}

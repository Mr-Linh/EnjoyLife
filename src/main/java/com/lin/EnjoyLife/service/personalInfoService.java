package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class personalInfoService {
    @Autowired
    UserMapper userMapper;

    public User PersonalInfoInit(String userId){
        User user = null;
        try {
            user=userMapper.queryUserById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public Boolean PersonalInfoChange(String UserId,String Sex,String Tel,String Email,String Address,String Education,String Profession){
        try {
            Integer integer = userMapper.updatePersonalInfo(UserId, Sex, Tel, Email, Address, Education, Profession);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

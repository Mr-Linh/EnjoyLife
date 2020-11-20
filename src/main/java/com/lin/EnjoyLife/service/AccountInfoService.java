package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService {
    @Autowired
    UserMapper userMapper;

    public User initAccountInfo(String userId){
        User user = null;
        try {
            user= userMapper.queryUserById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public Boolean updateUserName(String userId,String userName){

        try {
            Integer integer = userMapper.updateUserName(userId, userName);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateUserPassword(String userId,String password){

        try {
            Integer integer = userMapper.updateUserName(userId, password);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateUserNameAndPassword(String userId,String userName,String password){

        try {
            Integer integer = userMapper.updateUserNameAndPassword(userId, userName,password);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

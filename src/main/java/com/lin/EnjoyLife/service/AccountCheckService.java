package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class AccountCheckService {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/accountCheck")
    public List<User> queryforCheck() {
        List<User> users = null;
        try {
            users = userMapper.accountCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    public List<User> accountCheckSearchById(String userId) {
        List<User> users = null;
        try {
            users = userMapper.accountCheckSearchById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public Boolean accountCheckOption(String UserId){
        try {
            Integer integer = userMapper.accountCheckOption(UserId,0);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean accountCheckWrongOption(String UserId){
        try {
            Integer integer = userMapper.accountCheckOption(UserId,3);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

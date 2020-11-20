package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AccountBalanceService {
    @Autowired
    UserMapper userMapper;

    public User initAccountBalance(String userId){
        User user=null;
        try {
            user = userMapper.queryUserById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public Boolean RechargeBalance(String userId,Integer Balance){
        Integer integer = userMapper.updateUserBalance(userId, Balance);
        return integer==1;
    }
}

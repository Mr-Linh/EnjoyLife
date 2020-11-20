package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
    @Autowired
    UserMapper userMapper;

    public User InitWithdraw(String userId) {
        User user = null;
        try {
            user = userMapper.queryUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public Boolean Withdraw(String userId,Integer balance){
        try {
            Integer integer = userMapper.updateUserBalance(userId, balance);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

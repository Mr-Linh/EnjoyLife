package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    UserMapper userMapper;

    public String UserLogin(String UserId, String Password){
        User user =null;
        try {
            user = userMapper.queryUserById(UserId);
            if (user.getUState()==2)
                return "账号审核中..";
            if (user.getUState()==1){
                return "账号状态异常..";
            }
            if(user.getPassword().equals(Password)){
                if(user.getUState()==3){
                    return "审核不通过";
                }else {
                    return "登录成功";
                }
            }else{
                return "用户id或密码错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "用户不存在！";
    }
}

package com.lin.EnjoyLife.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class UserRegisterService {
    @Autowired
    UserMapper userMapper;

    public Boolean addUser(User user){
        try {
            Integer integer = userMapper.addUser(user);
            return integer == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Integer queryUser(String date){
        int size=0;
        try {
            List<User> users = userMapper.queryForUser(date);
            size = users.size()+1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return size;
    }
}

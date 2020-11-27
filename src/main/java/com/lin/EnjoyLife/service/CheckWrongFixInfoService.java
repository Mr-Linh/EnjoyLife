package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckWrongFixInfoService {

    @Autowired
    UserMapper userMapper;

    public Boolean CheckWrongFixInfo(String userId, String realName, String sex, Integer age,
                                     String identityNumber, String tel, String email, String address,
                                     String education, String profession){
        try {
            Integer integer = userMapper.checkWrongFixInfo(userId, realName, sex, age, identityNumber, tel, email, address, education, profession);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

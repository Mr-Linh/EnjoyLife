package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResetPasswordService {
    @Autowired
    UserMapper userMapper;
     public Boolean FindPassword(String UserId,String Question,String Answer){
         try{
             User user = userMapper.queryUserById(UserId);
             if(user.getQuestion().equals(Question) && user.getAnswer().equals(Answer)){
                 return true;
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return false;
     }
     public Boolean ResetPassword(String UserId,String Password){
         try {
             Integer integer = userMapper.updateUserPassword(UserId, Password);
             return integer==1;
         }catch (Exception e){
             e.printStackTrace();
         }
         return false;
     }
}

package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class RegisterController {
    @Autowired
    UserRegisterService userRegisterService;


    @PostMapping("/registerFinish")
    public String UserRegister(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("realname") String realname,
                               @RequestParam("sex") String sex,
                               @RequestParam("phone") String phone,
                               @RequestParam("email") String email,
                               @RequestParam("identity") String identitynumber,
                               @RequestParam("address") String address,
                               @RequestParam("education") String education,
                               @RequestParam("profession") String profession,
                               @RequestParam("quiz") String quiz,
                               @RequestParam("answer") String answer,
                               Model model) {
        User user = new User();

        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Date date1= Date.valueOf(date);
        Integer integer = userRegisterService.queryUser(date);
        String date2 = date.substring(0, 4);
        int year = 0;
        year += date2.charAt(0);
        for (int i = 1; i < 4; i++) {
            year *= 10;
            year += date2.charAt(i);
        }

        int age = 0;
        String substring = identitynumber.substring(6, 10);
        age += substring.charAt(0);
        for (int i = 1; i <= 3; i++) {
            age *= 10;
            age += substring.charAt(i);
        }
        age = year - age;

        String UserId = "U";
        UserId += date.substring(0, 4) + date.substring(5, 7) + date.substring(8) + integer.toString();

        try {
            user.setUserId(UserId);
            user.setPassword(password);
            user.setUserName(username);
            user.setRegisterTime(date1);
            user.setRealName(realname);
            user.setSex(sex);
            user.setAge(age);
            user.setIdentityNumber(identitynumber);
            user.setTel(phone);
            user.setEmail(email);
            user.setAddress(address);
            user.setEducation(education);
            user.setProfession(profession);
            user.setQuestion(quiz);
            user.setAnswer(answer);
            user.setUState(2);
            user.setULevel(0);
            user.setBalance(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("user", user);
        Boolean aBoolean = userRegisterService.addUser(user);
        if(aBoolean){
            model.addAttribute("msg","注册成功!用户id："+user.getUserId());
        }else {
            model.addAttribute("msg","注册失败");
        }
        return "register";
    }
}

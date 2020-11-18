package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.UserLoginService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Password;

import javax.jws.soap.SOAPBinding;

@Controller
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/uCheck")
    public String UserLogin(@RequestParam("UserId") String UserId, @RequestParam("Password") String Password, @RequestParam("card") String Card, @RequestParam("loginCodeHidden") String Code, Model model) {
        if (!Code.equals(Card.toUpperCase())) {
            model.addAttribute("UserLoginCodeError", "验证码错误");
            return "login";
        }else{
            Boolean aBoolean = userLoginService.UserLogin(UserId, Password);
            if (aBoolean) {
                model.addAttribute("UserId", UserId);
                return "index";
            } else {
                model.addAttribute("UserLoginError", "用户id或密码错误");
                return "login";
            }
        }


    }
}

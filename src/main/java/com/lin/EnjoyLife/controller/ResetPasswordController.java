package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.service.UserResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResetPasswordController {
    @Autowired
    UserResetPasswordService userResetPasswordService;

    @PostMapping("/FindPassword")
    public String findPassword(@RequestParam("userId") String userId, @RequestParam("quiz") String Question, @RequestParam("answer") String Answer, Model model){
        Boolean aBoolean = userResetPasswordService.FindPassword(userId, Question, Answer);
        if(aBoolean){
            model.addAttribute("userIdReset",userId);
            return "resetPassword";
        }else {
            model.addAttribute("msg","密保问题回答错误！");
            return "findPassword";
        }
    }
    @PostMapping("/ResetPassword")
    public String ResetPassword(@RequestParam("userIdReset") String userId, @RequestParam("password") String Password, Model model){
        Boolean aBoolean = userResetPasswordService.ResetPassword(userId, Password);
        if(aBoolean){
            model.addAttribute("msg","密码修改成功！");
            return "login";
        }else {
            model.addAttribute("msg","密码修改失败,请重试");
            return "findPassword";
        }
    }
}

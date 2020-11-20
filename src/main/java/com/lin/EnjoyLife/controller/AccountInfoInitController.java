package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountInfoInitController {

    @Autowired
    AccountInfoService accountInfoService;

    @GetMapping("/accountInfo")
    public String initAccountInfo(HttpSession httpSession,
                                  Model model){
        Object userId = httpSession.getAttribute("userId");
        User user = accountInfoService.initAccountInfo(userId.toString());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("registerTime",user.getRegisterTime().toString());
        model.addAttribute("uLevel",user.getULevel());
        return "accountInfo";
    }
}

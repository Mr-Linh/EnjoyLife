package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountBalanceController {
    @Autowired
    AccountBalanceService accountBalanceService;

    @GetMapping("/accountBalance")
    public String initAccountBalance(HttpSession httpSession, Model model){
        Object userId = httpSession.getAttribute("userId");
        User user = accountBalanceService.initAccountBalance(userId.toString());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("balance",user.getBalance());

        return "accountBalance";
    }

}

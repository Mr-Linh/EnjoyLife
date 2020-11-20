package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class WithdrawInitController {

    @Autowired
    WithdrawService withdrawService;

    @GetMapping("/withdraw")
    public String initAccountBalance(HttpSession httpSession, Model model){
        Object userId = httpSession.getAttribute("userId");
        User user = withdrawService.InitWithdraw(userId.toString());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("balance",user.getBalance());

        return "withdraw";
    }
}

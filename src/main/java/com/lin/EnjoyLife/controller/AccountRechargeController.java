package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AccountRechargeController {
    @Autowired
    AccountBalanceService accountBalanceService;

    @PostMapping("/recharge")
    public String ReCharge(@RequestParam("money")Integer balance,
                           @RequestParam("radio1") String payMethod,
                           HttpSession httpSession,
                           RedirectAttributes redirectAttributes){
        Object userId = httpSession.getAttribute("userId");
        User user = accountBalanceService.initAccountBalance(userId.toString());
        Integer balance1 = user.getBalance();
        Boolean aBoolean = accountBalanceService.RechargeBalance(userId.toString(), balance+balance1);
        User user1 = accountBalanceService.initAccountBalance(userId.toString());
        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","充值成功！"+payMethod+balance.toString()+"元");
        }else {
            redirectAttributes.addFlashAttribute("msg","充值失败请重试！");
        }
        redirectAttributes.addFlashAttribute("userId",user1.getUserId());
        redirectAttributes.addFlashAttribute("userName",user1.getUserName());
        redirectAttributes.addFlashAttribute("balance",user1.getBalance());
        return "redirect:/accountBalance";
    }

}

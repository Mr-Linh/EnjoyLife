package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class WithdrawController {
    @Autowired
    WithdrawService withdrawService;

    @PostMapping("/withdrawBalance")
    public String Withdraw(@RequestParam("money")Integer balance,
                           @RequestParam("radio1") String payMethod,
                           HttpSession httpSession, Model model,
                           RedirectAttributes redirectAttributes){
        Object userId = httpSession.getAttribute("userId");
        User user = withdrawService.InitWithdraw(userId.toString());
        Integer balance1 = user.getBalance();
        if(balance1<balance){
            redirectAttributes.addFlashAttribute("msg","提现失败,余额不足！");
        }else {
            Boolean aBoolean = withdrawService.Withdraw(userId.toString(), balance1-balance);

            if(aBoolean){
                redirectAttributes.addFlashAttribute("msg","提现成功！"+payMethod+balance.toString()+"元");
            }else {
                redirectAttributes.addFlashAttribute("msg","提现失败请重试！");
            }

        }
        User user1 = withdrawService.InitWithdraw(userId.toString());
        redirectAttributes.addFlashAttribute("userId",user1.getUserId());
        redirectAttributes.addFlashAttribute("userName",user1.getUserName());
        redirectAttributes.addFlashAttribute("balance",user1.getBalance());
        return "redirect:/withdraw";

    }
}

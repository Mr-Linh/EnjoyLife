package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AccountInfoChangeController {

    @Autowired
    AccountInfoService accountInfoService;

    @PostMapping("/accountInfoChange")
    public String AccountInfoChange(@RequestParam("username") String userName,
                                    @RequestParam("oldPassword") String oldPassword,
                                    @RequestParam("password") String password,
                                    HttpSession httpSession,
                                    RedirectAttributes redirectAttributes){
        Object userId = httpSession.getAttribute("userId");
        User user = accountInfoService.initAccountInfo(userId.toString());
        if(user.getPassword().equals(oldPassword)){
            if (!userName.isEmpty() && password.isEmpty()){
                Boolean aBoolean = accountInfoService.updateUserName(user.getUserId(), userName);
                if(aBoolean){
                    redirectAttributes.addFlashAttribute("msg","修改用户名成功！");
                }else {
                    redirectAttributes.addFlashAttribute("msg","修改用户名失败，请重试");
                }
            }else if(userName.isEmpty() && !password.isEmpty()){
                Boolean aBoolean = accountInfoService.updateUserPassword(user.getUserId(), password);
                if(aBoolean){
                    redirectAttributes.addFlashAttribute("msg","修改密码成功！");
                }else {
                    redirectAttributes.addFlashAttribute("msg","修改密码失败，请重试");
                }
            }else if(!userName.isEmpty() && !password.isEmpty()){
                Boolean aBoolean = accountInfoService.updateUserNameAndPassword(user.getUserId(), userName, password);
                if(aBoolean){
                    redirectAttributes.addFlashAttribute("msg","修改用户名和密码成功！");
                }else {
                    redirectAttributes.addFlashAttribute("msg","修改用户名和密码失败，请重试");
                }
            }else {
                redirectAttributes.addFlashAttribute("msg","未做任何改动");
            }
        }else {
            redirectAttributes.addFlashAttribute("msg","密码不正确，修改信息失败！");
        }
        user = accountInfoService.initAccountInfo(userId.toString());
        redirectAttributes.addFlashAttribute("userId", user.getUserId());
        redirectAttributes.addFlashAttribute("userName",user.getUserName());
        redirectAttributes.addFlashAttribute("registerTime",user.getRegisterTime());
        redirectAttributes.addFlashAttribute("uLevel",user.getULevel());
        return "redirect:/accountInfo";
    }
}

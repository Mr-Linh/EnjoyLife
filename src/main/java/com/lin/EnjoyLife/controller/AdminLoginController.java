package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {

    @Autowired
    ManagerLoginService managerLoginService;

    @PostMapping("/admin")
    public String adminLoginCheck(@RequestParam("managerId") String managerId, @RequestParam("mPassword") String mPassword, Model model){
        Boolean aBoolean = managerLoginService.ManagerLogin(managerId, mPassword);
        if (aBoolean){
            model.addAttribute("managerId",managerId);
            return "admin";
        }else {
            model.addAttribute("adminloginError","用户名或密码错误！登录失败");
            return "adminLogin";
        }

    }
}

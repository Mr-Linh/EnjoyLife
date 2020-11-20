package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.service.ManagerLoginService;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    @Autowired
    ManagerLoginService managerLoginService;

    @PostMapping("/mCheck")
    public String adminLoginCheck(@RequestParam("managerId") String managerId,
                                  @RequestParam("mPassword") String mPassword,
                                  RedirectAttributes redirectAttributes, HttpSession httpSession){
        Boolean aBoolean = managerLoginService.ManagerLogin(managerId, mPassword);
        if (aBoolean){
            redirectAttributes.addFlashAttribute("managerId",managerId);
            httpSession.setAttribute("managerId",managerId);
            return "redirect:/admin";
        }else {
            redirectAttributes.addFlashAttribute("adminloginError","用户名或密码错误！登录失败");
            return "redirect:/adminLogin";
        }

    }
}

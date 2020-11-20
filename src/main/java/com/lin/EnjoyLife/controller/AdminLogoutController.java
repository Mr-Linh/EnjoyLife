package com.lin.EnjoyLife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLogoutController {

    @GetMapping("/managerLogout")
    public String managerLogout(HttpSession httpSession){

        httpSession.removeAttribute("managerId");
        httpSession.invalidate();
        return "redirect:/adminLogin";
    }
}

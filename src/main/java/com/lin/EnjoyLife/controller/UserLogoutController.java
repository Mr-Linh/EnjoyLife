package com.lin.EnjoyLife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserLogoutController {
    @GetMapping("/logout")
    public String managerLogout(HttpSession httpSession){

        httpSession.removeAttribute("userId");
        return "redirect:/login";
    }
}

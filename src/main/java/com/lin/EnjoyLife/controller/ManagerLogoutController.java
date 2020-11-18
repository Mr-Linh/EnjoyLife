package com.lin.EnjoyLife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerLogoutController {

    @GetMapping("/managerLogout")
    public String managerLogout(){

        return "redirect:/adminLogin";
    }
}

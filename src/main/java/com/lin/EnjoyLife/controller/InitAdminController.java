package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.PageView;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.InitAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InitAdminController {

    @Autowired
    InitAdminService InitAdminService;

    @GetMapping("/initAdmin")
    public String searchCount(Model model){
        PageView pageview= InitAdminService.searchByPid(1);
        List<User> users = InitAdminService.queryForAllUsers();
        model.addAttribute("userNum",users.size());
        model.addAttribute("pageview",pageview);
        return "initAdmin";
    }
}

package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.PageView;
import com.lin.EnjoyLife.service.PageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InitAdminController {

    @Autowired
    PageViewService PageViewService;


    @GetMapping("/initAdmin")
    public String searchCount(Model model){
        PageView pageview=PageViewService.searchByPid(1);
        model.addAttribute("pageview",pageview);
        return "initAdmin";
    }
}

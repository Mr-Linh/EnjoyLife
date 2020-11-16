package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.PageView;
import com.lin.EnjoyLife.service.IPageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class InitAdminController {

    @Autowired
    IPageViewService iPageViewService;


    @GetMapping("/initAdmin")
    public String searchCount(
                           Model model){
        PageView pageview=iPageViewService.searchByPid(1);
        model.addAttribute("pageview",pageview);
        return "initAdmin";
    }
}

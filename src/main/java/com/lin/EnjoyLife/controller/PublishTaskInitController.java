package com.lin.EnjoyLife.controller;


import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.PublishTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PublishTaskInitController {
    @Autowired
    PublishTaskService publishTaskService;

    @GetMapping("/publishTask")
    public String publishTask(HttpSession httpSession, Model model){
        Object userId = httpSession.getAttribute("userId");
        User user = publishTaskService.PublishTaskInit(userId.toString());
        model.addAttribute("userName",user.getUserName());
        return "publishTask";
    }
}

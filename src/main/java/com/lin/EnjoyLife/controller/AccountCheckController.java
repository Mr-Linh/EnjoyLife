package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.accountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountCheckController {

    @Autowired
    accountCheckService accountcheckService;

    @GetMapping("/accountCheck")
    public String accountCheckShow(Model model){
        List<User> users = accountcheckService.queryforCheck();
        model.addAttribute("acccount",users);
        return "accountCheck";
    }
}

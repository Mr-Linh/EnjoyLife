package com.lin.EnjoyLife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {
    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/index")
    public String Index(){
        return "index";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }


    @GetMapping("/userActivity")
    public String userActivity(){
        return "userActivity";
    }

    @GetMapping("/aboutTask")
    public String aboutTask(){
        return "aboutTask";
    }

    @GetMapping("/lifeTask")
    public String lifeTask(){
        return "lifeTask";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/publishTask")
    public String publishTask(){
        return "publishTask";
    }
}

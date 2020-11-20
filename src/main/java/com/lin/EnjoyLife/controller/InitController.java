package com.lin.EnjoyLife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {
    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/index")
    public String Index(){
        return "index";
    }
    @GetMapping("/findPassword")
    public String findPassword(){
        return "findPassword";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/adminLogin")
    public String adminLogin(){
        return "adminLogin";
    }

    @GetMapping("/accountCheck")
    public String accountCheck(){
        return "accountCheck";
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

    @GetMapping("/publishTask")
    public String publishTask(){
        return "publishTask";
    }

    @GetMapping("/taskCenter")
    public String taskCenter(){
        return "taskCenter";
    }



}

package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class InitController {

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/index")
    public String Index(HttpSession httpSession, Model model) {
        Object userId = httpSession.getAttribute("userId");
        model.addAttribute("UserId", userId.toString());
        return "index";
    }

    @GetMapping("/findPassword")
    public String findPassword() {
        return "findPassword";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "adminLogin";
    }

    @GetMapping("/accountCheck")
    public String accountCheck() {
        return "accountCheck";
    }

    @GetMapping("/userActivity")
    public String userActivity() {
        return "userActivity";
    }

    @GetMapping("/aboutTask")
    public String aboutTask() {
        return "aboutTask";
    }

    @GetMapping("/receiptTaskDetail")
    public String receiptTaskDetail() {
        return "receiptTaskDetail";
    }

    @GetMapping("/lifeTask")
    public String lifeTask() {
        return "lifeTask";
    }

//    @GetMapping("/taskCenter")
//    public String taskCenter() {
//        return "taskCenter";
//    }


}

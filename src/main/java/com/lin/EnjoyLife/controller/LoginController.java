package com.lin.EnjoyLife.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/Login")
    @ResponseBody
    public String Login(){
        return "login";
    }
}

package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountCheckController {

    @Autowired
    AccountCheckService accountcheckService;

    @GetMapping("/accountCheckFun")
    @ResponseBody
    public Map<String, Object> accountCheckShow(){
        List<User> users = accountcheckService.queryforCheck();
        HashMap<String,Object> map = new HashMap<>();
        //前台通过key值获得对应的value值
        map.put("code", 0);
        map.put("data", users);
        return map;
    }
}

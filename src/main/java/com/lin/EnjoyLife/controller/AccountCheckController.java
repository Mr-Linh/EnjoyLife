package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Map<String, Object> accountCheckShow(@RequestParam("page") Integer page,@RequestParam Integer limit){
        List<User> users = accountcheckService.queryforCheck();
        List<User> users2 = accountcheckService.queryforCheckPage(page,limit);
        HashMap<String,Object> map = new HashMap<>();
        //前台通过key值获得对应的value值
        map.put("code", 0);
        map.put("count",users.size());
        map.put("data", users2);
        return map;
    }

    @PostMapping("/accountCheckOption")
    @ResponseBody
    public String accountCheckOption(User data){
        Boolean aBoolean;
        try {
             aBoolean = accountcheckService.accountCheckOption(data.getUserId());
            if (aBoolean){
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "failed";
    }

    @PostMapping("/accountCheckWrongOption")
    @ResponseBody
    public String accountCheckWrongOption(User data){
        Boolean aBoolean;
        try {
            aBoolean = accountcheckService.accountCheckWrongOption(data.getUserId());
            if (aBoolean){
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "failed";
    }
}

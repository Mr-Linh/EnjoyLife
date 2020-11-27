package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountCheckSearchByIdController {
    @Autowired
    AccountCheckService accountcheckService;

    @PostMapping("/accountCheckSearchById")
    @ResponseBody
    public Map<String, Object> accountCheckShow(@RequestParam("demoReload") String demoReload){
        List<User> users = accountcheckService.accountCheckSearchById(demoReload);
        HashMap<String,Object> map = new HashMap<>();
        //前台通过key值获得对应的value值
        map.put("code", 0);
        map.put("data", users);
        return map;
    }
}

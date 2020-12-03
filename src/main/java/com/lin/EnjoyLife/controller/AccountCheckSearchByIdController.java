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
public class AccountCheckSearchByIdController {
    @Autowired
    AccountCheckService accountcheckService;

    @PostMapping("/accountCheckSearchById")
    @ResponseBody
    public Map<String, Object> accountCheckShow(@RequestParam("id") String id,
                                                @RequestParam("page") Integer page,
                                                @RequestParam("limit") Integer limit){
        List<User> users = accountcheckService.accountCheckSearchById(id);
        List<User> users1 = accountcheckService.accountCheckSearchByIdPage(id, page, limit);
        HashMap<String,Object> map = new HashMap<>();
        //前台通过key值获得对应的value值
        map.put("code", 0);
        map.put("msg","");
        map.put("count",users.size());
        map.put("data", users1);
        return map;
    }
}

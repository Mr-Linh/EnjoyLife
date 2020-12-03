package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AccountCheckService;
import com.lin.EnjoyLife.service.TaskCheckService;
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
public class TaskCheckController {

    @Autowired
    TaskCheckService taskCheckService;

    @GetMapping("/taskCheckFun")
    @ResponseBody
    public Map<String, Object> taskCheckShow(@RequestParam("page") Integer page,@RequestParam Integer limit){
        List<Task> tasks = taskCheckService.queryforTaskCheck();
        List<Task> tasks2 = taskCheckService.queryforCheckPage(page,limit);
        HashMap<String,Object> map = new HashMap<>();
        //前台通过key值获得对应的value值
        map.put("code", 0);
        map.put("count",tasks.size());
        map.put("data", tasks2);
        return map;
    }

    @PostMapping("/taskCheckOption")
    @ResponseBody
    public String taskCheckOption(Task data){
        Boolean aBoolean;
        try {
             aBoolean = taskCheckService.taskCheckOption(data.getTaskId());
            if (aBoolean){
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "failed";
    }

    @PostMapping("/taskCheckWrongOption")
    @ResponseBody
    public String taskCheckWrongOption(Task data){
        Boolean aBoolean;
        try {
            aBoolean = taskCheckService.taskCheckWrongOption(data.getTaskId());
            if (aBoolean){
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "failed";
    }
}

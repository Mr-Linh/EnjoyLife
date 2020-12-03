package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.ComplainTaskService;
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
public class TaskComplainDealController {

    @Autowired
    ComplainTaskService complainTaskService;

    @GetMapping("/taskComplainDealFun")
    @ResponseBody
    public Map<String, Object> taskComplainShow(@RequestParam("page") Integer page, @RequestParam Integer limit){
        List<Task> tasks = complainTaskService.queryForTaskComplain();
        List<Task> tasks2 = complainTaskService.queryForTaskComplainPage(page, limit);
        HashMap<String,Object> map = new HashMap<>();
        //前台通过key值获得对应的value值
        map.put("code", 0);
        map.put("count",tasks.size());
        map.put("data", tasks2);
        return map;
    }

    @PostMapping("/complainPassOption")
    @ResponseBody
    public String accountCheckOption(Task data){

        try {
            Integer integer = complainTaskService.complainTaskPass(data.getTaskId());
            if(integer==1){
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "failed";
    }

    @PostMapping("/complainWrongOption")
    @ResponseBody
    public String accountCheckWrongOption(Task data){

        try {
            Integer integer = complainTaskService.complainTaskWrong(data.getTaskId());
            if(integer==1){
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "failed";
    }
}

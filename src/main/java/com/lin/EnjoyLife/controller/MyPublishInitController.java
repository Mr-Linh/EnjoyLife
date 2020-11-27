package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MyPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyPublishInitController {

    @Autowired
    MyPublishService myPublishService;

    @GetMapping("/myPublish")
    public String initMyPublish(HttpSession httpSession, Model model){
        Object userId = httpSession.getAttribute("userId");
        User user = myPublishService.initMyPublish(userId.toString());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());

        return "myPublish";
    }

    @GetMapping("myPublishListNew")
    @ResponseBody
    public Map<Object, Object> initMyPublishList1(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");

        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=myPublishService.initMyPublishList1(userId.toString());
        map.put("data",tasks);

        return map;
    }

    @GetMapping("/myPublishListGoing")
    @ResponseBody
    public Map<Object, Object> initMyPublishList2(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");

        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=myPublishService.initMyPublishList2(userId.toString());
        map.put("data",tasks);

        return map;
    }

    @GetMapping("/myPublishListFinish")
    @ResponseBody
    public Map<Object, Object> initMyPublishList3(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");

        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=myPublishService.initMyPublishList3(userId.toString());
        map.put("data",tasks);

        return map;
    }

    @GetMapping("/myPublishListAll")
    @ResponseBody
    public Map<Object, Object> initMyPublishList4(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");

        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=myPublishService.initMyPublishList4(userId.toString());
        map.put("data",tasks);

        return map;
    }
}

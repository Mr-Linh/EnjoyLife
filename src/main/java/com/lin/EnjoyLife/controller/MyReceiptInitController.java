package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MyReceiptService;
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
public class MyReceiptInitController {
    @Autowired
    MyReceiptService myReceiptService;

    @GetMapping("/myReceipt")
    public String initMyReceipt(HttpSession httpSession, Model model){
        String userId = httpSession.getAttribute("userId").toString();
        User user = myReceiptService.initMyReceipt(userId);
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());

        return "myReceipt";
    }

    @GetMapping("/myReceiptListGoing")
    @ResponseBody
    public Map<Object, Object> initMyReceiptList2(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");

        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=myReceiptService.initMyReceiptList2(userId.toString());
        map.put("data",tasks);

        return map;
    }

    @GetMapping("/myReceiptListFinish")
    @ResponseBody
    public Map<Object, Object> initMyReceiptList3(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");

        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=myReceiptService.initMyReceiptList3(userId.toString());
        map.put("data",tasks);

        return map;
    }

    @GetMapping("/myReceiptListAll")
    @ResponseBody
    public Map<Object, Object> initMyReceiptList4(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");

        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=myReceiptService.initMyReceiptList4(userId.toString());
        map.put("data",tasks);

        return map;
    }

}

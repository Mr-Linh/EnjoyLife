package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Message;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class InitAdminController {

    @Autowired
    InitAdminService InitAdminService;
    @Autowired
    AboutTaskService aboutTaskService;
    @Autowired
    TaskCheckService taskCheckService;
    @Autowired
    AccountCheckService accountCheckService;
    @Autowired
    MessageService messageService;

    @GetMapping("/initAdmin")
    public String searchCount(Model model) {
//        PageView pageview = InitAdminService.searchByPid(1);

        Integer taskTotal = InitAdminService.taskTotal();
        model.addAttribute("taskTotal", taskTotal);

        List<User> users = InitAdminService.queryForAllUsers();
        model.addAttribute("userNum", users.size());

        List<String> list1 = new ArrayList<>();
        SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        for (int i = 0; i < 7; i++) {
            calendar.add(Calendar.DATE, 1);
//            System.out.println(sj.format(calendar.getTime()));
            list1.add(sj.format(calendar.getTime()));
        }
        int taskNum = 0;
        List<Integer> list2 = aboutTaskService.taskPublishNum(list1);
        for (Integer list : list2) {
            taskNum += list;
        }
        model.addAttribute("taskNum", taskNum);

        List<Task> tasks = taskCheckService.queryforTaskCheck();
        model.addAttribute("taskToCheck", tasks.size());

        List<User> users1 = accountCheckService.queryforCheck();
        model.addAttribute("accountToCheck", users1.size());

        return "initAdmin";
    }

    @GetMapping("messageList")
    @ResponseBody
    public List<Message> messageList() {

        List<Message> messageList = null;
        try {
            messageList = messageService.messageShow();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return messageList;
    }
}

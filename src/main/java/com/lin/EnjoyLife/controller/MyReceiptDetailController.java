package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MyPublishService;
import com.lin.EnjoyLife.service.MyReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MyReceiptDetailController {

    @Autowired
    MyReceiptService myReceiptService;

    @GetMapping("/myReceiptDetail")
    public String queryForTask(@RequestParam("id") String taskId, Model model) {
        Task task = myReceiptService.queryForTaskByTaskId(taskId);
        User user = myReceiptService.initMyReceipt(task.getExecutor());
        model.addAttribute("userName", task.getPublisher());
        model.addAttribute("uLevel", user.getULevel());
        model.addAttribute("tel", task.getExecutorPhone());
        model.addAttribute("task", task);

        return "myReceiptDetail";
    }
}

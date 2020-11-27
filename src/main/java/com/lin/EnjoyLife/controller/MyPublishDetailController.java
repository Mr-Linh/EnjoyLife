package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MyPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class MyPublishDetailController {

    @Autowired
    MyPublishService myPublishService;

    @GetMapping("/myPublishDetail")
    public String queryForTask(@RequestParam("id") String taskId, HttpSession httpSession, Model model) {
        Task task = myPublishService.queryForTaskByTaskId(taskId);
        User user = myPublishService.initMyPublish(httpSession.getAttribute("userId").toString());
        model.addAttribute("userName", task.getPublisher());
        model.addAttribute("uLevel",user.getULevel());
        model.addAttribute("tel",task.getExecutorPhone());
        model.addAttribute("task", task);

        return "myPublishDetail";
    }
}

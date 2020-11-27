package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MyPublishService;
import com.lin.EnjoyLife.service.TaskCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class TaskCenterDetailController {

    @Autowired
    TaskCenterService taskCenterService;

    @GetMapping("/taskCenterDetail")
    public String queryForTask(@RequestParam("id") String taskId, HttpSession httpSession, Model model) {
        Task task = taskCenterService.queryForTaskByTaskId(taskId);
        User user = taskCenterService.initTaskCenter(httpSession.getAttribute("userId").toString());
        User user1 = taskCenterService.initTaskCenter(task.getPublisher());
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("uLevel",user1.getULevel());
        model.addAttribute("tel",user1.getTel());
        model.addAttribute("task", task);

        return "taskCenterDetail";
    }
}

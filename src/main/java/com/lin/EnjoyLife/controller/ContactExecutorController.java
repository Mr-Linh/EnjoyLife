package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.ContactExecutorService;
import com.lin.EnjoyLife.service.MyPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ContactExecutorController {
    @Autowired
    MyPublishService myPublishService;

    @GetMapping("/contactExecutor")
    public String contactExecutor(@RequestParam("id") String taskId,
                                  HttpSession httpSession,
                                  RedirectAttributes redirectAttributes){
        Task task = myPublishService.queryForTaskByTaskId(taskId);
        User user = myPublishService.initMyPublish(httpSession.getAttribute("userId").toString());
        redirectAttributes.addFlashAttribute("msg","联系电话："+task.getExecutorPhone());
        redirectAttributes.addFlashAttribute("userName",user.getUserName());
        redirectAttributes.addFlashAttribute("uLevel", user.getULevel());
        redirectAttributes.addFlashAttribute("tel",user.getTel());
        redirectAttributes.addFlashAttribute("task",task);

        return "redirect:/myPublishDetail?id="+taskId;
    }
}

package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MyPublishService;
import com.lin.EnjoyLife.service.UndoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UndoTaskController {
    @Autowired
    UndoTaskService undoTaskService;
    @Autowired
    MyPublishService myPublishService;

    @GetMapping("/undoTask")
    public String undoTask(@RequestParam("id") String taskId, HttpSession httpSession,
                           RedirectAttributes redirectAttributes){

        Boolean aBoolean = undoTaskService.undoTask(taskId);
        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","委托已撤销，在全部中可查看");
        }else {
            redirectAttributes.addFlashAttribute("msg","委托撤回时出错");

        }

        Object userId = httpSession.getAttribute("userId");
        User user = myPublishService.initMyPublish(userId.toString());
        redirectAttributes.addFlashAttribute("userId",user.getUserId());
        redirectAttributes.addFlashAttribute("userName",user.getUserName());
        return  "redirect:/myPublish";
    }
}

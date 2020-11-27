package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.ConfirmFinishService;
import com.lin.EnjoyLife.service.MyPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ConfirmFinishController {
    @Autowired
    ConfirmFinishService confirmFinishService;
    @Autowired
    MyPublishService myPublishService;

    @GetMapping("/confirmFinish")
    public String confirmFinish(@RequestParam("id") String taskId,
                                HttpSession httpSession,
                                RedirectAttributes redirectAttributes){
        Boolean aBoolean = confirmFinishService.ConfirmFinish(taskId);

        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","委托已确认");
        }else {
            redirectAttributes.addFlashAttribute("msg","委托状态异常");

        }
        Object userId = httpSession.getAttribute("userId");
        User user = myPublishService.initMyPublish(userId.toString());
        redirectAttributes.addFlashAttribute("userId",user.getUserId());
        redirectAttributes.addFlashAttribute("userName",user.getUserName());
        return "redirect:/myPublish";
    }
}

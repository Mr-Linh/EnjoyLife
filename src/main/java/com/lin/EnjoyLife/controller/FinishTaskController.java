package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.FinishTaskService;
import com.lin.EnjoyLife.service.MyReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class FinishTaskController {
    @Autowired
    FinishTaskService finishTaskService;
    @Autowired
    MyReceiptService myReceiptService;

    @GetMapping("/finishTask")
    public String finishTask(@RequestParam("id") String taskId,
                             HttpSession httpSession,
                             RedirectAttributes redirectAttributes){
        Boolean aBoolean = finishTaskService.FinishTask(taskId);
        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","状态已提交，等待审核");
        }else {
            redirectAttributes.addFlashAttribute("msg","委托状态异常");

        }
        Object userId = httpSession.getAttribute("userId");
        User user = myReceiptService.initMyReceipt(userId.toString());
        redirectAttributes.addFlashAttribute("userId",user.getUserId());
        redirectAttributes.addFlashAttribute("userName",user.getUserName());
        return  "redirect:/myReceipt";
    }

}

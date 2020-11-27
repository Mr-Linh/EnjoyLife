package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.ReceiptTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ReceiptTaskController {
    @Autowired
    ReceiptTaskService receiptTaskService;

    @GetMapping("/receiptTask")
    public String ReceiptTask(@RequestParam("id")String taskId, HttpSession httpSession,
                              RedirectAttributes redirectAttributes){
        String userId=httpSession.getAttribute("userId").toString();
        Task task = receiptTaskService.queryForTaskByTaskId(taskId);
        if(task.getPublisher().equals(userId)){
            redirectAttributes.addFlashAttribute("msg","不能接受本人发布的委托！");
            return "redirect:/taskCenter";
        }
        if(task.getCategory1().equals("紧急")){
            User user = receiptTaskService.queryByUserId(userId);
            if(user.getULevel()<3){
                redirectAttributes.addFlashAttribute("mag","账号等级3级以上才能接受紧急委托！");
                return "redirect:/taskCenter";
            }
        }
        boolean aBoolean = receiptTaskService.receiptTaskUpdate(taskId, userId);

        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","委托接受成功！");
            return "redirect:/taskCenter";
        }else {
            redirectAttributes.addFlashAttribute("msg","委托接受失败！");
            return "redirect:/taskCenterDetail?id="+taskId;
        }
    }

}

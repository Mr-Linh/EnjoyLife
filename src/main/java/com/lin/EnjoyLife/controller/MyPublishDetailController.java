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
import java.math.BigDecimal;

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
        model.addAttribute("tel",user.getTel());
        model.addAttribute("task", task);
        if (task.getTState()==6 || task.getTState()==8 || task.getTState()==9 || task.getTState()==10){
            double score=task.getScore().doubleValue();
            if(Math.round(score)==score){
                model.addAttribute("score",Math.round(score));
            }else {
                model.addAttribute("score",score);
            }
        }else {
            model.addAttribute("score",6);
        }

        String tState;
        switch (task.getTState()){
            case 0:
                tState="委托审核中";
                break;
            case 1:
                tState="委托已发布";
                break;
            case 2:
                tState="未通过审核";
                break;
            case 3:
                tState="您已撤销";
                break;
            case 4:
                tState="执行中";
                break;
            case 5:
                tState="执行完毕待确认";
                break;
            case 6:
                tState="委托完成";
                break;
            case 7:
                tState="申诉中";
                break;
            case 8:
                tState="申诉通过，钱款退回";
                break;
            case 9:
                tState="申诉不通过，委托完成";
                break;
            case 10:
                tState="申诉被撤销，委托完成";
                break;
            case 11:
                tState="委托已过期";
                break;
            default:
                tState="委托状态异常";
                break;
        }
        model.addAttribute("tState",tState);

        return "myPublishDetail";
    }
}

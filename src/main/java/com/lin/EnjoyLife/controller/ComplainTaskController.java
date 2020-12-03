package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.ComplainTaskService;
import com.lin.EnjoyLife.service.MyPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ComplainTaskController {

    @Autowired
    ComplainTaskService complainTaskService;
    @Autowired
    MyPublishService myPublishService;

    @GetMapping("/addAppealReason")
    public String addEvaluation(@RequestParam("id") String taskId,HttpSession httpSession,
                                Model model){
        String userId = httpSession.getAttribute("userId").toString();
        model.addAttribute("taskId",taskId);
        User user = myPublishService.initMyPublish(userId);
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());
        return "addAppealReason";
    }

    @PostMapping("/complainTask")
    public String ComlainTask(@RequestParam("taskId") String taskId,
                              @RequestParam("appealReason") String appealReason,
                              HttpSession httpSession, RedirectAttributes redirectAttributes){

        Boolean aBoolean = complainTaskService.ComplainTask(taskId,appealReason);
        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","委托申诉中，请耐心等待");
        }else {
            redirectAttributes.addFlashAttribute("msg","申诉失败，请检查网络");

        }
        Object userId = httpSession.getAttribute("userId");
        User user = myPublishService.initMyPublish(userId.toString());
        redirectAttributes.addFlashAttribute("userId",user.getUserId());
        redirectAttributes.addFlashAttribute("userName",user.getUserName());
        return "redirect:/myPublish";
    }

    @GetMapping("/undoComplain")
    public String undoComplainOption(@RequestParam("id")String taskId,
                                     HttpSession httpSession,
                                     RedirectAttributes redirectAttributes){
        Boolean aBoolean = complainTaskService.undoComplain(taskId);
        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","撤回成功，委托完成");
        }else {
            redirectAttributes.addFlashAttribute("msg","撤回失败，请检查网络");
        }

        Task task = myPublishService.queryForTaskByTaskId(taskId);
        User user = myPublishService.initMyPublish(httpSession.getAttribute("userId").toString());
        redirectAttributes.addFlashAttribute("userName", task.getPublisher());
        redirectAttributes.addFlashAttribute("uLevel",user.getULevel());
        redirectAttributes.addFlashAttribute("tel",user.getTel());
        redirectAttributes.addFlashAttribute("task", task);

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
            default:
                tState="委托状态异常";
        }
        redirectAttributes.addFlashAttribute("tState",tState);
        return "redirect:/myPublishDetail?id="+taskId;
    }
}

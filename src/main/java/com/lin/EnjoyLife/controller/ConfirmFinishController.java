package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.ConfirmFinishService;
import com.lin.EnjoyLife.service.GiveScoreService;
import com.lin.EnjoyLife.service.MyPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ConfirmFinishController {
    @Autowired
    ConfirmFinishService confirmFinishService;
    @Autowired
    MyPublishService myPublishService;
    @Autowired
    GiveScoreService giveScoreService;

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

    @GetMapping("/giveScore")
    public String giveScore(@RequestParam("id") String taskId, Model model){

        model.addAttribute("taskId",taskId);
        return "giveScore";
    }

    @PostMapping("/addScore")
    public String addScore(@RequestParam("taskId") String taskId,
                           @RequestParam("scoreSubmit") double score,
                           HttpSession httpSession,
                           RedirectAttributes redirectAttributes){
        Boolean aBoolean = giveScoreService.giveScore(taskId, score);
        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","评价成功");
        }else {
            redirectAttributes.addFlashAttribute("msg","评价失败，请检查网络");
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

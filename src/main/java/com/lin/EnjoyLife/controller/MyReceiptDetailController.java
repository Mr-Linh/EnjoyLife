package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MyPublishService;
import com.lin.EnjoyLife.service.MyReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MyReceiptDetailController {

    @Autowired
    MyReceiptService myReceiptService;

    @GetMapping("/myReceiptDetail")
    public String queryForTask(@RequestParam("id") String taskId, Model model) {
        Task task = myReceiptService.queryForTaskByTaskId(taskId);
        User user = myReceiptService.initMyReceipt(task.getPublisher());
        model.addAttribute("userName", task.getPublisher());
        model.addAttribute("uLevel", user.getULevel());
        model.addAttribute("tel", user.getTel());
        model.addAttribute("task", task);
        String tState;
        switch (task.getTState()){
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
                tState="该委托被申诉";
                break;
            case 8:
                tState="申诉通过，委托执行失败";
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

        return "myReceiptDetail";
    }
}

package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.PublishTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class PublishTaskFinishController {
    @Autowired
    PublishTaskService publishTaskService;

    @PostMapping("/publishTaskFinish")
    public String PublishTask(@RequestParam("category1") String category1,
                              @RequestParam("category2") String category2,
                              @RequestParam("deadline") Date deadline,
                              @RequestParam("title") String theme,
                              @RequestParam("content") String content,
                              @RequestParam("special") String special,
                              @RequestParam("tLevel") String tLevel,
                              @RequestParam("price") Integer price,
                              HttpSession httpSession,
                              RedirectAttributes redirectAttributes) {
        Object userId = httpSession.getAttribute("userId");
        User user = publishTaskService.PublishTaskInit(userId.toString());
        if (category1.equals("紧急")){
            Integer uLevel = user.getULevel();
            if(uLevel<3){
                redirectAttributes.addFlashAttribute("msg", "账号等级不足3级，无法发布紧急委托！");
                return "redirect:/publishTask";
            }
        }

        Integer balance;
        if(user.getBalance()<price){
            redirectAttributes.addFlashAttribute("msg","账户余额不足,请充值！");
            return "redirect:/publishTask";
        }else {
            balance = user.getBalance() - price;
        }

        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Integer integer = publishTaskService.queryForTask(date);
        String publishTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String taskId = "T" + date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10) + integer.toString();

        Task task = new Task();
        task.setTaskId(taskId);
        task.setCategory1(category1);
        task.setCategory2(category2);
        task.setPublisher(user.getUserId());
        task.setPublishTime(publishTime);
        task.setDeadLine(deadline);
        task.setTheme(theme);
        task.setContent(content);
        task.setSpecial(special);
        task.setTLevel(tLevel);
        task.setPrice(price);
        task.setPublisherPhone(user.getTel());
        task.setTState(0);


        Boolean aBoolean = publishTaskService.AddTask(task,user.getUserId(),balance);
        if (aBoolean) {
            redirectAttributes.addFlashAttribute("msg", "委托发布成功");
        } else {
            redirectAttributes.addFlashAttribute("msg", "委托发布出错，请重试！");
        }

        return "redirect:/publishTask";
    }

}

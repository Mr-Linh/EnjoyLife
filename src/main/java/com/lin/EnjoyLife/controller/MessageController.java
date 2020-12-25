package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Message;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("userMessage")
    public String userMessage(HttpSession httpSession,
                              Model model) {

        String userId = httpSession.getAttribute("userId").toString();
        User user = messageService.initMessage(userId);
        model.addAttribute("userName", user.getUserName());
        return "userMessage";
    }

    @PostMapping("addMessage")
    public String addMessage(@RequestParam("message") String messageContent,
                             HttpSession httpSession,
                             RedirectAttributes redirectAttributes) {
        String userId = httpSession.getAttribute("userId").toString();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String MessageTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        Integer integer = messageService.messageCount(date);
        String MessageId = "Ms";
        MessageId += date.substring(0, 4) + date.substring(5, 7) + date.substring(8) + integer.toString();

        Message message = new Message();
        message.setMessageId(MessageId);
        message.setUserId(userId);
        message.setMessageTime(MessageTime);
        message.setMessageContent(messageContent);

        Boolean aBoolean = messageService.addMessage(message);
        if (aBoolean) {
            redirectAttributes.addFlashAttribute("msg", "感谢您的支持！");
        } else {
            redirectAttributes.addFlashAttribute("msg", "留言失败，请重试！");
        }
        return "redirect:/index";
    }

    @GetMapping("messageContent")
    @ResponseBody
    public Map<Object, Object> messageList() {
        Map<Object, Object> map = new HashMap<>();
        try {
//            System.out.println("查询");
            List<Message> messageList = messageService.messageShow();
            map.put("data", messageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}

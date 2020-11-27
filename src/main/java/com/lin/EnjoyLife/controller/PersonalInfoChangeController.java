package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class PersonalInfoChangeController {
    @Autowired
    PersonalInfoService personalInfoService;

    @PostMapping("/personalInfoChange")
    public String PersonalInfoChange(@RequestParam("sex") String sex,
                                     @RequestParam("phone") String tel,
                                     @RequestParam("email") String email,
                                     @RequestParam("address") String address,
                                     @RequestParam("education") String education,
                                     @RequestParam("profession") String profession,
                                     RedirectAttributes redirectAttributes,
                                     HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");
        Boolean aBoolean = personalInfoService.PersonalInfoChange(userId.toString(), sex, tel, email, address, education, profession);
        User user = personalInfoService.PersonalInfoInit(userId.toString());
        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","修改个人信息成功！");
        }else {
            redirectAttributes.addFlashAttribute("msg","修改个人信息失败！");
        }
        redirectAttributes.addFlashAttribute("userName",user.getUserName());
        return "redirect:/personalInfo";
    }
}

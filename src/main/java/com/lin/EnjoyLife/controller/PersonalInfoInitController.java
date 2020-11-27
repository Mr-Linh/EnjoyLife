package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PersonalInfoInitController {
    @Autowired
    PersonalInfoService personalInfoService;

    @GetMapping("/personalInfo")
    public String personalInfoInit(HttpSession httpSession,Model model){
        Object userId = httpSession.getAttribute("userId");
        User user = personalInfoService.PersonalInfoInit(userId.toString());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("realName",user.getRealName());
        model.addAttribute("sex",user.getSex());
        model.addAttribute("tel",user.getTel());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("identityNumber",user.getIdentityNumber());
        model.addAttribute("address",user.getAddress());
        model.addAttribute("education",user.getEducation());
        model.addAttribute("profession",user.getProfession());
        return "personalInfo";
    }
}

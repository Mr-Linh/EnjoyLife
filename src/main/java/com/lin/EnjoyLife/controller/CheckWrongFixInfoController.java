package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.CheckWrongFixInfoService;
import com.lin.EnjoyLife.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class CheckWrongFixInfoController {
    @Autowired
    CheckWrongFixInfoService checkWrongFixInfoService;
    @Autowired
    PersonalInfoService personalInfoService;

    @GetMapping("/checkWrongFixInfo")
    public String personalInfoInit(@RequestParam("userId")String userId,Model model){
        User user = personalInfoService.PersonalInfoInit(userId);
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
        return "checkWrongFixInfo";
    }

    @PostMapping("/fixInfoOption")
    public String fixInfoOption(@RequestParam("userId") String userId,  //error!!
                                @RequestParam("realName") String realName,
                                @RequestParam("sex") String sex,
                                @RequestParam("phone") String tel,
                                @RequestParam("email") String email,
                                @RequestParam("identity") String identityNumber,
                                @RequestParam("address") String address,
                                @RequestParam("education") String education,
                                @RequestParam("profession") String profession,
                                RedirectAttributes redirectAttributes){
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String date2 = date.substring(0, 4);
        int year = 0;
        year += date2.charAt(0);
        for (int i = 1; i < 4; i++) {
            year *= 10;
            year += date2.charAt(i);
        }
        int age = 0;
        String substring = identityNumber.substring(6, 10);
        age += substring.charAt(0);
        for (int i = 1; i <= 3; i++) {
            age *= 10;
            age += substring.charAt(i);
        }
        age = year - age;

        Boolean aBoolean = false;
        try {
//            System.out.println("123");
            aBoolean = checkWrongFixInfoService.CheckWrongFixInfo(userId, realName, sex, age, identityNumber, tel, email, address, education, profession);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(aBoolean){
            redirectAttributes.addFlashAttribute("msg","提交成功，等待管理员审核");

        }else {
            redirectAttributes.addFlashAttribute("msg","提交失败，请检查网络");
        }
        return "redirect:/login";
    }

}

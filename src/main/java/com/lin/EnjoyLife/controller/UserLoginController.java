package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/uCheck")
    public String UserLogin(@RequestParam("UserId") String UserId, @RequestParam("Password") String Password,
                            @RequestParam("card") String Card, @RequestParam("loginCodeHidden") String Code,
                            RedirectAttributes redirectAttributes, HttpSession httpSession) {
        if (!Code.equals(Card.toUpperCase())) {
            redirectAttributes.addFlashAttribute("UserLoginCodeError", "验证码错误");
            return "redirect:/login";
        }else{
            String s = userLoginService.UserLogin(UserId, Password);
            if (s.equals("登录成功")) {
                redirectAttributes.addFlashAttribute("UserId", UserId);
                httpSession.setAttribute("userId",UserId);
                return "redirect:/index";
            } else {
                redirectAttributes.addFlashAttribute("UserLoginError", s);
                return "redirect:/login";
            }
        }


    }
}

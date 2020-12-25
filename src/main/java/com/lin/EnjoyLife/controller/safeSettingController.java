package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Manager;
import com.lin.EnjoyLife.service.safeSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class safeSettingController {

    @Autowired
    safeSettingService safeSettingService;

    @GetMapping("/safeSetting")
    public String safeSettingInit(HttpSession httpSession, Model model){
        String managerId = httpSession.getAttribute("managerId").toString();
        try {
            Manager manager = safeSettingService.safeSettingInit(managerId);
            model.addAttribute(manager);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "safeSetting";
    }

    @PostMapping("/safeSettingConfig")
    public String safeSettingConfig(@RequestParam("oldPassword") String oldPassword,
                                    @RequestParam("password") String password,
                                    HttpSession httpSession,
                                    RedirectAttributes redirectAttributes){
        String managerId = httpSession.getAttribute("managerId").toString();
        try {
            Manager manager = safeSettingService.safeSettingInit(managerId);
            if(manager.getMPassword().equals(oldPassword)){
                try {
                    Boolean aBoolean = safeSettingService.safeSettingConfig(managerId, password);
                    if(aBoolean){
                        redirectAttributes.addFlashAttribute("msg","更改成功，下次登录时生效");
                    }else {
                        redirectAttributes.addFlashAttribute("msg","更改失败，请检查网络");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }else {
                redirectAttributes.addFlashAttribute("msg","密码输入错误，更改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/safeSetting";
    }
}

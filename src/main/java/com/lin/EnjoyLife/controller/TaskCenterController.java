package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.TaskCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TaskCenterController {

    @Autowired
    TaskCenterService taskCenterService;

    @GetMapping("/taskCenter")
    public String initTaskCenter(HttpSession httpSession, Model model){
        Object userId = httpSession.getAttribute("userId");
        User user = taskCenterService.initTaskCenter(userId.toString());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("userName",user.getUserName());
        return "taskCenter";
    }

    @GetMapping("/taskCenterSearch")
    @ResponseBody
    public Map<Object,Object> taskCenterSearch(@RequestParam("searchContent") String searchContent){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.taskCenterSearch(searchContent);
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/All")
    @ResponseBody
    public Map<Object, Object> initTaskCenterAll(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterListAll();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Life")
    @ResponseBody
    public Map<Object, Object> initTaskCenter1(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList1();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Life/housework")
    @ResponseBody
    public Map<Object, Object> initTaskCenter11(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList11();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Life/receive")
    @ResponseBody
    public Map<Object, Object> initTaskCenter12(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList12();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Life/send")
    @ResponseBody
    public Map<Object, Object> initTaskCenter13(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList13();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Life/other")
    @ResponseBody
    public Map<Object, Object> initTaskCenter14(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList14();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Study")
    @ResponseBody
    public Map<Object, Object> initTaskCenter2(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList2();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Study/computer")
    @ResponseBody
    public Map<Object, Object> initTaskCenter21(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList21();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Study/math")
    @ResponseBody
    public Map<Object, Object> initTaskCenter22(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList22();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Study/english")
    @ResponseBody
    public Map<Object, Object> initTaskCenter23(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList23();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Study/other")
    @ResponseBody
    public Map<Object, Object> initTaskCenter24(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList24();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Entertainment")
    @ResponseBody
    public Map<Object, Object> initTaskCenter3(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList3();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Entertainment/play")
    @ResponseBody
    public Map<Object, Object> initTaskCenter31(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList31();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Entertainment/eat")
    @ResponseBody
    public Map<Object, Object> initTaskCenter32(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList32();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Entertainment/chat")
    @ResponseBody
    public Map<Object, Object> initTaskCenter33(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList33();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Entertainment/other")
    @ResponseBody
    public Map<Object, Object> initTaskCenter34(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList34();
        map.put("data",tasks);
        return map;
    }

    @GetMapping("/taskCenter/Emergency")
    @ResponseBody
    public Map<Object, Object> initTaskCenter4(){
        Map<Object, Object> map = new HashMap<>();
        List<Task> tasks=taskCenterService.initTaskCenterList4();
        map.put("data",tasks);
        return map;
    }
}

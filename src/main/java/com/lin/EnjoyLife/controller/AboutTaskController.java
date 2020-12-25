package com.lin.EnjoyLife.controller;

import com.lin.EnjoyLife.pojo.TaskCategory;
import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.AboutTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AboutTaskController {

    @Autowired
    AboutTaskService aboutTaskService;

    @GetMapping("taskCategoriesFun")
    @ResponseBody
    public Map<String, Object> taskCategoriesShow(){

        List<Integer> numbers = aboutTaskService.aboutTaskCategory1();

        HashMap<String,Object> map = new HashMap<>();
        List<TaskCategory> taskCategories=new ArrayList<>();

        TaskCategory taskCategory1=new TaskCategory();
        TaskCategory taskCategory2=new TaskCategory();
        TaskCategory taskCategory3=new TaskCategory();
        TaskCategory taskCategory4=new TaskCategory();
        taskCategory1.setValue(numbers.get(0));
        taskCategory1.setName("生活类别");
        taskCategory2.setValue(numbers.get(1));
        taskCategory2.setName("咨询类别");
        taskCategory3.setValue(numbers.get(2));
        taskCategory3.setName("娱乐类别");
        taskCategory4.setValue(numbers.get(3));
        taskCategory4.setName("紧急委托");

        taskCategories.add(taskCategory1);
        taskCategories.add(taskCategory2);
        taskCategories.add(taskCategory3);
        taskCategories.add(taskCategory4);

        map.put("taskCategories",taskCategories);
//        String[] name={"生活类别","咨询类别","娱乐类别","紧急委托"};
//        map.put("value",numbers);
//        map.put("name",name);

        return map;
    }

    @GetMapping("registerNumFun")
    @ResponseBody
    public HashMap<String,Object> registerNumShow() throws ParseException {

        List<String> list1=new ArrayList<>();
        HashMap<String,Object> map = new HashMap<>();

//        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
//        Calendar cal = Calendar.getInstance();
//        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        if (w < 0)
//            w = 0;
//        for(int i=w+1;i<=w+7;i++){
//            list1.add(weekDays[i%7]);
//            list2.add(11);
//        }
//        System.out.println(list1);

        SimpleDateFormat sj=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,-7);
        for(int i=0;i<7;i++){
            calendar.add(Calendar.DATE,1);
//            System.out.println(sj.format(calendar.getTime()));
            list1.add(sj.format(calendar.getTime()));
        }

        List<Integer> list2 = aboutTaskService.taskPublishNum(list1);
//        System.out.println("昨天："+sj.format(calendar.getTime()));

        map.put("days",list1);
        map.put("num",list2);



        return map;
    }
}

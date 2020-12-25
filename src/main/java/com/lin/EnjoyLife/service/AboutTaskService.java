package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AboutTaskService {

    @Autowired
    TaskMapper taskMapper;

    public List<Integer> aboutTaskCategory1(){
        List<Integer> taskCategory=new ArrayList<>();
        taskCategory.add(taskMapper.selectCategory1("生活"));
        taskCategory.add(taskMapper.selectCategory1("咨询"));
        taskCategory.add(taskMapper.selectCategory1("娱乐"));
        taskCategory.add(taskMapper.selectCategory1("紧急"));

        return taskCategory;
    }

    public List<Integer> taskPublishNum(List<String> days){
        List<Integer> publishNum=new ArrayList<>();
        for (int i=0;i<7;i++){
            publishNum.add(taskMapper.queryForTask(days.get(i)).size());
        }
        return publishNum;
    }
}

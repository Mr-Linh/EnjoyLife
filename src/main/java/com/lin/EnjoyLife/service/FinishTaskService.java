package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinishTaskService {
    @Autowired
    TaskMapper taskMapper;

    public Boolean FinishTask(String taskId){
        try {
            Integer integer = taskMapper.finishTaskUpdate(taskId);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

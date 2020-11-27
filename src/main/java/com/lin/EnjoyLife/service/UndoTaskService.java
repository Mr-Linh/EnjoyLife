package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UndoTaskService {
    @Autowired
    TaskMapper taskMapper;

    public Boolean undoTask(String taskId){

        try {
            Integer integer = taskMapper.undoTaskUpdate(taskId);
            return integer==1;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}

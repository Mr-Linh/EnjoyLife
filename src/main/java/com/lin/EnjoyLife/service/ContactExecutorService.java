package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactExecutorService {
    @Autowired
    TaskMapper taskMapper;

    public Task ContactExecutor(String taskId){
        Task task = null;
        try {
            task=taskMapper.queryForTaskByTaskId(taskId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return task;
    }
}

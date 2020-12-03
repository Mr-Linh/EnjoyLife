package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyReceiptService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TaskMapper taskMapper;

    public User initMyReceipt(String userId){
        User user=null;
        try {
            user = userMapper.queryUserById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public List<Task> initMyReceiptList2(String executor){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskByExecutor2(executor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initMyReceiptList3(String executor){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskByExecutor3(executor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initMyReceiptList4(String executor){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskByExecutor4(executor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public Task queryForTaskByTaskId(String taskId){
        try {
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            return task;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptTaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserMapper userMapper;

    public User queryByUserId(String userId){
        User user = userMapper.queryUserById(userId);
        return user;
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

    public boolean receiptTaskUpdate(String taskId,String Executor){

        try {
            User user = userMapper.queryUserById(Executor);
            Integer integer = taskMapper.receiptTaskUpdate(taskId, Executor, user.getTel());
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}

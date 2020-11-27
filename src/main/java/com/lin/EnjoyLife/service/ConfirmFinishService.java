package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmFinishService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserMapper userMapper;

    public Boolean ConfirmFinish(String taskId) {
        try {
            Integer integer = taskMapper.confirmFinishUpdate(taskId);
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            User user = userMapper.queryUserById(task.getExecutor());
            int balance = user.getBalance() + task.getPrice();
            Integer integer1 = userMapper.updateUserBalance(task.getExecutor(), balance);
            Integer integer2 = userMapper.updateUserULevel(task.getExecutor(), user.getULevel() + 1);
            return integer == 1 && integer1==1 && integer2==1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

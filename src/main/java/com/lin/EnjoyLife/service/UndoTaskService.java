package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UndoTaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserMapper userMapper;

    public Boolean undoTask(String taskId) {
        Integer integer = 0;
        try {
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            User user = userMapper.queryUserById(task.getPublisher());
            int balance = task.getPrice();
            balance += user.getBalance();
            if (task.getCategory1().equals("紧急")) {
                balance += 200;
            }
            integer = userMapper.updateUserBalance(task.getPublisher(), balance);
            integer = taskMapper.undoTaskUpdate(taskId);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return integer == 1;
    }
}

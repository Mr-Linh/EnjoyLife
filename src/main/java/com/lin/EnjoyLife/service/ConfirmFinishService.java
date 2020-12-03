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
        Integer integer = 0;
        try {
            integer = taskMapper.confirmFinishUpdate(taskId);
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            User user = userMapper.queryUserById(task.getExecutor());
            int balance = user.getBalance() + task.getPrice();
            if (task.getCategory1().equals("紧急")) {
                User user1 = userMapper.queryUserById(task.getPublisher());
                integer = userMapper.updateUserBalance(task.getPublisher(), user1.getBalance() + 200);
            }
            integer = userMapper.updateUserBalance(task.getExecutor(), balance);
            integer = userMapper.updateUserULevel(task.getExecutor(), user.getULevel() + 1);
            integer = taskMapper.giveScore(taskId, 4.99);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer == 1;
    }
}

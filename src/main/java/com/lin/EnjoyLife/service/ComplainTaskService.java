package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainTaskService {

    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserMapper userMapper;

    public Boolean ComplainTask(String taskId, String appealReason) {
        try {
            Integer integer = taskMapper.complainTaskUpdate(taskId);
            Integer integer1 = taskMapper.addReasonUpdate(taskId, appealReason);
            return integer == 1 && integer1 == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Task> queryForTaskComplain() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryForTaskComplain();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public List<Task> queryForTaskComplainPage(Integer page, Integer limit) {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryForTaskComplainPage((page - 1) * limit, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Integer complainTaskPass(String taskId) {
        Integer integer = 0;
        try {
            integer = taskMapper.complainTaskPassUpdate(taskId);
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            User user = userMapper.queryUserById(task.getPublisher());
            int balance = task.getPrice() + user.getBalance();
            if (task.getCategory1().equals("紧急")) {
                balance += 200;
            }
            integer = userMapper.updateUserBalance(user.getUserId(), balance);
            integer = taskMapper.giveScore(taskId, 4.99);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    public Integer complainTaskWrong(String taskId) {
        Integer integer = 0;
        try {
            integer = taskMapper.complainTaskWrongUpdate(taskId);
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            User user = userMapper.queryUserById(task.getExecutor());
            int balance = task.getPrice() + user.getBalance();
            integer = userMapper.updateUserBalance(user.getUserId(), balance);
            integer = userMapper.updateUserULevel(user.getUserId(), user.getULevel() + 1);
            integer = taskMapper.giveScore(taskId, 4.99);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    public Boolean undoComplain(String taskId) {
        Integer integer = 0;
        try {
            integer = taskMapper.undoComplain(taskId);
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            User user = userMapper.queryUserById(task.getExecutor());
            int balance = task.getPrice() + user.getBalance();
            if (task.getCategory1().equals("紧急")){
                User user1 = userMapper.queryUserById(task.getPublisher());
                integer = userMapper.updateUserBalance(user1.getUserId(), user1.getBalance() + 200);
            }
            integer = userMapper.updateUserBalance(user.getUserId(), balance);
            integer = userMapper.updateUserULevel(user.getUserId(), user.getULevel() + 1);
            integer = taskMapper.giveScore(taskId, 4.99);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer == 1;
    }
}

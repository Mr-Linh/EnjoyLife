package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCheckService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserMapper userMapper;

    public List<Task> queryforTaskCheck() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryForTaskCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> queryforCheckPage(Integer page, Integer limit) {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryForTaskCheckPage((page - 1) * limit, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Boolean taskCheckOption(String taskId) {
        try {
            Integer integer = taskMapper.taskPassUpdate(taskId);
            return integer == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean taskCheckWrongOption(String taskId) {
        try {
            Integer integer = taskMapper.taskWrongUpdate(taskId);
            Task task = taskMapper.queryForTaskByTaskId(taskId);
            User user = userMapper.queryUserById(task.getPublisher());
            Integer integer1 = userMapper.updateUserBalance(user.getUserId(), user.getBalance() + task.getPrice());
            return integer == 1 && integer1 == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //    public List<User> accountCheckSearchById(String userId) {
//        List<User> users = null;
//        try {
//            tasks = taskMapper.accountCheckSearchById(userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public List<User> accountCheckSearchByIdPage(String userId, Integer page, Integer limit) {
//        List<User> users = null;
//        try {
//            users = userMapper.accountCheckSearchByIdPage(userId, (page - 1) * limit, limit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
}

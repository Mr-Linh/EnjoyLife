package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPublishService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TaskMapper taskMapper;

    public User initMyPublish(String userId) {
        User user = null;
        try {
            user = userMapper.queryUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<Task> initMyPublishList1(String publisher) {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskByPublisher1(publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initMyPublishList2(String publisher) {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskByPublisher2(publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initMyPublishList3(String publisher) {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskByPublisher3(publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initMyPublishList4(String publisher) {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskByPublisher4(publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Task queryForTaskByTaskId(String taskId) {
        Task task = null;
        try {
            task = taskMapper.queryForTaskByTaskId(taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }

}

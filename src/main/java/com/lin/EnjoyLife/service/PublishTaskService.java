package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishTaskService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    TaskMapper taskMapper;

    public User PublishTaskInit(String userId){
        User user = userMapper.queryUserById(userId);
        return user;
    }

    public Integer queryForTask(String date){
        int size=0;
        try {
            List<Task> tasks = taskMapper.queryForTask(date);
            size = tasks.size()+1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return size;
    }

    public Boolean AddTask(Task task, String userId, Integer balance){
        try {
            Integer integer = taskMapper.addTask(task);
            Integer integer1 = userMapper.updateUserBalance(userId, balance);
            return integer==1 && integer1==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

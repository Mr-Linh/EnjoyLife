package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Task;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCenterService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TaskMapper taskMapper;

    public User initTaskCenter(String userId){
        User user=null;
        try {
            user = userMapper.queryUserById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public Task queryForTaskByTaskId(String taskId){
        Task task=null;
        try {
             task = taskMapper.queryForTaskByTaskId(taskId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return task;
    }

    public List<Task> taskCenterSearch(String searchContent){
        List<Task> tasks = null;
        try{
//            System.out.println("获取到的查询内容："+searchContent);
            tasks=taskMapper.taskCenterSearch(searchContent);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterListAll(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskListAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList1(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList("生活");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList11(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("生活","家政");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
    public List<Task> initTaskCenterList12(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("生活","代领");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
    public List<Task> initTaskCenterList13(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("生活","代送");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
    public List<Task> initTaskCenterList14(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("生活","其他");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList2(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList("学习");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList21(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("学习","计算机");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
    public List<Task> initTaskCenterList22(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("学习","数学");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList23(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("学习","英语");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList24(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("学习","其他");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }


    public List<Task> initTaskCenterList3(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList("娱乐");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
    public List<Task> initTaskCenterList31(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("娱乐","陪玩");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
    public List<Task> initTaskCenterList32(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("娱乐","陪吃");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList33(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("娱乐","陪聊");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList34(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList2("娱乐","其他");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList4(){
        List<Task> tasks = null;
        try{
            tasks=taskMapper.queryTaskList("紧急");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

}

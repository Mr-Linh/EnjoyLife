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

    public User initTaskCenter(String userId) {
        User user = null;
        try {
            user = userMapper.queryUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Boolean discardTask(List<String> tasks) {
        try {
            for (String task : tasks) {
                Integer integer = taskMapper.discardTask(task);
                Task task1 = taskMapper.queryForTaskByTaskId(task);
                User user = userMapper.queryUserById(task1.getPublisher());
                int balance=user.getBalance() + task1.getPrice();
                if(task1.getCategory1().equals("紧急")){
                    balance+=200;
                }
                Integer integer1 = userMapper.updateUserBalance(user.getUserId(), balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
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

    public List<Task> taskCenterSearch(String searchContent) {
        List<Task> tasks = null;
        try {
//            System.out.println("获取到的查询内容："+searchContent);
            tasks = taskMapper.taskCenterSearch(searchContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterListAll() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskListAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList1() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList("生活");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList11() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("生活", "家政");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList12() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("生活", "代驾");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList13() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("生活", "跑腿");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList14() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("生活", "其他");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList2() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList("咨询");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList21() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("咨询", "考证");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList22() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("咨询", "技术");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList23() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("咨询", "人文");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList24() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("咨询", "其他");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }


    public List<Task> initTaskCenterList3() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList("娱乐");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList31() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("娱乐", "运动");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList32() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("娱乐", "摄影");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList33() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("娱乐", "音乐");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList34() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList2("娱乐", "其他");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> initTaskCenterList4() {
        List<Task> tasks = null;
        try {
            tasks = taskMapper.queryTaskList("紧急");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

}

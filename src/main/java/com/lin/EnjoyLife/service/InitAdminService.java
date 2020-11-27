package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.PageViewMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.PageView;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitAdminService {

    @Autowired
    PageViewMapper pageViewMapper;
    @Autowired
    UserMapper userMapper;


    public PageView searchByPid(Integer pid){
        PageView pageView = null;
        try {
            pageView = pageViewMapper.searchByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageView;
    }

    public List<User> queryForAllUsers(){
        List<User> users=null;
        try {
            users=userMapper.queryForAllUsers();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
}

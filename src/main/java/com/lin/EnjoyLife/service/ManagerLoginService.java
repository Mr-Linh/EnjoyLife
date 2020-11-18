package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.ManagerMapper;
import com.lin.EnjoyLife.pojo.Manager;
import com.lin.EnjoyLife.pojo.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerLoginService {

    @Autowired
    ManagerMapper managerMapper;

    public Boolean ManagerLogin(String ManagerId,String MPassword){
        Manager manager = null;
        try {
            manager = managerMapper.searchByManagerId(ManagerId);
            if(manager.getMPassword().equals(MPassword)){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

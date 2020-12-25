package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.ManagerMapper;
import com.lin.EnjoyLife.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class safeSettingService {

    @Autowired
    ManagerMapper managerMapper;

    public Manager safeSettingInit(String managerId){

        try {
            Manager manager = managerMapper.searchByManagerId(managerId);
            return manager;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Boolean safeSettingConfig(String managerId,String password){

        try {
            Integer integer = managerMapper.safeSettingConfig(managerId, password);
            return integer==1;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}

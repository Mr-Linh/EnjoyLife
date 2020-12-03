package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiveScoreService {
    @Autowired
    TaskMapper taskMapper;

    public Boolean giveScore(String taskId,double score){
        Integer integer=0;
        try {
            integer = taskMapper.giveScore(taskId, score);
        }catch (Exception e){
            e.printStackTrace();
        }

        return integer==1;
    }
}

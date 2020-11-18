package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.PageViewMapper;
import com.lin.EnjoyLife.pojo.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageViewService{

    @Autowired
    PageViewMapper pageViewMapper;

    /**
     * 基于页面id查询访问次数
     * 返回次数
     * @param pid
     * @return
     */

    public PageView searchByPid(Integer pid){
        PageView pageView = null;
        try {
            pageView = pageViewMapper.searchByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageView;
    }
}

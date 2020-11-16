package com.lin.EnjoyLife.interceptor;

import com.lin.EnjoyLife.pojo.User;
import com.lin.EnjoyLife.service.IPageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class PageViewInterceptor implements HandlerInterceptor {
//    @Autowired
//    IPageViewService service;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        request.getRequestURI().lastIndexOf("/");
//
//        return true;
//    }
}

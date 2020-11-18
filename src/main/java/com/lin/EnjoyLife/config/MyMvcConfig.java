package com.lin.EnjoyLife.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
//    @Autowired
//    @Qualifier("pageViewInterceptor")
//    HandlerInterceptor interceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
//        InterceptorRegistration ir = registry.addInterceptor(interceptor);
//        // 设置黑名单 /** 表示通配多级目录
//        ir.addPathPatterns("/**");
//        // 创建保存放行路径的集合
//        List<String> list = new ArrayList<>();
//        // 添加静态资源路径
//        list.add("/bootstrap-3.3.7-dist/**");
//        list.add("/css/**");
//        list.add("/img/**");
//        list.add("/js/**");
//        list.add("/index.html");
//        list.add("/admin.html");
//        list.add("/login.html");
//        // 添加白名单
//        ir.excludePathPatterns(list);
//    }

}

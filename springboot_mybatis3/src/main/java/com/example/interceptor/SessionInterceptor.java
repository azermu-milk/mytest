package com.example.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Administrator on 2019/12/30.
 */
@Configuration
public class SessionInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List list = new ArrayList<>();

        list.add("/user/index.html");
        list.add("/user/toregister");
        list.add("/user/login");
        list.add("/user/register");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**").excludePathPatterns(list);
    }
}

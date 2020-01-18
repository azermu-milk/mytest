package com.example.interceptor;

import com.example.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by Administrator on 2019/12/30.
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了preHandle");
        System.out.println(handler);
        User user = (User) request.getSession().getAttribute("session_user");
        if(user == null){
            response.sendRedirect(request.getContextPath()+"/user/index.html");
            System.out.println("成功拦截并跳转");
            return false;
        }
        System.out.println("无需拦截");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行了afterCompletion");
    }
}

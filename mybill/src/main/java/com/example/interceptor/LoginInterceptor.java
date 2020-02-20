package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by Administrator on 2020/2/19.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            return true;
        }
        //request.getRequestDispatcher("/index.html").forward(request, response);
        response.sendRedirect(request.getContextPath()+"/index.html");
        return false;
    }
}

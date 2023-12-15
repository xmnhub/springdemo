package com.example.demo.hello.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MyInterceptor implements HandlerInterceptor {
private LocalDateTime start;
    private LocalDateTime end;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在处理请求之前执行的操作
        start = LocalDateTime.now();
        return true; // 如果返回true，表示继续处理请求；如果返回false，表示停止处理请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在处理请求之后执行的操作
        end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("请求处理时间：" + duration.toMillis());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在处理请求完成后执行的操作
    }
}


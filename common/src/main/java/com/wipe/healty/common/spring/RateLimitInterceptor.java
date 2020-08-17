package com.wipe.healty.common.spring;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问频率控制
 *
 * @author changjiang.tang Date:7/31/15 Time:3:49 PM
 */
@ControllerAdvice
public class RateLimitInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);

    }
}

package org.xue.xue_iot.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.xue.xue_iot.pojo.Result;
import org.xue.xue_iot.utils.JWTutil;

import java.util.Map;

@Component
public class Logininterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JWTutil.parseToken(token);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }
}
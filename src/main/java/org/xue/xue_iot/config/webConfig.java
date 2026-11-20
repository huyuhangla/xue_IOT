package org.xue.xue_iot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xue.xue_iot.interceptors.Logininterceptor;

@Configuration
public class webConfig implements WebMvcConfigurer {
    @Autowired
    private Logininterceptor logininterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logininterceptor).excludePathPatterns("/user/login","/user/register");
    }
}

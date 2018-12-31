package io.itracybryant.initializestarter.config;

import io.itracybryant.initializestarter.controller.interceptor.OneInterceptor;
import io.itracybryant.initializestarter.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMvcConfigurer
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/29 20:40
 * @Version 1.0
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器按顺序执行
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/One/**");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/Two/**").addPathPatterns("/One/**");
        super.addInterceptors(registry);
    }
}

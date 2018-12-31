package io.itracybryant.initializestarter.controller.interceptor;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static io.itracybryant.initializestarter.controller.interceptor.OneInterceptor.returnErrorResponse;

/**
 * @ClassName TwoInterceptor
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/29 20:47
 * @Version 1.0
 */
public class TwoInterceptor implements HandlerInterceptor {

    final static Logger logger = LoggerFactory.getLogger(TwoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(true){
            returnErrorResponse(httpServletResponse, ItJsonResult.errorMsg("被Two拦截---------------"));
        }
        System.out.println("被Two拦截****************");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}

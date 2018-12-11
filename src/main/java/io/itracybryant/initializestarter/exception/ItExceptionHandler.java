package io.itracybryant.initializestarter.exception;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ExceptionHandler
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 19:34
 * @Version 1.0
 */
@ControllerAdvice
public class ItExceptionHandler {

    public static final String IT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        if (isAjax(request)) {
            return ItJsonResult.errorException(e.getMessage());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.setViewName(IT_ERROR_VIEW);
            return modelAndView;
        }
    }

    /**
     * 判断是否是Ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}

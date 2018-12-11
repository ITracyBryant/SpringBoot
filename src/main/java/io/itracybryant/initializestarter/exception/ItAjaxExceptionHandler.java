package io.itracybryant.initializestarter.exception;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ItAjaxExceptionHandler
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 19:49
 * @Version 1.0
 */

/**
 * @RestControllerAdvice
 */
public class ItAjaxExceptionHandler {

    /**
     * @ExceptionHandler(value = Exception.class)
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    public ItJsonResult defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
        e.printStackTrace();
        return ItJsonResult.errorException(e.getMessage());
    }
}

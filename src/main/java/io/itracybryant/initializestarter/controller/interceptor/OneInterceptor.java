package io.itracybryant.initializestarter.controller.interceptor;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import io.itracybryant.initializestarter.utils.JsonUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName OneInterceptor
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/29 20:46
 * @Version 1.0
 */
public class OneInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前调用(Controller方法调用之前)
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(true){
            returnErrorResponse(httpServletResponse, ItJsonResult.errorMsg("被One拦截----------"));
        }
        System.out.println("被One拦截之后，放行--------------");
        return false;
    }

    /**
     * 请求处理之后调用（但在视图被渲染之前，Controller方法调用之后）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，即DispatcherServlet渲染对应视图之后执行(主要用于进行资源清理工作)
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public static void returnErrorResponse(HttpServletResponse response, ItJsonResult result) throws IOException, UnsupportedEncodingException {
        OutputStream os = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            os = response.getOutputStream();
            os.write(JsonUtil.objectToJson(result).getBytes("utf-8"));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}

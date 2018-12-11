package io.itracybryant.initializestarter.controller;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ErrorController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 19:31
 * @Version 1.0
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {
        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public ItJsonResult getAjaxerror() {
        int a = 1 / 0;
        return ItJsonResult.ok();
    }
}

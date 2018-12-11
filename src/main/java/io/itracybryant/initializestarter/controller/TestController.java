package io.itracybryant.initializestarter.controller;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import io.itracybryant.initializestarter.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 11:26
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello(){
        return "hello SpringBoot!";
    }

    @RequestMapping("/getResource")
    public ItJsonResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return ItJsonResult.ok(bean);
    }

}

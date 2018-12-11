package io.itracybryant.initializestarter.controller;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import io.itracybryant.initializestarter.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @RestController = @Controller + @ResponseBody
 * @ResponseBody 返回的数据以json对象为主
 * @ClassName TestController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 11:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setName("it");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("xy");
        user.setDesc("it ~~ xy!");
        return user;
    }

    @RequestMapping("/getUserJson")
    public ItJsonResult getUserJson(){
        User user = new User();
        user.setName("it");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("xy");
        return ItJsonResult.ok(user);
    }

}

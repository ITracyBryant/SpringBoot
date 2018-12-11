package io.itracybryant.initializestarter.controller;

import io.itracybryant.initializestarter.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ThymeleafController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 18:08
 * @Version 1.0
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "thymeleaf-IT");
        return "/thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap modelMap) {
        User user = new User();
        user.setName("XY");
        user.setPassword("IT");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>XY -- IT</b></font>");
        modelMap.addAttribute("user", user);

        User user1 = new User();
        user1.setName("xy");
        user1.setPassword("it");
        user1.setAge(17);
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setName("ti");
        user2.setPassword("yx");
        user2.setAge(19);
        user2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postform(User user) {
        System.out.println("姓名：" + user.getName());
        System.out.println("年龄：" + user.getAge());
        return "redirect:/th/test";
    }

}

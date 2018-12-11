package io.itracybryant.initializestarter.controller;

import io.itracybryant.initializestarter.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName FreemarkerController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/11 16:59
 * @Version 1.0
 */
@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("resource",resource);
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "freemarker/center/center";
    }
}

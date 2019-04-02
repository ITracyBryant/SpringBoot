package io.itracybryant.initializestarter.controller;

import io.itracybryant.initializestarter.pojo.ItItem;
import io.itracybryant.initializestarter.service.ItemSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ItemController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/5 19:06
 * @Version 1.0
 */
@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemSerivce itemSerivce;

    @RequestMapping("item")
    public String item(ModelMap modelMap) {
        ItItem itItem = new ItItem();
        itItem.setVariety("热卷");
        itItem.setAuthorization("HC1905");
        itItem.setSubjectPrice("3226.00");
        itItem.setBidPrice("87.37");
        itItem.setSellPrice("100.09");

        ItItem itItem1 = new ItItem();
        itItem1.setVariety("焦炭");
        itItem1.setAuthorization("J1905");
        itItem1.setSubjectPrice("1844.50");
        itItem1.setBidPrice("66.41");
        itItem1.setSellPrice("80.73");

        List<ItItem> itItemList = new ArrayList<>();
        itItemList.add(itItem);
        itItemList.add(itItem1);
        //List<ItItem> itItemList = itemSerivce.queryItemList(itItem);
        modelMap.addAttribute("itItemList", itItemList);
        return "thymeleaf/item";
    }

}

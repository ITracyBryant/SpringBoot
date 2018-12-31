package io.itracybryant.initializestarter.controller;

import io.itracybryant.initializestarter.pojo.ItJsonResult;
import io.itracybryant.initializestarter.pojo.ItUser;
import io.itracybryant.initializestarter.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MyBatisCrudController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 22:13
 * @Version 1.0
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisCrudController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public ItJsonResult saveUser() throws Exception {

        String userId = sid.nextShort();

        ItUser user = new ItUser();
        user.setId(userId);
        user.setUsername("zy" + new Date());
        user.setNickname("xy" + new Date());
        user.setPassword("711");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return ItJsonResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public ItJsonResult updateUser() {

        ItUser user = new ItUser();
        user.setId("103103");
        user.setUsername("103103-updated" + new Date());
        user.setNickname("103103-updated" + new Date());
        user.setPassword("103103-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return ItJsonResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public ItJsonResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return ItJsonResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public ItJsonResult queryUserById(String userId) {

        return ItJsonResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public ItJsonResult queryUserList() {

        ItUser user = new ItUser();
        user.setUsername("像风一样");
        user.setNickname("吹过");

        List<ItUser> userList = userService.queryUserList(user);

        return ItJsonResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public ItJsonResult queryUserListPaged(Integer page) {

        //开始分页
        if (page == null) {
            page = 1;
        }

        int pageSize = 10;

        ItUser user = new ItUser();
        user.setNickname("不问");

        List<ItUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return ItJsonResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public ItJsonResult queryUserByIdCustom(String userId) {

        return ItJsonResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/saveUserTransactional")
    public ItJsonResult saveUserTransactional() {

        String userId = sid.nextShort();

        ItUser user = new ItUser();
        user.setId(userId);
        user.setUsername("zy" + new Date());
        user.setNickname("xy" + new Date());
        user.setPassword("10");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return ItJsonResult.ok("保存成功");
    }
}

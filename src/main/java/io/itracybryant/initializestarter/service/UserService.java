package io.itracybryant.initializestarter.service;

import io.itracybryant.initializestarter.pojo.ItUser;

import java.util.List;

/**
 * @InterfaceName UserService
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/14 15:28
 * @Version 1.0
 */
public interface UserService {
    void saveUser(ItUser itUser) throws Exception;

    void updateUser(ItUser itUser);

    void deleteUser(String userId);

    ItUser queryUserById(String userId);

    List<ItUser> queryUserList(ItUser itUser);

    List<ItUser> queryUserListPaged(ItUser itUser, Integer page, Integer pageSize);

    ItUser queryUserByIdCustom(String userId);

    void saveUserTransactional(ItUser itUser);

}

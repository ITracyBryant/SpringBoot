package io.itracybryant.initializestarter.service;

import io.itracybryant.initializestarter.pojo.ItItem;

import java.util.List;

/**
 * @InterfaceName ItemSerivce
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/5 19:20
 * @Version 1.0
 */
public interface ItemSerivce {

    ItItem queryItemById(Integer itemId);

    List<ItItem> queryItemList(ItItem itItem);

    void saveItem(ItItem itItem);

    void updateItem(ItItem itItem);

    void deleteItem(String itemId);

}

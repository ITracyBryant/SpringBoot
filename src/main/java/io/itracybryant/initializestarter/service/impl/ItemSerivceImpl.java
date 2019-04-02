package io.itracybryant.initializestarter.service.impl;

import io.itracybryant.initializestarter.mapper.ItItemMapper;
import io.itracybryant.initializestarter.pojo.ItItem;
import io.itracybryant.initializestarter.service.ItemSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName ItemSerivceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/5 19:26
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Service
public class ItemSerivceImpl implements ItemSerivce {

    @Autowired
    private ItItemMapper itItemMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public ItItem queryItemById(Integer itemId) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return itItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ItItem> queryItemList(ItItem itItem) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Example example = new Example(ItItem.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(itItem.getVariety())) {
            criteria.andEqualTo("variety", itItem.getVariety());
        }

        List<ItItem> itItemList = itItemMapper.selectByExample(example);
        return itItemList;
    }

    @Override
    public void saveItem(ItItem itItem) {

    }

    @Override
    public void updateItem(ItItem itItem) {

    }

    @Override
    public void deleteItem(String itemId) {

    }
}

package io.itracybryant.initializestarter.service.impl;

import com.github.pagehelper.PageHelper;
import io.itracybryant.initializestarter.mapper.ItUserMapper;
import io.itracybryant.initializestarter.mapper.ItUserMapperCustom;
import io.itracybryant.initializestarter.pojo.ItUser;
import io.itracybryant.initializestarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/14 16:52
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ItUserMapper itUserMapper;

    @Autowired
    private ItUserMapperCustom itUserMapperCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveUser(ItUser itUser) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itUserMapper.insert(itUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateUser(ItUser itUser) {
        itUserMapper.updateByPrimaryKeySelective(itUser);
        //itUserMapper.updateByPrimaryKey(itUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteUser(String userId) {
        itUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public ItUser queryUserById(String userId) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return itUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ItUser> queryUserList(ItUser itUser) {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Example example = new Example(ItUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(itUser.getUsername())) {
            criteria.andEqualTo("username", itUser.getUsername());
            //criteria.andLike("username","%" + itUser.getUsername() + "%");
        }
        if (!StringUtils.isEmptyOrWhitespace(itUser.getNickname())) {
            criteria.andLike("nickname", "%" + itUser.getNickname() + "%");
        }
        List<ItUser> itUserList = itUserMapper.selectByExample(example);
        return itUserList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ItUser> queryUserListPaged(ItUser itUser, Integer page, Integer pageSize) {
        // 开始分页操作
        PageHelper.startPage(page, pageSize);
        Example example = new Example(ItUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(itUser.getNickname())) {
            criteria.andLike("nickname", "%" + itUser.getNickname() + "%");
        }
        example.orderBy("registryTime").desc();
        List<ItUser> userList = itUserMapper.selectByExample(example);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ItUser queryUserByIdCustom(String userId) {
        List<ItUser> itUserList = itUserMapperCustom.queryUserSimpleInfoById(userId);
        if (itUserList != null && !itUserList.isEmpty()) {
            return (ItUser) itUserList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveUserTransactional(ItUser itUser) {
        itUserMapper.insert(itUser);
        int a = 1 / 0;
        itUser.setIsDelete(1);
        itUserMapper.updateByPrimaryKeySelective(itUser);
    }
}

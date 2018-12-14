package io.itracybryant.initializestarter.mapper;

import io.itracybryant.initializestarter.pojo.ItUser;

import java.util.List;

public interface ItUserMapperCustom{
    List<ItUser> queryUserSimpleInfoById(String userId);
}
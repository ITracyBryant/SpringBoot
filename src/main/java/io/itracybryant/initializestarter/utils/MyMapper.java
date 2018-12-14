package io.itracybryant.initializestarter.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 * @ClassName MyMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/12 10:42
 * @Version 1.0
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}

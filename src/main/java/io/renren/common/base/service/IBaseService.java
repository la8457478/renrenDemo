package io.renren.common.base.service;


import com.baomidou.mybatisplus.service.IService;

import io.renren.common.base.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> extends IService<T> {



    List<T> queryByParams(Map<String, Object> params);

    List<T> queryByProperty(String property, Object value);

    int countByParams(Map<String, Object> params);

    List<T> queryByParamsDistinc(Map<String, Object> params);

    T getOneByParams(Map<String, Object> params);
}
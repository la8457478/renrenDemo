package io.renren.common.base.service;


import io.renren.common.base.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> {


    CommonMapper<T> getMapper();

    T getOne(T record);

    List<T> getByRecord(T record);

    List<T> getAll();

    int count(T record);

    T get(Object key);

    boolean existsWithPrimaryKey(Object key);

    int save(List<T> records);

    int save(T record);


    int update(T record);

    int updateIgnoreNull(T record);

    int delete(T record);

    int deleteById(Object key);

     int deleteByIds(String ids);

    int deleteByIds(Long[] ids);

    List<T> getByExample(Object example);

    T getOneByExample(Object example);

    int countByExample(Object example);

    int deleteByExample(Object example);

    int deleteByParams(Map<String, Object> params);

    int updateByExample(@Param("record") T record, @Param("example") Object example);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

    List<T> getByExampleAndRowBounds(Object example, RowBounds rowBounds);

    List<T> getByRowBounds(T record, RowBounds rowBounds);

    List<T> queryByParams(Map<String, Object> params);

    List<T> queryByProperty(String property, Object value);

    int countByParams(Map<String, Object> params);

    List<T> queryByParamsDistinc(Map<String, Object> params);

    T getOneByParams(Map<String, Object> params);
}
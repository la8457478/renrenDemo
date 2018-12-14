package io.renren.common.base.service;


import io.renren.common.base.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface IBaseService<T> {


    CommonMapper<T> getMapper();

    T selectOne(T record);

    List<T> select(T record);

    List<T> selectAll();

    int selectCount(T record);

    T selectByPrimaryKey(Object key);

    boolean existsWithPrimaryKey(Object key);

    int insert(T record);

    int insertSelective(T record);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

    int delete(T record);

    int deleteByPrimaryKey(Object key);

    List<T> selectByExample(Object example);

    T selectOneByExample(Object example);

    int selectCountByExample(Object example);

    int deleteByExample(Object example);

    int updateByExample(@Param("record") T record, @Param("example") Object example);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

    List<T> selectByRowBounds(T record, RowBounds rowBounds);

}
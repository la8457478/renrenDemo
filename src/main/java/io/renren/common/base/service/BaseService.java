package io.renren.common.base.service;

import io.renren.common.exception.RRException;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional(
        rollbackFor = {RRException.class}
)
public abstract class BaseService<T> implements IBaseService<T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private Class<?> clazz = null;

    protected Class<?> getEntityClass() {
        if (clazz == null) {
            clazz = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clazz;
    }

    @Override
    public T selectOne(T record) {
        return this.getMapper().selectOne(record);
    }

    @Override
    public List<T> select(T record) {
        return this.getMapper().select(record);
    }

    @Override
    public List<T> selectAll() {
        return this.getMapper().selectAll();
    }

    @Override
    public int selectCount(T record) {
        return this.getMapper().selectCount(record);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return this.getMapper().selectByPrimaryKey(key);
    }

    @Override
    public boolean existsWithPrimaryKey(Object key) {
        return this.getMapper().existsWithPrimaryKey(key);
    }

    @Override
    public int insert(T record) {
        return this.getMapper().insert(record);

    }

    @Override
    public int insertSelective(T record) {
        return this.getMapper().insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return this.getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return this.getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(T record) {
        return this.getMapper().delete(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return this.getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return this.getMapper().selectByExample(example);
    }

    @Override
    public T selectOneByExample(Object example) {
        return this.getMapper().selectOneByExample(example);
    }

    @Override
    public int selectCountByExample(Object example) {
        return this.getMapper().selectCountByExample(example);
    }

    @Override
    public int deleteByExample(Object example) {
        return this.getMapper().deleteByExample(example);
    }

    @Override
    public int updateByExample(T record, Object example) {
        return this.getMapper().updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(T record, Object example) {
        return this.getMapper().updateByExampleSelective(record, example);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return this.getMapper().selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return this.getMapper().selectByExampleAndRowBounds(record, rowBounds);
    }
}

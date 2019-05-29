package io.renren.common.base.service;

import io.renren.common.example.DynamicSpecification;
import io.renren.common.exception.RRException;
import tk.mybatis.mapper.entity.Example;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public T getOne(T record) {
        return this.getMapper().selectOne(record);
    }

    @Override
    public List<T> getByRecord(T record) {
        return this.getMapper().select(record);
    }

    @Override
    public List<T> getAll() {
        return this.getMapper().selectAll();
    }

    @Override
    public int count(T record) {
        return this.getMapper().selectCount(record);
    }

    @Override
    public T get(Object key) {
        return this.getMapper().selectByPrimaryKey(key);
    }

    @Override
    public boolean existsWithPrimaryKey(Object key) {
        return this.getMapper().existsWithPrimaryKey(key);
    }

    @Override
    public int save(List<T> records) {
        int effactRows = 0;
        for (T record :
            records) {
            effactRows += this.getMapper().insert(record);
        }
        return effactRows;
    }

    @Override
    public int save(T record) {
        return this.getMapper().insert(record);
    }

    @Override
    public int update(T record) {
        return this.getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateIgnoreNull(T record) {
        return this.getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(T record) {
        return this.getMapper().delete(record);
    }

    @Override
    public int deleteById(Object key) {
        return this.getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.getMapper().deleteByIds(ids);
    }

    @Override
    public int deleteByIds(Long[] ids) {

        return this.getMapper().deleteByIds(StringUtils.join(ids));
    }

    @Override
    public List<T> getByExample(Object example) {
        return this.getMapper().selectByExample(example);
    }

    @Override
    public T getOneByExample(Object example) {
        return this.getMapper().selectOneByExample(example);
    }

    @Override
    public int countByExample(Object example) {
        return this.getMapper().selectCountByExample(example);
    }

    @Override
    public int deleteByExample(Object example) {
        return this.getMapper().deleteByExample(example);
    }

    @Override
    public int deleteByParams(Map<String, Object> params) {
        return this.getMapper().deleteByExample(this.generateExample(params));
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
    public List<T> getByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return this.getMapper().selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public List<T> getByRowBounds(T record, RowBounds rowBounds) {
        return this.getMapper().selectByExampleAndRowBounds(record, rowBounds);
    }

    @Override
    public List<T> queryByParams(Map<String, Object> params) {
        return this.getMapper().selectByExample(this.generateExample(params));
    }

    @Override
    public List<T> queryByProperty(String property, Object value) {
        Map params = new HashMap();
        params.put(property, value);
        return this.getMapper().selectByExample(this.generateExample(params));
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return this.getMapper().selectCountByExample(this.generateExample(params));
    }

    @Override
    public List<T> queryByParamsDistinc(Map<String, Object> params) {
        Example example = this.generateExample(params, true);
        example.setDistinct(true);
        return this.getMapper().selectByExample(example);
    }

    @Override
    public T getOneByParams(Map<String, Object> params) {
        return this.getMapper().selectOneByExample(this.generateExample(params));
    }

    public Example generateExample(Map<String, Object> params, Boolean distinct) {
        DynamicSpecification<T> dynamicSpecification = new DynamicSpecification<T>(params, distinct);
        Example example = new Example(getEntityClass());
        return dynamicSpecification.toPredicate(example);
    }

    public Example generateExample(Map<String, Object> params) {
        DynamicSpecification<T> dynamicSpecification = new DynamicSpecification<T>(params);
        Example example = new Example(getEntityClass());
        return dynamicSpecification.toPredicate(example);
    }

}

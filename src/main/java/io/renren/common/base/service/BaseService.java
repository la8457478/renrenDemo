package io.renren.common.base.service;

import io.renren.common.exception.RRException;
import tk.mybatis.mapper.entity.Example;

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

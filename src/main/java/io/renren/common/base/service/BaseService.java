package io.renren.common.base.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.renren.common.example.DynamicSpecification;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Query;
import io.renren.modules.sys.entity.SysConfigEntity;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.entity.Example;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(
    rollbackFor = {RRException.class}
)
public abstract class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl implements IBaseService<T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());


    private Class<?> clazz = null;

    protected Class<?> getEntityClass() {
        if (clazz == null) {
            clazz = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clazz;
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
        Page<SysConfigEntity> page = this.sep(
            new Query<SysConfigEntity>(params).getPage(),
            new EntityWrapper<SysConfigEntity>()
                .like(StringUtils.isNotBlank(paramKey),"param_key", paramKey)
                .eq("status", 1)
        );
        DynamicSpecification<T> dynamicSpecification = new DynamicSpecification<T>(params, distinct);
        Example example = new Example(getEntityClass());
        return dynamicSpecification.toPredicate(clazz);
    }

    public Example generateExample(Map<String, Object> params) {
        DynamicSpecification<T> dynamicSpecification = new DynamicSpecification<T>(params);
        Example example = new Example(getEntityClass());
        return dynamicSpecification.toPredicate(example);
    }

}

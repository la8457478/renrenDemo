package io.renren.common.example.generator;


import java.util.Arrays;

import io.renren.common.example.param.Param;
import io.renren.common.example.param.converter.ConverterManager;
import tk.mybatis.mapper.entity.Example;

/**
 * 小于
 */
public class InPredicateGenerator extends AbstractPredicateGenerator {

    @Override
    protected Example.Criteria createCriteria(Example example, Param param) {
        Object[] datas = ConverterManager.get(param.getValue().getClass()).transform(param.getValue());
        String column = param.getPath();
        Example.Criteria criteria = example.createCriteria();
        if (datas == null || datas.length == 0) {
            criteria = getCreateMethod(criteria, column, null);
        } else {
            criteria = getCreateMethod(criteria, column, datas);
        }
        return criteria;
    }

    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andIn(column, Arrays.asList((Object[]) data));
        } else {
            criteria.orNotIn(column, Arrays.asList((Object[]) data));
        }
        return criteria;
    }
}
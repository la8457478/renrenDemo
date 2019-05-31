package io.renren.common.example.generator;


import tk.mybatis.mapper.entity.Example;

/**
 * 大于
 * Created by cwx183898 on 2017/12/17.
 */
public class GePredicateGenerator extends AbstractPredicateGenerator {
    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andGreaterThan(column, data);
        } else {
            criteria.orGreaterThan(column, data);
        }
        return criteria;
    }
}

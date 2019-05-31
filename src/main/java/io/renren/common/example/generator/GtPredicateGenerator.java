package io.renren.common.example.generator;


import tk.mybatis.mapper.entity.Example;

/**
 * 大于
 */

public class GtPredicateGenerator extends AbstractPredicateGenerator {

    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andGreaterThanOrEqualTo(column, data);
        } else {
            criteria.orGreaterThanOrEqualTo(column, data);
        }
        return criteria;
    }
}
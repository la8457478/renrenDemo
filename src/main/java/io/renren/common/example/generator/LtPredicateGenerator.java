package io.renren.common.example.generator;

import tk.mybatis.mapper.entity.Example;

/**
 * 小于
 */
public class LtPredicateGenerator extends AbstractPredicateGenerator {

    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andLessThanOrEqualTo(column, data);
        } else {
            criteria.orLessThanOrEqualTo(column, data);
        }
        return criteria;
    }

}
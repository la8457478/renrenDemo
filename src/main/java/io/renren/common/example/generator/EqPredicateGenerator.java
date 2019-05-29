package io.renren.common.example.generator;

import tk.mybatis.mapper.entity.Example;

/**
 * 等于
 * Created by cwx183898 on 2017/12/17.
 */
public class EqPredicateGenerator extends AbstractPredicateGenerator {

    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andEqualTo(column, data);
        } else {
            criteria.orEqualTo(column, data);
        }
        return criteria;
    }
}

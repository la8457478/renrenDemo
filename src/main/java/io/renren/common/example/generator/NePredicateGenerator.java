package io.renren.common.example.generator;


import tk.mybatis.mapper.entity.Example;

/**
 * 不等于
 * Created by cwx183898 on 2017/12/17.
 */
public class NePredicateGenerator extends AbstractPredicateGenerator {


    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andNotEqualTo(column, data);
        } else {
            criteria.orNotEqualTo(column, data);
        }
        return criteria;
    }
}

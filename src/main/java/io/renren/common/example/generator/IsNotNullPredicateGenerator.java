package io.renren.common.example.generator;


import tk.mybatis.mapper.entity.Example;

/**
 * 不为NULL
 * Created by cwx183898 on 2017/12/17.
 */
public class IsNotNullPredicateGenerator extends AbstractPredicateGenerator {
    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andIsNotNull(column);
        } else {
            criteria.orIsNotNull(column);
        }
        return criteria;
    }
}

package io.renren.common.example.generator;


import tk.mybatis.mapper.entity.Example;

/**
 * 不为空
 * Created by cwx183898 on 2017/12/17.
 */
public class IsNotEmptyPredicateGenerator extends AbstractPredicateGenerator {

    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andNotEqualTo(column,"");
        } else {
            criteria.orNotEqualTo(column,"");
        }
        return criteria;
    }
}

package io.renren.common.example.generator;


import tk.mybatis.mapper.entity.Example;


/**
 * Created by cwx183898 on 2017/12/17.
 */
public class NotLikePredicateGenerator extends LikePredicateGenerator {


    public NotLikePredicateGenerator(String before, String after) {
        super(before, after);
    }

    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andNotLike(column, data.toString());
        } else {
            criteria.orNotLike(column, data.toString());
        }
        return criteria;
    }
}
package io.renren.common.example.generator;


import io.renren.common.example.param.Param;
import io.renren.common.example.param.converter.ConverterManager;
import tk.mybatis.mapper.entity.Example;

/**
 * LIKE
 * Created by cwx183898 on 2017/12/17.
 */
public class LikePredicateGenerator extends AbstractPredicateGenerator {

    private String before;
    private String after;

    public LikePredicateGenerator(String before, String after) {
        this.before = before;
        this.after = after;
    }

    @Override
    protected Example.Criteria createCriteria(Example example, Param param) {
        Object[] datas = ConverterManager.get(param.getValue().getClass()).transform(param.getValue());
        String column = param.getPath();
        Example.Criteria criteria = example.createCriteria();
        if (datas == null || datas.length == 0) {
            criteria = getCreateMethod(criteria, column, null);
        } else {
            for (Object data : datas) {
                data = (before != null ? before : "") + data.toString() + (after != null ? after : "");
                criteria = getCreateMethod(criteria, column, data);
            }
        }
        return criteria;
    }

    @Override
    protected Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data) {
        if (criteria.getAllCriteria().isEmpty()) {
            criteria.andLike(column, data.toString());
        } else {
            criteria.orLike(column, data.toString());
        }
        return criteria;
    }

}
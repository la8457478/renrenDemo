package io.renren.common.example;

import org.springframework.data.domain.Pageable;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Set;

import io.renren.common.example.param.Param;
import tk.mybatis.mapper.entity.Example;


/**
 * Created by cwx183898 on 2017/8/18.
 */
public class DynamicSpecification<T> {
    private Map<String, Object> params;
    private boolean distinct = false;
    private Class<?> clazz = null;
    public DynamicSpecification(Map<String, Object> params) {
        this.params = params;
    }

    public DynamicSpecification(Map<String, Object> params, boolean distinct) {
        this.params = params;
        this.distinct = distinct;
    }

    public Example toPredicate(Example example) {
        example.setDistinct(distinct);
        if (params != null) {
            Set<Map.Entry<String, Object>> entries = params.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                example = createPredicate( example, entry);
            }
        }
        return example;
    }

    private Example createPredicate(  Example example, Map.Entry<String, Object> entry) {
        Param param = new Param(entry);
        Example.Criteria newCriteria = PredicateGeneratorFactory.getGenerator(param.getOper()).toPredicate(example,param);
        if (example != null) {
            if (param.getJoin().equals("or")) {
                example.or(newCriteria);
            } else {
                example.and(newCriteria);
            }
        } else {
            example.and(newCriteria);
        }
        return example;
    }

}
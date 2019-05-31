package io.renren.common.example.generator;


import io.renren.common.example.param.Param;
import io.renren.common.example.param.converter.ConverterManager;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by cwx183898 on 2017/12/17.
 */
public abstract class AbstractPredicateGenerator {
    private static final String[] DATE_FORMATERS = new String[] {
        "yyyy-MM", "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss",
        "yyyy-MM-ddTHH:mm", "yyyy-MM-ddTHH:mm:ss",
        "yyyy/MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss",
        "yyyy/MM/ddTHH:mm", "yyyy/MM/ddTHH:mm:ss"};

    public Example.Criteria toPredicate(Example example, Param param) {
        //        Class paramType = path.getJavaType();//取得参数类型（对应实体的字段类型）
        Example.Criteria criteria = createCriteria(example, param);
        return criteria;
    }


    protected Example.Criteria createCriteria(Example example, Param param) {
        Object[] datas = ConverterManager.get(param.getValue().getClass()).transform(param.getValue());
        String column = param.getPath();
        Example.Criteria criteria = example.createCriteria();
        if (datas == null || datas.length == 0) {
            criteria = getCreateMethod(criteria, column, null);
        } else {
            for (Object data : datas) {
                criteria = getCreateMethod(criteria, column, data);
            }
        }
        return criteria;
    }

    protected abstract Example.Criteria getCreateMethod(Example.Criteria criteria, String column, Object data);
}
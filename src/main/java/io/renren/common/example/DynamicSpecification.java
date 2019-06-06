//package io.renren.common.example;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//
//import org.apache.commons.lang.StringUtils;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Map;
//import java.util.Set;
//
//import io.renren.common.example.param.Param;
//import io.renren.common.utils.Query;
//import io.renren.modules.sys.entity.SysConfigEntity;
//import tk.mybatis.mapper.entity.Example;
//
//
///**
// * Created by cwx183898 on 2017/8/18.
// */
//public class DynamicSpecification<T> {
//    private Map<String, Object> params;
//    private boolean distinct = false;
//    private Class<?> clazz = null;
//
//    public DynamicSpecification(Map<String, Object> params) {
//        this.params = params;
//    }
//
//    public DynamicSpecification(Map<String, Object> params, boolean distinct) {
//        this.params = params;
//        this.distinct = distinct;
//    }
//
//    public Predicate toPredicate(CriteriaBuilder builder, Path path, Param param) {
//        Class paramType = path.getJavaType();//取得参数类型（对应实体的字段类型）
//        Object[] values = ConverterManager.get(paramType).transform(param.getValue());
//        Predicate predicate = createPredicate(builder, paramType, path, values);
//        return predicate;
//    }
//
//
//    protected Predicate createPredicate(CriteriaBuilder builder, Class clazz, Path path, Object[] datas) {
//        Method method = getCreateMethod(builder);
//        if (method == null) {
//            return null;
//        }
//        Predicate predicate = null;
//        if (datas == null || datas.length == 0) {
//            predicate = invokeCreate(builder, method, path, null);
//        } else {
//            for (Object data : datas) {
//                if (predicate == null) {
//                    predicate = invokeCreate(builder, method, path, data);
//                } else {
//                    Predicate newPredicate = invokeCreate(builder, method, path, data);
//                    predicate = builder.or(predicate, invokeCreate(builder, method, path, data));
//                }
//            }
//        }
//        return predicate;
//    }
//
//    protected Predicate invokeCreate(CriteriaBuilder builder, Method method, Path path, Object data) {
//        Predicate predicate = null;
//        try {
//            predicate = (Predicate) method.invoke(builder, path, data);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return predicate;
//    }
//
//    public Wrapper<T> toPredicate(Class<?> clazz) {
////        Page<SysConfigEntity> page = this.selectPage(
////            new Query<SysConfigEntity>(params).getPage(),
////            new EntityWrapper<SysConfigEntity>()
////                .like(StringUtils.isNotBlank(paramKey), "param_key", paramKey)
////                .eq("status", 1)
////        );
//        Wrapper<T> wrapper = new EntityWrapper<T>();
//        //        example.setDistinct(distinct);
//        if (params != null) {
//            Set<Map.Entry<String, Object>> entries = params.entrySet();
//            for (Map.Entry<String, Object> entry : entries) {
//                wrapper = createPredicate(wrapper, entry);
//            }
//        }
//        return wrapper;
//    }
//
//    private Wrapper<T> createPredicate(Wrapper<T> wrapper, Map.Entry<String, Object> entry) {
//        Param param = new Param(entry);
//        Method method = getCreateMethod(new EntityWrapper<>()Wrapper<T>());
//        Example.Criteria newCriteria = PredicateGeneratorFactory.getGenerator(param.getOper()).toPredicate(wrapper,
//            param);
//        if (wrapper != null) {
//            if (param.getJoin().equals("or")) {
//                wrapper = wrapper.or().;
//            } else {
//                wrapper.and();
//            }
//        } else {
//            wrapper.and();
//        }
//        return wrapper;
//        if (method == null) {
//            return null;
//        }
//        Predicate predicate = null;
//        if (datas == null || datas.length == 0) {
//            predicate = invokeCreate(builder, method, path, null);
//        } else {
//            for (Object data : datas) {
//                if (predicate == null) {
//                    predicate = invokeCreate(builder, method, path, data);
//                } else {
//                    Predicate newPredicate = invokeCreate(builder, method, path, data);
//                    predicate = builder.or(predicate, invokeCreate(builder, method, path, data));
//                }
//            }
//        }
//        return predicate;
//    }
//    protected abstract Method getCreateMethod(Wrapper<T> builder);
//
//}
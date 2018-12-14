package io.renren.common.base.mapper;

import tk.mybatis.mapper.common.*;

/**
 * 通用mapper
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface CommonMapper<T>  extends IdsMapper<T>,ConditionMapper<T>, MySqlMapper<T>, BaseMapper<T>,
        ExampleMapper<T>,
        RowBoundsMapper<T>,
        Marker {
}

package com.zqs.scg.manager.mapper.read;

import com.zqs.scg.common.paging.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Description: 数据读取交互层基类
 * Created by Wesley
 * on 17:34 17/1/23
 */
public interface IBaseReadDao<T> {

    /**
     * 根据ID查询实体
     * @param id 主键
     * @return 实体信息
     */
    T get(Integer id);

    /**
     * 查询实体列表
     * @param t 实体信息
     * @param page 分页信息
     * @return 实体列表
     */
    List<T> listPage(T t, Page page);


    /**
     * 根据主键集合批量查询列表
     * @param ids 主键集合
     * @return 实体列表
     */
    List<T> batchList(@Param("ids") Set<Integer> ids);


}

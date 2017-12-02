package com.zqs.scg.manager.service;



import com.sun.istack.NotNull;
import com.zqs.scg.common.paging.Page;

import java.util.List;
import java.util.Set;

/**
 * Description: 服务基类
 * Created by Wesley
 * on 18:01 17/1/23
 */
public interface IBaseService<T> {

    /**
     * 新增实体
     * @param t 实体信息
     * @return 新增结果（true/false）
     */
    Integer insert(T t);


    /**
     * 更新实体
     * @param t 实体信息
     * @return 更新结果（true/false）
     */
    boolean update(T t);


    /**
     * 物理删除
     * @param id 实体主键
     * @return 删除结果（true/false）
     */
    boolean delete(@NotNull Integer id);


    /**
     * 批量物理删除
     * @param ids 主键集合
     * @return 删除结果（true/false）
     */
    boolean batchDelete(@NotNull Set<Integer> ids);

    /**
     * 根据ID查询实体
     * @param id 主键
     * @return 实体信息
     */
    T get(Integer id);

    /**
     * 分页查询实体列表
     * @param t 实体信息
     * @param page 分页信息
     * @return 实体列表
     */
    List<T> listPage(T t, Page page);

    /**
     * 查询所以实体列表
     * @param t 实体信息
     * @return 实体列表
     */
    List<T> list(T t);
    

    /**
     * 根据主键集合批量查询列表
     * @param ids 主键集合
     * @return 实体列表
     */
    List<T> batchList(@NotNull Set<Integer> ids);
}

package com.zqs.scg.manager.mapper.write;
import com.sun.istack.NotNull;
import java.util.Set;

/**
 * Description: 数据写入交互基类
 * Created by Wesley
 * on 17:34 17/1/23
 */
public interface IBaseWriteDao<T> {

    /**
     * 新增实体
     * @param t 实体信息
     * @return 新增结果（true/false）
     */
    boolean insert(T t);


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
}

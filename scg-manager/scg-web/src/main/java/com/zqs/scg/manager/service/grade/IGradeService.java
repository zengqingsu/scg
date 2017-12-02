/**
 * 
 */
package com.zqs.scg.manager.service.grade;

import com.zqs.scg.manager.pojo.grade.Grade;
import com.zqs.scg.manager.service.IBaseService;

import java.util.List;
import java.util.Map;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日下午3:32:58
 */
public interface IGradeService extends IBaseService<Grade> {
	/**
	 * 获取所有学生的各科分数数据
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getGradeReport();
}

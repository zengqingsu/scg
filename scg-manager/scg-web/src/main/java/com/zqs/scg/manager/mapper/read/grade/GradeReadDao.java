package com.zqs.scg.manager.mapper.read.grade;

import com.zqs.scg.manager.mapper.read.IBaseReadDao;
import com.zqs.scg.manager.pojo.grade.Grade;

import java.util.List;
import java.util.Map;

/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月25日下午6:12:43
 */
public interface GradeReadDao extends IBaseReadDao<Grade> {
	public  List< Map<String, Object>> getGradeReport();
}

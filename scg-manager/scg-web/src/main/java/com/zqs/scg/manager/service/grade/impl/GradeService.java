/**
 * 
 */
package com.zqs.scg.manager.service.grade.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zqs.scg.common.paging.Page;
import com.zqs.scg.manager.mapper.read.grade.GradeReadDao;
import com.zqs.scg.manager.pojo.grade.Grade;
import com.zqs.scg.manager.service.grade.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日下午3:34:10
 */
@Service
public class GradeService implements IGradeService {
	@Autowired
	private GradeReadDao readDao;

	public Integer insert(Grade t) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean update(Grade t) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean batchDelete(Set<Integer> ids) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 根据id获取分数表数据
	 * @param id
	 * @return
	 */

	public Grade get(Integer id) {
		return readDao.get(id);
	}


	public List<Grade> listPage(Grade t, Page page) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Grade> list(Grade t) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Grade> batchList(Set<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public List< Map<String, Object>> getGradeReport() {
		return readDao.getGradeReport();
	}

}

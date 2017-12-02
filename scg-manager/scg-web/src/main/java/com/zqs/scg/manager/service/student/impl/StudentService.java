/**
 * 
 */
package com.zqs.scg.manager.service.student.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.zqs.scg.common.paging.Page;
import com.zqs.scg.manager.mapper.read.student.StudentReadDao;
import com.zqs.scg.manager.mapper.write.student.StudentWriteDao;
import com.zqs.scg.manager.pojo.student.Student;
import com.zqs.scg.manager.service.student.IStudentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sun.istack.NotNull;

/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日上午11:52:39
 */
@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentReadDao readDao;
	
	@Autowired
	private StudentWriteDao writeDao;
	/**
	 * 插入学生数据
	 * @param student
	 * @return
	 */

	public Integer insert(Student student) {
		boolean result = writeDao.insert(student);
		if (result) {
			student.getId();
		}
		return null;
	}
	/**
	 * 更新学生数据
	 * @param student
	 * @return
	 */

	public boolean update(Student student) {
		return writeDao.update(student);
	}
	/**
	 * 删除学生数据
	 * @param id
	 * @return
	 */

	public boolean delete(@NotNull Integer id) {
		return writeDao.delete(id);
	}

	/**
	 * 批量删除学生数据
	 * @param ids 主键集合
	 * @return
	 */

	public boolean batchDelete(@NotNull Set<Integer> ids) {
		return writeDao.batchDelete(ids);
	}
	/**
	 * 根据id获取学生数据
	 * @param id
	 * @return
	 */

	public Student get(Integer id) {
		return readDao.get(id);
	}

	/**
	 * 分页查询学生数据
	 * @param student
	 * @param page
	 * @return
	 */

	public List<Student> listPage(Student student, Page page) {
		return readDao.listPage(student, page);
	}
	/**
	 * 查询所有学生数据
	 * @param student
	 * @return
	 */

	public List<Student> list(Student student) {
		return readDao.listPage(student, null);
	}
	/**
	 * 批量查询课程数据
	 * @param ids
	 * @return
	 */

	public List<Student> batchList(Set<Integer> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return Collections.EMPTY_LIST;
		}
		return readDao.batchList(ids);
	}

}

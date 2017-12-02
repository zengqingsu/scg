/**
 * 
 */
package com.zqs.scg.manager.service.course.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.sun.istack.NotNull;
import com.zqs.scg.common.paging.Page;
import com.zqs.scg.manager.mapper.read.course.CourseReadDao;
import com.zqs.scg.manager.mapper.write.course.CourseWriteDao;
import com.zqs.scg.manager.pojo.course.Course;
import com.zqs.scg.manager.service.course.ICourseService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日上午9:21:44
 */
@Service
public class CourseService implements ICourseService {
	@Autowired
	private CourseWriteDao writeDao;
	@Autowired
	private CourseReadDao readDao;

	/**
	 * 插入课程数据
	 * @param course
	 * @return
	 */

	public Integer insert(Course course) {
		boolean result = writeDao.insert(course);
		if (result) {
			course.getId();
		}
		return null;
	}

	/**
	 * 更新课程数据
	 * @param course
	 * @return
	 */

	public boolean update(Course course) {
		return writeDao.update(course);
	}
	/**
	 * 删除课程数据
	 * @param id
	 * @return
	 */

	public boolean delete(@NotNull Integer id) {
		return writeDao.delete(id);
	}

	/**
	 * 批量删除课程数据
	 * @param ids 主键集合
	 * @return
	 */

	public boolean batchDelete(@NotNull Set<Integer> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return false;
		}
		return writeDao.batchDelete(ids);
	}

	/**
	 * 根据id获取课程数据
	 * @param id
	 * @return
	 */

	public Course get(Integer id) {
		return readDao.get(id);
	}

	/**
	 * 分页查询课程数据
	 * @param course
	 * @param page
	 * @return
	 */

	public List<Course> listPage(Course course, Page page) {
		return readDao.listPage(course, page);
	}

	/**
	 * 查询所有课程数据
	 * @param course
	 * @return
	 */

	public List<Course> list(Course course) {
		return readDao.listPage(course, null);
	}

	/**
	 * 批量查询课程数据
	 * @param ids
	 * @return
	 */

	public List<Course> batchList(Set<Integer> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return Collections.EMPTY_LIST;
		}
		return readDao.batchList(ids);
	}

}

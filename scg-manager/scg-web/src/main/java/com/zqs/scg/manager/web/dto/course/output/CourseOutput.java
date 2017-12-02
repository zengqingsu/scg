/**
 * 
 */
package com.zqs.scg.manager.web.dto.course.output;

import com.zqs.scg.manager.pojo.course.Course;
import org.springframework.beans.BeanUtils;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日上午10:38:28
 */
public class CourseOutput {
	 //主键
    private int id;

    //姓名
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 课程转输出视图
     * @param course 课程实体
     * @return 课程输出视图
     */
    public static CourseOutput transform(Course course){
      CourseOutput courseOutput =new CourseOutput();
        BeanUtils.copyProperties(course, courseOutput);
        return courseOutput;
    }
}

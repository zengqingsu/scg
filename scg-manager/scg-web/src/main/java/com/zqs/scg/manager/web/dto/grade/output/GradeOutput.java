/**
 * 
 */
package com.zqs.scg.manager.web.dto.grade.output;

import com.zqs.scg.manager.pojo.course.Course;
import com.zqs.scg.manager.pojo.grade.Grade;
import org.springframework.beans.BeanUtils;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日下午3:43:10
 */
public class GradeOutput {
	 //主键
    private int id;

    private Student student;
    private Course course;
    //private Integer sid;
    //private Integer cid;
    private Integer score;
    
    
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


/*	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}*/

	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	/**
     * 分数表转输出视图
     * @param grade 分数实体
     * @return 分数表输出视图
     */
    public static GradeOutput transform(Grade grade){
    	GradeOutput gradeOutput =new GradeOutput();
        BeanUtils.copyProperties(grade, gradeOutput);
        return gradeOutput;
    }

	private class Student {
	}
}

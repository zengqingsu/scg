package com.zqs.scg.manager.pojo.grade;

import com.zqs.scg.manager.pojo.BaseEntity;
import com.zqs.scg.manager.pojo.course.Course;
import com.zqs.scg.manager.pojo.student.Student;

import java.io.Serializable;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月25日下午5:34:23
 */
public class Grade extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	//private Integer sid;//学生id
	//private Integer cid;//课程id
	private Student student;
	private Course course;
	private Integer score;//分数
	
	public Grade() {
	}
	/*
	public Grade(Integer sid, Integer cid, Integer score) {
		super();
		this.sid = sid;
		this.cid = cid;
		this.score = score;
	}*/
	public Grade(Student student,Course course, Integer score) {
		super();
		this.student = student;
		this.course = course;
		this.score = score;
	}
	/*public Integer getSid() {
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

}

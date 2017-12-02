package com.zqs.scg.manager.pojo.course;

import com.zqs.scg.manager.pojo.BaseEntity;

import java.io.Serializable;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月25日下午5:32:10
 */
public class Course extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;//课程名
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

package com.zqs.scg.manager.pojo.student;

import com.zqs.scg.manager.pojo.BaseEntity;

import java.io.Serializable;
;
/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月25日下午5:30:21
 */
public class Student extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;//学生姓名
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
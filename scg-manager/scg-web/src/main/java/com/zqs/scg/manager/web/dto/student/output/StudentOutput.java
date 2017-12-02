/**
 * 
 */
package com.zqs.scg.manager.web.dto.student.output;

import com.zqs.scg.manager.pojo.student.Student;
import org.springframework.beans.BeanUtils;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日下午2:40:57
 */
public class StudentOutput {
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
     * 学生转输出视图
     * @param student 学生实体
     * @return 学生输出视图
     */
    public static StudentOutput transform(Student student){
    	StudentOutput studentOutput =new StudentOutput();
        BeanUtils.copyProperties(student, studentOutput);
        return studentOutput;
    }
}

/**
 * 
 */
package com.zqs.scg.manager.web.controller.student;

import com.zqs.scg.common.errorcode.ErrorCode;
import com.zqs.scg.manager.pojo.student.Student;
import com.zqs.scg.manager.service.student.impl.StudentService;
import com.zqs.scg.manager.web.dto.response.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:学生控制层
 * @author zengqingsu
 * @date 2017年10月26日下午2:43:52
 */
@RestController
@RequestMapping(value="/plat/student")
public class StudentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired(required = false)
	private StudentService studentService;
	
	@ResponseBody
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public AjaxResult getStudent(@PathVariable("id") Integer id) {

        //参数验证
        if (null == id || id < 0){
            return AjaxResult.error(ErrorCode.ERROR_INVALID_PARAMS.getCode(), ErrorCode.ERROR_INVALID_PARAMS.getMsg());
        }
		Student student = studentService.get(id);
		return AjaxResult.success(student);
	}
}

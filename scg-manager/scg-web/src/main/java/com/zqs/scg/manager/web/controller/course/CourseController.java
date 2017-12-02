/**
 * 
 */
package com.zqs.scg.manager.web.controller.course;

import com.zqs.scg.common.errorcode.ErrorCode;
import com.zqs.scg.manager.pojo.course.Course;
import com.zqs.scg.manager.service.course.impl.CourseService;
import com.zqs.scg.manager.web.dto.course.output.CourseOutput;
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
 * @Description:课程控制层
 * @author zengqingsu
 * @date 2017年10月26日上午10:50:47
 */
@RestController
@RequestMapping(value="/plat/course")
public class CourseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired(required = false)
	private CourseService courseService;
	
	@ResponseBody
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public AjaxResult getCourse(@PathVariable("id") Integer id) {

        //参数验证
        if (null == id || id < 0){
            return AjaxResult.error(ErrorCode.ERROR_INVALID_PARAMS.getCode(), ErrorCode.ERROR_INVALID_PARAMS.getMsg());
        }

		Course course = courseService.get(id);
		return AjaxResult.success(course);
	}
}

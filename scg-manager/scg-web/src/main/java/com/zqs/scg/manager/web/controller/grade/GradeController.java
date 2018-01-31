package com.zqs.scg.manager.web.controller.grade;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.zqs.scg.common.errorcode.ErrorCode;
import com.zqs.scg.manager.pojo.grade.Grade;
import com.zqs.scg.manager.service.grade.impl.GradeService;
import com.zqs.scg.manager.web.dto.response.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description:TODO
 * @author zengqingsu
 * @date 2017年10月26日下午3:48:53
 */
@Controller
@RequestMapping(value="/plat/grade")
public class GradeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GradeService gradeService;
	/**
	 * 根据分数表id查分数记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/{id}",method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public AjaxResult getGrade(@PathVariable("id") Integer id) {
		if (id==0||id<0) {
			return AjaxResult.error(ErrorCode.ERROR_EXCEPTION_DB_DML.getCode(),ErrorCode.ERROR_EXCEPTION_DB_DML.getMsg());
		}
		Grade grade = gradeService.get(id);
		String jsonString = JSONObject.toJSONString(grade);
		return AjaxResult.success(jsonString);
	}
	/**
	 * 查询所有学生各科分数记录
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all",method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public String  getGradeReport() {
		List< Map<String, Object>> gradeReport = gradeService.getGradeReport();
		String s = JSONObject.toJSONString(gradeReport);
		return s;
	}
}

package com.zqs.scg.manager.web;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 平台登录控制层
 * @author xiao
 *
 */
@RestController
public class LoginController {
    
    /**
     * 单点登录，跳转到前端首页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toIndex",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public RedirectView platLogin(HttpServletRequest request){
    	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();  
        ServletContext servletContext = webApplicationContext.getServletContext();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
		RedirectView service=(RedirectView)ac.getBean("toPortalPage");
    	return service;
    }
    @ResponseBody
    @RequestMapping(value = "/test",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public String  test(){
        String test="asda";
        return  test;
    }
}

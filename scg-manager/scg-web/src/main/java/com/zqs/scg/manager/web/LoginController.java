package com.zqs.scg.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 平台登录控制层
 * @author xiao
 *
 */
@Controller
public class LoginController {
    
    /**
     * 单点登录，跳转到前端首页
     * @return
     */
    @RequestMapping(value = "/toIndex")
    public ModelAndView  platLogin(){
    	return new ModelAndView("index");
    }

/*    @ResponseBody
    @RequestMapping(value = "/toIndex",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public RedirectView platLogin(HttpServletRequest request){
    	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		RedirectView service=(RedirectView)ac.getBean("toPortalPage");
    	return service;
    }*/
}

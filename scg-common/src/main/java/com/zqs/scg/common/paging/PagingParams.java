package com.zqs.scg.common.paging;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/** Spring MVC 分页处理
 * @author wei.li
 * @version 2016/8/1
 */
@ControllerAdvice
public class PagingParams extends HandlerInterceptorAdapter implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return Page.class.isAssignableFrom(parameter.getParameterType());
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        int pageNo = Page.DEFAULT_PAGE_NO;
        int pageSize = Page.DEFAULT_PAGE_SIZE;

        String no = webRequest.getParameter("pageNo");
        if (StringUtils.isNumeric(no)) {
            pageNo = Integer.parseInt(no);
        }
        String size = webRequest.getParameter("pageSize");
        if (StringUtils.isNumeric(size)) {
            pageSize = Integer.parseInt(size);
        }
//        String jsonStr = null;
//        try {
//            CHttpServletRequestWrapper myWrapper = new CHttpServletRequestWrapper((HttpServletRequest) webRequest.getNativeRequest());
//            jsonStr = GetRequestJsonUtils.getRequestJsonString(myWrapper);
//        } catch (Exception e){
//            System.out.print("读取分页数据异常!!!");
//        }
//
//        if (!Strings.isNullOrEmpty(jsonStr)) {
//            JSONObject jsonObject = null;
//            try {
//                jsonObject = JSONObject.parseObject(jsonStr);
//            } catch (Exception e){
//                System.out.print("解析json数据获取分页信息异常!!!");
//            }
//
//            if (null != jsonObject) {
//                String no = jsonObject.getString("pageNo");//webRequest.getParameter("pageNo");
//                if (StringUtils.isNumeric(no)) {
//                    pageNo = Integer.parseInt(no);
//                }
//                String size = jsonObject.getString("pageSize");//webRequest.getParameter("pageSize");
//                if (StringUtils.isNumeric(size)) {
//                    pageSize = Integer.parseInt(size);
//                }
//            }
//        }
        return new Page(pageNo, pageSize);
    }

}

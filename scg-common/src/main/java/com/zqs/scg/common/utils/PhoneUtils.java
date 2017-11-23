package com.zqs.scg.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * 手机号验证
 * @author xiao
 *
 */
public class PhoneUtils {
	/** 
     * 大陆号码或香港号码均可 
     */  
    public static boolean phoneCheck(String phone)throws PatternSyntaxException {
    	if(phone!=null && phone.length()>0){
    		return phoneChina(phone) || phoneHk(phone);  
    	}else{
    		return false;
    	}
    }  
  
    /** 
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
    public static boolean phoneChina(String str) throws PatternSyntaxException {  
        //String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
    	String regExp = "^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$";
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
  
    /** 
     * 香港手机号码8位数，5|6|8|9开头+7位任意数 
     */  
    public static boolean phoneHk(String str)throws PatternSyntaxException {  
        String regExp = "^(5|6|8|9)\\d{7}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
        
    public static void main(String[] args)throws Exception
    {
    	/*StringBuilder dataCodeStr = new StringBuilder("SJZD00999");
    	
		Integer dataCodeInt = Integer.parseInt(dataCodeStr.substring(4)) + 1;
		dataCodeStr = new StringBuilder(dataCodeInt.toString());
		System.out.println(dataCodeStr);
		dataCodeStr.insert(0, "00000", 0, 5 - dataCodeInt.toString().length());
		System.out.println(DateUtils.formatDate(new Date(),"yyyyMMdd")+dataCodeStr);*/
    }
}

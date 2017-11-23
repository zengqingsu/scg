package com.zqs.scg.common.utils;

/**
 * 编号生成
 * @author xiao
 *
 */
public class CodeUtils {
	/**
	 * 编号生成
	 * @param head 编号开头
	 * @param end 编号结尾
	 * @param maxLength 编号总长度
	 * @return
	 */
    public static String codeGenerate(String head,String end,int maxLength){
    	if(head==null){
    		head="";
    	}
    	if(end==null){
    		end="";
    	}
    	int headLength=head.length();
    	int endLength=end.length();
    	if((headLength+endLength)>=maxLength){
    		return head+end;
    	}else{
    		StringBuffer code=new StringBuffer(head);
    		//中间追加0
    		for(int i=0;i<maxLength-headLength-endLength;i++){
    			code.append("0");
    		}
    		return code.append(end).toString();
    	}
    }   
        
}

package com.zqs.scg.common;

import com.zqs.scg.common.http.Encoding;
import com.zqs.scg.common.utils.properties.Prop;
import com.zqs.scg.common.utils.properties.Proper;

/**
 * Created by ice on 14-12-29.
 */
public final class Constant {

	//工具类配置
	public final static String encoding;//编码1
	public final static String fileRenamer;// 文件上传重命名类
	public static final String[] xForwardedSupports;
	
	// 短信发送地址配置（默认值为测试地址）
	public final static String smsUrl;//短信地址
	// 一体化会员登录地址
    public final static String memberLogin;
    // 优惠券推送地址配置
    public final static String couponUrl;
    // 短信回调地址
	public final static String smsCallback;
	// 优惠券回调地址
	public final static String couponCallback;
	// 短信authToken
	public final static String authToken_kyt; // 快易通
	public final static String authToken_ryt; // 如意通
	public final static String authToken_mw; // 梦网
	//微信消息
	public final static String wxFirst;//微信抬头
	public final static String wxRemark;//备注
	public final static String wxTemplateId;//模板
	//OA平台开关
	public final static String oaPlatSwitch;//OA平台开关
	public final static String oaIdSetDefault;//OA平台 审批人默认配置(不使用默认，则不填)

  	static {

  		Prop constants = null;
  		try {
  			constants = Proper.use("web-api.properties");
  		} catch (Exception e) {
  			System.out.println("读取配置文件错误" + e.toString());
  		}
  		if (constants == null) {
  			encoding = Encoding.UTF_8.toString();
  			fileRenamer = null;
  			xForwardedSupports = new String[]{"127.0.0.1"};
  	      
  			smsUrl="http://b2b2c.sms:10008/jsse";//短信地址
  			memberLogin="";
            couponUrl = "";
            smsCallback = "";
            couponCallback = "";
            authToken_kyt = "";
            authToken_ryt = "";
            authToken_mw = "";
			wxFirst = "";
			wxRemark = "";
			wxTemplateId = "";
			oaPlatSwitch = "";
			oaIdSetDefault = "";
  		} else {
  			encoding = constants.get("app.encoding", Encoding.UTF_8.name());
  			fileRenamer = constants.get("app.fileRenamer");
  			String xForwardedSupportsStr = constants.get("app.xForwardedSupports");
  			if (xForwardedSupportsStr == null) {
  				xForwardedSupports = new String[]{};
  			} else {
  				xForwardedSupports = xForwardedSupportsStr.split(",");
  			}
  			
  			smsUrl=constants.get("sms.url","http://b2b2c.sms:10008/jsse");//短信地址
  			memberLogin = constants.get("membuer.login", "");
            couponUrl = constants.get("coupon.url", "");
  			smsCallback = constants.get("sms.callback", "");
  			couponCallback = constants.get("coupon.callback", "");
            authToken_kyt = constants.get("sms.authToken_kyt", "");
            authToken_ryt = constants.get("sms.authToken_ryt", "");
            authToken_mw = constants.get("sms.authToken_mw", "");
			wxFirst = constants.get("wx.first","");
			wxRemark = constants.get("wx.remark","");
			wxTemplateId = constants.get("wx.templateID","");
			oaPlatSwitch = constants.get("oa.oaPlatSwitch","");
			oaIdSetDefault = constants.get("oa.default.oaId","");
  		}
  	}
}

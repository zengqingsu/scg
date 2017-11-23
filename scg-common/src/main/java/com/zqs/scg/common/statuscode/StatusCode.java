package com.zqs.scg.common.statuscode;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态变量存储
 *
 * @author xiao
 */
public class StatusCode {

    private static Map<Integer, String> statusMap = null;// 状态Map
    private static Map<String, Object> stringMap = null;// 字符串Map
    /*************************系统公共状态**************************/
    //启用、禁用
    public static final int PUBLIC_ENABLE = 10;//启用
    public static final int PUBLIC_DISABLE = 20;//禁用

    public static String getAble(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(PUBLIC_ENABLE, "启用");
        statusMap.put(PUBLIC_DISABLE, "禁用");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    //未删除、已删除
    public static final int PUBLIC_DELETE_FALSE = 0;//未删除
    public static final int PUBLIC_DELETE_TRUE = 1;//已删除

    public static String getDelete(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(PUBLIC_DELETE_FALSE, "未删除");
        statusMap.put(PUBLIC_DELETE_TRUE, "已删除");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    //女、男、未知
    public static final int PUBLIC_FEMAL = 1;//女
    public static final int PUBLIC_MALE = 2;//男
    public static final int PUBLIC_UNKNOW = 3;//未知

    public static String getGender(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(PUBLIC_FEMAL, "女");
        statusMap.put(PUBLIC_MALE, "男");
        statusMap.put(PUBLIC_UNKNOW, "未知");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }
    
    //逻辑符号(10并且/20或者)
    public static final int PUBLIC_AND = 10;//并且
    public static final int PUBLIC_OR = 20;//或者

    public static String getLogicSymbol(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(PUBLIC_AND, "并且");
        statusMap.put(PUBLIC_OR, "或者");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /*************************条件实体**************************/
    //条件类型(10会员/20门店/30商品)
    public static final int CONDITIONS_TYPES_MEMBER = 10;//会员
    public static final int CONDITIONS_TYPES_STORE = 20;//门店
    public static final int CONDITIONS_TYPES_FRUIT = 30;//商品

    public static String getConditionsTypes(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(CONDITIONS_TYPES_MEMBER, "会员");
        statusMap.put(CONDITIONS_TYPES_STORE, "门店");
        statusMap.put(CONDITIONS_TYPES_FRUIT, "商品");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /*************************模板**************************/
    // 模板标签
    public static final int TEMPLATE_SMS = 10; // 短信模板
    public static final int TEMPLATE_WECHAT = 20; // 微信模板

    public static String getTemplateTags(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(TEMPLATE_SMS, "短信模板");
        statusMap.put(TEMPLATE_WECHAT, "微信模板");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /********************http请求失败*************************/
    public static final int REQUEST_FAIL = 0; // 请求失败
    public static String getRequestStatus(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(REQUEST_FAIL, "请求失败");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /********************短信发送状态*************************/
    public static final int SMS_SEND_PROCESS = 10; // 执行中
    public static final int SMS_SEND_SUCCESS = 20; // 发送成功
    public static final int SMS_SEND_FAIL = 30; // 发送失败
    public static final int NO_SMS_SEND_REQUEST = 40; // 没有短信发送请求发出

    public static String getSmsSendStatus(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(SMS_SEND_PROCESS, "执行中");
        statusMap.put(SMS_SEND_SUCCESS, "发送成功");
        statusMap.put(SMS_SEND_FAIL, "发送失败");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /********************优惠券推送状态*************************/
    public static final int COUPON_PUSH_PROCESS = 10; // 执行中
    public static final int COUPON_PUSH_SUCCESS = 20; // 推送成功
    public static final int COUPON_PUSH_FAIL = 30; // 推送失败
    public static final int NO_COUPON_PUSH_REQUEST = 40; // 没有推送请求发出

    public static String getCouponPushStatus(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(COUPON_PUSH_PROCESS, "执行中");
        statusMap.put(COUPON_PUSH_SUCCESS, "推送成功");
        statusMap.put(COUPON_PUSH_FAIL, "推送失败");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /*********************短信发送渠道**************************/
    public static final int SMS_SEND_CHANNEL_RYT = 1; // 如意通
    public static final int SMS_SEND_CHANNEL_MW = 2; // 梦网
    public static final int SMS_SEND_CHANNEL_KYT = 3; // 快易通

    public static String getSmsSendChannel(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(SMS_SEND_CHANNEL_RYT, "如意通");
        statusMap.put(SMS_SEND_CHANNEL_MW, "梦网");
        statusMap.put(SMS_SEND_CHANNEL_KYT, "快易通");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /*********************微信模板是否链接***********************/
    public static final int WX_TEMPLATE_IS_NOT_LINK = 0; // 是
    public static final int WX_TEMPLATE_IS_LINK = 1; // 否

    /***********************条件类型**************************/
    public static final int CONDITION_TYPE_NUMERIC = 10; // 数值类型
    public static final int CONDITION_TYPE_MEMBERATTR = 20; // 会员属性
    public static final int CONDITION_TYPE_DATE = 30; // 时间类型
    public static final int CONDITION_TYPE_STORECITY = 40; // 门店城市相关属性

    public static String getConditionType(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(CONDITION_TYPE_NUMERIC, "数值类型");
        statusMap.put(CONDITION_TYPE_MEMBERATTR, "会员属性");
        statusMap.put(CONDITION_TYPE_DATE, "时间类型");
        statusMap.put(CONDITION_TYPE_STORECITY, "门店城市相关属性");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /********************条件类型 (前台传入类型获取对应条件)*********************/

    public static final int CONDITION_MEMBER_TYPE = 1; // 会员类型
    public static final int CONDITION_CONDITIONLIST  = 2; // 条件列表
    public static final int CONDITION_CHANNEL = 3; // 渠道
    public static final int CONDITION_MEMBER_LEVEL = 4; // 会员等级
    public static final int CONDITION_WXBINDINGSTATUS = 5; // 微信绑定状态

    public static String getCdtionType(int type) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(CONDITION_MEMBER_TYPE, "会员类型");
        statusMap.put(CONDITION_CONDITIONLIST, "条件列表");
        statusMap.put(CONDITION_CHANNEL, "渠道");
        statusMap.put(CONDITION_MEMBER_LEVEL, "会员等级");
        statusMap.put(CONDITION_WXBINDINGSTATUS, "微信绑定状态");
        return statusMap.get(type) == null ? "未知" : statusMap.get(type);
    }

    /********************条件类型 (前端需要，前端根据这个类型生成相应的条件展示形式，类型数量由前端决定) ************************/
    public static final int CONDITION_DISPLAY_TYPE_NUMERIC = 1; // 数值类型
    public static final int CONDITION_DISPLAY_TYPE_WECHAT = 2; // 微信绑定状态
    public static final int CONDITION_DISPLAY_TYPE_CHANNEL = 3; // 渠道
    public static final int CONDITION_DISPLAY_TYPE_MEMTYPE = 4; // 会员类型
    public static final int CONDITION_DISPLAY_TYPE_MEMLEVEL = 5; // 会员等级
    public static final int CONDITION_DISPLAY_TYPE_DATE = 6; // 日期
    public static final int CONDITION_DISPLAY_TYPE_STORE = 7; // 门店
    public static final int CONDITION_DISPLAY_TYPE_CITY = 8; // 城市
    public static final int CONDITION_DISPLAY_TYPE_UNTILNOW = 9; // 注册时长和最后消费时长

    public static String getCdtionDisplayType(int type) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(CONDITION_DISPLAY_TYPE_NUMERIC, "数值类型");
        statusMap.put(CONDITION_DISPLAY_TYPE_WECHAT, "微信绑定状态");
        statusMap.put(CONDITION_DISPLAY_TYPE_CHANNEL, "渠道");
        statusMap.put(CONDITION_DISPLAY_TYPE_MEMTYPE, "会员类型");
        statusMap.put(CONDITION_DISPLAY_TYPE_MEMLEVEL, "会员等级");
        statusMap.put(CONDITION_DISPLAY_TYPE_DATE, "日期");
        statusMap.put(CONDITION_DISPLAY_TYPE_STORE, "门店");
        statusMap.put(CONDITION_DISPLAY_TYPE_CITY, "城市");
        statusMap.put(CONDITION_DISPLAY_TYPE_UNTILNOW, "注册时长和最后消费时长");
        return statusMap.get(type) == null ? "未知" : statusMap.get(type);
    }


    /***********************条件单位*************************/
    public static final int CONDITION_UNIT_YUAN = 10; // 元
    public static final int CONDITION_UNIT_TIMES = 20; // 次
    public static final int CONDITION_UNIT_DAY = 30; // 天

    public static String getConditionUnit(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(CONDITION_UNIT_YUAN, "元");
        statusMap.put(CONDITION_UNIT_TIMES, "次");
        statusMap.put(CONDITION_UNIT_DAY, "天");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /*********************微信绑定状态***********************/
    public static final int WX_BINDING_STATUS_YES = 10; // 微信已绑定
    public static final int WX_BINDING_STATUS_NO = 20; // 微信未绑定

    public static String getWxBindingStatus(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(WX_BINDING_STATUS_YES, "已绑定");
        statusMap.put(WX_BINDING_STATUS_NO, "未绑定");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /*********************条件关联关系************************/
    public static final int CONDITION_RELATION_AND = 10; // and
    public static final int CONDITION_RELATION_OR = 20; // or

    public static String getConditionRelation(int id) {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(CONDITION_RELATION_AND, "and");
        statusMap.put(CONDITION_RELATION_OR, "or");
        return statusMap.get(id) == null ? "未知" : statusMap.get(id);
    }

    /*********************微信推送状态************************/
    public static final int WECHAT_PUSH_SUCCESS = 20;//微信推送成功
    public static final int WECHAT_PUSH_FAIL = 30;//微信推送失败

    /*********************会员注册-用户使用权限************************/
    public static final String DC = "dc";
    public static final String STORE = "store";
    public static final String CHANNEL = "channel";
    public static String getUserAccessRight(String category) {
        stringMap = new HashMap<String, Object>();
        stringMap.put(DC, "dc");
        stringMap.put(STORE, "storeCode");
        stringMap.put(CHANNEL, "registerChannel");
        return !stringMap.containsKey(category) ? "未知" : stringMap.get(category).toString();
    }

    /*********************OA中间表-状态流转************************/
    //回写字段：flag=1(已发起流程且成功)，2(异常)，3（失败），4（审核中），5（驳回），6（审核通过），100（OA审批完成）
    public static final String OA_SUCCESS = "1";
    public static final String OA_EXCEPTION = "2";
    public static final String OA_ERROR = "3";
    public static final String OA_IN_APPROVE = "4";
    public static final String OA_REJECTED = "5";
    public static final String OA_APPROVED = "6";
    public static final String OA_COMPLETE = "100";

    /*********************mk_task_exec_rec-发送类型：1-优惠券，2-短信，3-微信************************/
    public static final String SEND_COUPON = "COUPON";
    public static final String SEND_SMS = "SMS";
    public static final String SEND_WECHAT = "WEIXIN_PUSH";
    public static int getTaskExecSendType(String type) {
        stringMap = new HashMap<String, Object>();
        stringMap.put(SEND_COUPON, 1);
        stringMap.put(SEND_SMS, 2);
        stringMap.put(SEND_WECHAT, 3);
        return !stringMap.containsKey(type) ? 0 : (int) stringMap.get(type);
    }

    /*********************日期类型************************/
    public static final String DATE_ONE_TIME = "ONE_TIME";
    public static final String DATE_WEEKLY = "WEEKLY";
    public static final String DATE_DAILY = "DAILY";
    public static final String DATE_MONTHLY = "MONTHLY";
    public static String getDateType(String type) {
        stringMap = new HashMap<String, Object>();
        stringMap.put(DATE_ONE_TIME, "单次执行");
        stringMap.put(DATE_WEEKLY, "按周循环");
        stringMap.put(DATE_DAILY, "按天循环");
        stringMap.put(DATE_MONTHLY, "按月循环");
        return !stringMap.containsKey(type) ? "0" : stringMap.get(type).toString();
    }

}

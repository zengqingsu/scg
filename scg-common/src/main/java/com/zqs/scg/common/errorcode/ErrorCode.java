package com.zqs.scg.common.errorcode;

/**
 * Created by Jungle on 2016/12/13.
 */
public enum ErrorCode {
    // 系统级别错误码
    SUCCESS(0,"OK"),
    ERROR_DEFAULT(-99999, "发生异常，未知错误"),
    ERROR(-1,"系统繁忙，请稍后重试"),
    ERROR_INVALID_PARAMS(-2,"请求报文参数缺失或无效:"),
    ERROR_HTTP_REQUEST_FAIL(-3,"HTTP接口调用失败"),
    ERROR_EXCEPTION_DATA(-4, "数据异常"),
    ERROR_TIMEOUT(-5, "超时"),

    // DB 层面异常
    ERROR_EXCEPTION_DB_DML(-10,"DB操作异常"),
    ERROR_INVALID_DB_RECORD(-11,"数据库无此记录"),
    ERROR_EXIST_DB_RECORD(-12, "请勿重复提交"),
    ERROR_UPDATE_FAIL(-13, "更新失败"),
    ERROR_PARAMS_NOTEXIST(-14, "参数不能为空"),
    ERROR_PARAMS_FAIL(-15, "状态不对"),
    ERROR_OA_FLAG_FAIL(-16, "记录审批中，不可更改"),

    // Redis 层面异常
    ERROR_EXCEPTION_REDIS_ILLEGAL_IP_PORT(-20,"Redis连接，ip或port不合法"),
    ERROR_EXCEPTION_REDIS_CONFIGURATION_FILE(-21,"解析jedis配置文件失败"),
    ERROR_EXCEPTION_REDIS_CONNECTION(-22,"Redis连接失败"),
    ERROR_EXCEPTION_REDIS_DML(-23,"Redis操作异常"),


    // 服务层面
    ERROR_EXCEPTION_USERS(30001,"账号不存在或密码错误"),
    ERROR_REPEAT_PHONENUMBER(30002,"手机号已被注册"),
    ERROR_EXCEPTION_MOBILE_CODE(30003,"验证码不正确，请重新输入"),
	ERROR_EXCEPTION_NETWORK(30004,"网络异常"),
    ERROR_EXCEPTION_WRONGTIME(30005, "开始时间必须小于结束时间"),
    ERROR_ALREADY_FIRST(30006, "已是第一个，无法上移"),
    ERROR_ALREADY_LAST(30007, "已是最后一个，无法下移"),
    ERROR_OA_SUBMIT_FAIL(30008, "提交OA审核失败，无相关账号，请联系管理员！"),
    ERROR__PARAM_CODE_MOBILE(30009, "手机号错误"),
	/******************权限**************************/
	ERROR_EXCEPTION_NAME_REPEAT(50001,"角色名称已存在"),
	ERROR_EXCEPTION_USERROLE_REPEAT(50002,"用户已存在角色，不能重复添加"),
	ERROR_EXCEPTION_ROLE_HASUSER(50003,"该角色已设置用户，不能删除"),
	ERROR_EXCEPTION_USER_STOP(50004,"该数据不是此用户创建，无权删除"),
	ERROR_LINE_TOP_FAIL(50005,"优惠力度不能为空"),
	ERROR_LINE_DOWN_FAIL(50006,"单店成本不能为空"),

	/******************字典**************************/
	ERROR_EXCEPTION_DICTIONARY_NAME_REPEAT(55001,"字典名称已存在"),

	/******************文件上传**********************/
	ERROR_GENERATE_TABLE(60001, "生成表失败"),
	ERROR_UPLOAD_FILE_SIZE(60002, "文件大小超出限制(10M)"),
	ERROR_UPLOAD_WRONG_TYPE(60003, "上传的文件格式有误"),

	/******************会员条件相关*******************/
	ERROR_LOGIC_SYMBOL(70001, "不支持此逻辑关系，请重新选择"),
    ERROR_CONDITION_TYPE(70002, "无相关数据"),
	ERROR_CONDITION_VALUE(70003, "数值不能为负数"),

	/******************模板相关*******************/
	ERROR_WX_TEMPLATE_LINK_URL(80001, "请填写链接地址"),
    ERROR_LAST_TEMPLATE_NOT_EXISTS(80002, "无相关模板"),

	/******************优惠券/短信相关******************/
	ERROR_COUPON_PUSH_TASKS(90001, "没有优惠券推送任务发出"),
	ERROR_SMS_SEND_TASKS(90002, "没有短信发送任务发出");

    private int code ;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 枚举类型的判断和获取
     * @param code 错误码
     * @return 返回错误码对应的枚举信息
     */
    public static ErrorCode statusOf(int code){
        for(ErrorCode error : values()){
            if(error.getCode() == code){
                return error;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? "" : msg.trim();
    }
}

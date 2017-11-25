package com.zqs.scg.manager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zqs.scg.common.http.ContentType;
import com.zqs.scg.common.http.result.HttpStatus;
import com.zqs.scg.common.httpClient.Client;
import com.zqs.scg.common.httpClient.ClientRequest;
import com.zqs.scg.common.httpClient.ClientResult;
import com.zqs.scg.common.utils.PhoneUtils;
import com.zqs.scg.manager.service.IsmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @Author; zengqinghsu
 * @Description:
 * @Date:Created in 2017/11/24 14:32
 */
@Service("smsService")
public class SmsService implements IsmsService{
    private static final transient Logger logger = LoggerFactory.getLogger(SmsService.class);

    private static final String SMS_URL = "http://116.213.72.20/SMSHttpService/send.aspx";
    private static final String SMS_USERNAME = "bdxx1";
    private static final String SMS_PASSWORD = "bd111111";
    private ThreadPoolExecutor smsPoolExecutor;
    private int corePoolSize = 5;
    private int maximumPoolSize = 10;

    public void sendSms(String type, String mobile, String content) {
        if (type.equals("SMS_TYPE_VERIFYMOBILE")) {
            smsPoolExecutor.execute(new VerifyMobileSmsTask(mobile));
        }
    }

    @PostConstruct
    public void init() {
        BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(3000);
        smsPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS, taskQueue);
       /* smsPoolExecutor.allowCoreThreadTimeOut(false);*/
    }

    private String sendVerifyMobileSms(String mobile) {
        if (!PhoneUtils.phoneChina(mobile)) {
            return "ERROR__PARAM_CODE_MOBILE";
        }
        String mobileValidateCode = String.valueOf(Math.random()*9000+1000).substring(0, 4);
        String content = "SMS_TITLE_VERIFYMOBILE" + mobileValidateCode;
        Map<String,String> params=new HashMap<String,String>();
        params.put("username", SMS_USERNAME);
        params.put("password", SMS_PASSWORD);
        params.put("mobile", mobile);
        params.put("content", content);
        params.put("extcode", "");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.put("senddate",sdf.format(new Date()));
        params.put("batchID", "");

        Client client =new Client(null);

        ClientRequest request=new ClientRequest(SMS_URL);
        request.setContentType(ContentType.JSON.value());
        request.setJsonParam(JSONObject.toJSONString(params));

        ClientResult result =client.build(request).post();

        if (HttpStatus.OK==result.getStatus()) {


            return "SMS_VERIFYMOBILE_SUCCESS";
        } else {
            return "SMS_VERIFYMOBILE_ERROR";
        }
    }

    private class VerifyMobileSmsTask implements Runnable {
        private String mobile;
        public VerifyMobileSmsTask(String mobile) {
            this.mobile = mobile;
        }

        public void run() {
            String success = sendVerifyMobileSms(mobile);
            if (!success.equals(success)) {
                logger.error("error");
            }
        }
    }

}

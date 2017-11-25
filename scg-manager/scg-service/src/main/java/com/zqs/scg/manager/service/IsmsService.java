package com.zqs.scg.manager.service;

/**
 * @Author; zengqinghsu
 * @Description:
 * @Date:Created in 2017/11/24 14:31
 */
public interface IsmsService {
    void sendSms(String type, String mobile, String content);
}

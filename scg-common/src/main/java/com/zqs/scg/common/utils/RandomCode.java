package com.zqs.scg.common.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 产生随机数
 *
 * @author xiao
 */
public class RandomCode {

    /**
     * 获取32位UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 随机产生随机数（字母+数字）
     *
     * @param length 随机数个数
     * @return
     */
    public static String getShuffleCode(int length) {
//		String[] shuffleCode = new String[] {"0", "1", "2", "3", "4", "5", "6", "7",    
//	            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
//	            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };  
        String[] shuffleCode = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        List list = Arrays.asList(shuffleCode);
        Collections.shuffle(list);
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sbuilder.append(list.get(i));
        }
        return sbuilder.toString();
    }

}

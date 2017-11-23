package com.zqs.scg.common.utils;

import java.math.BigDecimal;

/**
 *
 * <p>通过经纬度计算两点距离<p/>
 *
 * Created by wangxuan on 2017/4/25.
 */
public class DistanceUtil {

    private static final double EARTH_RADIUS = 6378137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算结果单位为米
     * @param lat1 A点纬度
     * @param lng1 A点经度
     * @param lat2 B点纬度
     * @param lng2 B点经度
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2), 2) +
            Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b/2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    /**
     * 判断结果: <br/>
     *  小于1000m时,单位为m;<br/>
     *  大于1000m时,单位为km,保留两位小数.
     */
    public static String smartDistance(double distance) {
        BigDecimal var1 = new BigDecimal(distance);
        BigDecimal var2 = new BigDecimal(1000);
        if (compare(var1, var2)) { // 距离小于1000m
            return distance + "m";
        } else {
            return String .format("%.2f", distance / 1000) + "km";
        }
    }

    public static boolean compare(BigDecimal val1, BigDecimal val2) {
        if (val1.compareTo(val2) < 0) {// 第二个数大
            return true;
        } else { // 第一个大于等于第二个数
            return false;
        }
    }

    // 家 ：     114.130076,22.551514
    // 公司：    113.939905,22.522928
    // 公司附近：113.939165,22.523012
    public static void main(String[] args) {
        double distance = getDistance(114.130076,22.551514,113.939165,22.523012);
        String distanceString = smartDistance(distance);
        System.out.print("Distance is: " + distanceString);
    }
}

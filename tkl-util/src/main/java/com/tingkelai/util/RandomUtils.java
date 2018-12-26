package com.tingkelai.util;

import java.security.SecureRandom;

/**
 * 随机数相关工具类
 * 2018-12-25 15:38:12
 * @author liuzhengjie
 * @version 1.0
 */
public class RandomUtils {

    /**
     * 获得一个6位数的随机数
     */
    public static String randomNum(){
        return randomNum(6);
    }

    /**
     * 获得一个指定位数的随机数
     */
    public static String randomNum(int num){
        SecureRandom ranGen = new SecureRandom();
        StringBuffer sb = new StringBuffer("");
        for (int i = 0 ; i < num ; i ++) {
            sb.append(ranGen.nextInt(10));
        }
        return sb.toString();
    }
}

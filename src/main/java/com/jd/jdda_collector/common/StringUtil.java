package com.jd.jdda_collector.common;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {
    public static boolean isEmpty(String text){
        return null == text || "".equals(text.trim());
    }
}

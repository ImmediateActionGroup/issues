package com.immediateactiongroup.issues.utils;

import java.util.Date;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午4:23
 */
public class DateUtils {

    public static Long getMills(){
        return System.currentTimeMillis();
    }

    public static Date getNow(){
        return new Date();
    }
}

package com.immediateactiongroup.other;

import org.junit.Test;

import java.util.Calendar;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/1 下午4:44
 */
public class CalendarTest {

    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeInMillis() + "*****" + System.currentTimeMillis());
        long time = calendar.getTimeInMillis();
        Calendar.Builder builder = new Calendar.Builder();
        builder.setInstant(time + 5 * 60 * 1000);
        Calendar now = builder.build();
        System.out.println(now.getTimeInMillis());
    }
}

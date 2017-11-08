package com.immediateactiongroup.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/10/29 下午5:32
 */
public class ServletABTest {

    @Test
    public void test() throws Exception {
        ServletA servletA = new ServletA();
        servletA.init();
        System.out.println("#########");

        ServletB servletB = new ServletB();
        servletB.init();

        System.out.println("================");

        servletB.methodTest();

        List list = new ArrayList();



    }
}

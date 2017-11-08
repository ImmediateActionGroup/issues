package com.immediateactiongroup.other;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/10/29 下午5:27
 */
public class ServletB extends ServletA {

    @Override
    public void initServletBean() {
        System.out.println("This is ServletB initServletBean();");
    }

    public void methodTest(){
        super.method();
    }

    @Override
    public void method2(){
        System.out.println("This is ServletB method2");
        ServletB.this.init();
    }
}

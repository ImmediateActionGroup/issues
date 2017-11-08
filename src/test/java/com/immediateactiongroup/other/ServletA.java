package com.immediateactiongroup.other;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/10/29 下午5:18
 */
public class ServletA {

    public ServletA() {
        System.out.println("constructor method");
    }

    {
        System.out.println("code block");
    }

    static {
        System.out.println("static code block");
    }

    public void init(){
        System.out.println("This is Servlet A init()");

        this.initServletBean();
    }

    public void initServletBean(){
        System.out.println("This is " + this.getClass().getName() + ".initServletBean()");
    }

    public void method(){
        System.out.println("This is ServletA method()");
        method2();
    }

    public void method2(){
        System.out.println("This is ServletA method2");
    }
}

package com.immediateactiongroup.other.duoxiancheng;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/10/30 下午10:56
 */
public class Demo extends Thread {
    private String name;

    public Demo(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("===" + name + "  : " + i);
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Demo("thread1");
        Thread thread2 = new Demo("thread2");

        //thread1.start();
        //thread2.start();

        thread1.run();
        thread2.run();

    }

}

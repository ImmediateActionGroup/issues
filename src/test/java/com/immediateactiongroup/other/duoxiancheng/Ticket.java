package com.immediateactiongroup.other.duoxiancheng;


import java.util.Random;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/10/30 下午11:06
 */
public class Ticket implements Runnable {

    private int ticket;

    public Ticket(int ticket){
        this.ticket = ticket;
    }

    public synchronized void sell(){
        if(ticket > 0) {
            try {
                long seed = System.currentTimeMillis();
                Random random = new Random(seed);
                int ran = random.nextInt(10);
                Thread.sleep(ran * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
            int num = ticket;
            System.out.println(Thread.currentThread().getName() + "--当前票数: " + (num + 1) + " ,卖出一张票; 剩余票数: " + num);
        }
    }
    @Override
    public void run() {

        while (ticket > 0){
            System.out.println(Thread.currentThread().getName() + "ticket = " + ticket);
            sell();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        int total = 10;
        Ticket ticket = new Ticket(total);

        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");
        Thread thread4 = new Thread(ticket, "窗口4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

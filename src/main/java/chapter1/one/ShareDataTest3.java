package chapter1.one;

import java.util.Random;

public class ShareDataTest3 {
    static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        //不共享数据的做法
        /*MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();*/

//        //共享数据的做法
//        MyThread myThread = new MyThread();
//        Thread a = new Thread(myThread, "A");
//        Thread b = new Thread(myThread, "B");
//        Thread c = new Thread(myThread, "C");
//        a.start();
//        b.start();
//        c.start();
        System.out.println();
    }

    static class MyThread extends Thread{
        private int count = 5;

        public MyThread(String name) {
            super(name);
        }

        public MyThread() {
            super();
        }

        @Override
        public synchronized void run() {
            while (count>0){
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"："+count--);
            }
        }
    }
}

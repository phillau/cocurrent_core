package chapter1.one;

import java.util.concurrent.TimeUnit;

public class InterruptTest6 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        while (myThread.isAlive()) {
            myThread.interrupt();
            System.out.println("already interrupt");
            //测试当前运行interrupted()方法的线程，即main线程是否中断，所有第一次输出false，并且interrupted()方法具有清除状态的功能，所以第二次也返回了false
            System.out.println("interrupted1:" + myThread.interrupted());
            //（两次之间又使线程再次中断的情况除外）
            //Thread.currentThread().interrupt();
            System.out.println("interrupted2:" + myThread.interrupted());
            System.out.println("----------------------------------------");
            //测试线程Thread对象（当前为myThread即Thread-0）是否中断，不清除状态，所以两次都为true
            System.out.println("isInterrupted1:" + myThread.isInterrupted());
            System.out.println("isInterrupted2:" + myThread.isInterrupted());
            break;
        }
    }

    static class MyThread extends Thread {
        /*@Override
        public void run() {
//            System.out.println("interrupted:" + this.interrupted());
//            System.out.println("interrupted:" + this.interrupted());
            for (int i = 0; i < 10000; i++) {
                if(this.interrupted()) {
                    System.out.println("被打断，退出");
                    break;
                }
                System.out.println("i=" + i);
            }
            System.out.println("记住，线程并未停止！");
        }*/
        /*@Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    if (this.interrupted()) {
                        System.out.println("被打断，退出");
                        throw new InterruptedException();
                    }
                    System.out.println("i=" + i);
                }
                System.out.println("线程不会执行这句话");
            } catch (InterruptedException e) {
                System.out.println("线程进入catch块，结束");
                e.printStackTrace();
            }
        }*/
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100000; i++) {
                    System.out.println("i=" + i);
                }
                System.out.println("begin");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("end");
            } catch (InterruptedException e) {
                System.out.println("线程进入catch块，结束");
                System.out.println("线程状态："+this.isInterrupted());
                e.printStackTrace();
            }
        }
    }
}

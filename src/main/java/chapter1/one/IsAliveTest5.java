package chapter1.one;

public class IsAliveTest5 {
    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        System.out.println("begin:" + myThread.isAlive());
//        myThread.start();
//        Thread.sleep(100);
//        System.out.println("end:" + myThread.isAlive());

        //myThread2是没有进入到Alive状态的，因为是启动的outerThread来执行的myThread2的run()方法
        MyThread2 myThread2 = new MyThread2("innerThread");
        Thread thread = new Thread(myThread2,"outerThread");
        thread.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("run="+Thread.currentThread().isAlive());
        }
    }

    static class MyThread2 extends Thread {
        public MyThread2(String name) {
            super(name);
            System.out.println("----------------constructor----------------");
            System.out.println("Thread.currentThread()="+Thread.currentThread().getName()+" "+Thread.currentThread().isAlive());
            System.out.println("this="+this.getName()+" "+this.isAlive());
            System.out.println("----------------constructor----------------");
        }

        @Override
        public void run() {
            System.out.println("----------------run----------------");
            System.out.println("Thread.currentThread()="+Thread.currentThread().getName()+" "+Thread.currentThread().isAlive());
            System.out.println("this="+this.getName()+" "+this.isAlive());
            System.out.println("----------------run----------------");
        }
    }
}

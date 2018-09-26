package chapter1.one;

public class NameTest4 {
    public static void main(String[] args) {
        MyThread innerThread = new MyThread();
//        innerThread.setName("innerThread");
        Thread outerThread = new Thread(innerThread,"outerThread");
        outerThread.start();
    }

    static class MyThread extends Thread {
        public MyThread() {
            System.out.println("----------------constructor----------------");
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("----------------constructor----------------");
        }

        @Override
        public void run() {
            System.out.println("----------------run----------------");
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("----------------run----------------");
        }
    }
}


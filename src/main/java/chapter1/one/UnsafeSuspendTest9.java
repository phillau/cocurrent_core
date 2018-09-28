package chapter1.one;

//调用suspend时线程会暂停在调用时刻的那个状态，如果因为其他原因没有调用resume()方法，可能会导致某线程一直占着某个共享资源
public class UnsafeSuspendTest9 {
    public static void main(String[] args) throws InterruptedException {
        /*SynchronizedObject synchronizedObject = new SynchronizedObject();
        Thread a = new Thread(()->{
            synchronizedObject.print();
        },"a");
        a.start();
        Thread.sleep(500);
        Thread b = new Thread(()->{
            System.out.println("b线程永远进入不了print方法，因为被a线程锁定并且永远suspend暂停了");
            synchronizedObject.print();
        },"b");
        b.start();*/

        MyThread myThread = new MyThread("MyThread");
        myThread.start();
        Thread.sleep(100);
        myThread.suspend();
        System.out.println("------------------main end---------------------");
    }

    static class SynchronizedObject{
        synchronized void print(){
            System.out.println("begin");
            System.out.println("a线程永远suspend了");
            if("a".equals(Thread.currentThread().getName())){
                Thread.currentThread().suspend();
            }
            System.out.println("end");
        }
    }

    static class MyThread extends Thread{
        public MyThread(String name) {
            super(name);
        }

        long i = 0;
        @Override
        public void run() {
            while (true){
                /*try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(i++);
            }
        }
    }
}

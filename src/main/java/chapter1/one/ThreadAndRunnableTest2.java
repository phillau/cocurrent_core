package chapter1.one;

//当前运行的线程为：OuterThread
//因为Thread实现了Runnable接口，那也就意味着构造函数Thread(Runnable target)不光可以传入Runnable对象，还可以传入Thread对象，将自己的run()方法交给其他线程运行
public class ThreadAndRunnableTest2 {
    public static void main(String[] args) {
        new Thread(new Thread(() -> {
            System.out.println("当前运行的线程为：" + Thread.currentThread().getName());
        }, "InnerThread"), "OuterThread").start();
    }
}

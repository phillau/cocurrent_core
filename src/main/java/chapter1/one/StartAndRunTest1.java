package chapter1.one;

import java.util.Random;

//调用start()方法代表交给“线程规划器”来进行调度，具有异步执行的效果，
//如果是调用run()方法就代表由main线程来调用run()方法，也就是必须等到run()方法中的代码执行完毕才继续往下执行，就变成同步了
//也就是说只有调用start()方法以后Thread才有意义，变成了真正的线程，否则就是相当于main线程执行了普通的代码块
public class StartAndRunTest1 {
    static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run=" + Thread.currentThread().getName());
            }
        }, "myThread").start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }
}

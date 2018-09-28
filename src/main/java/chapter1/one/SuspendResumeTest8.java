package chapter1.one;

public class SuspendResumeTest8 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(3000);
        //A段
        myThread.suspend();
        System.out.println("A="+System.currentTimeMillis()+" i="+myThread.getI());
        Thread.sleep(3000);
        System.out.println("A="+System.currentTimeMillis()+" i="+myThread.getI());
        //B段
        myThread.resume();
        Thread.sleep(3000);
        //C段
        myThread.suspend();
        System.out.println("B="+System.currentTimeMillis()+" i="+myThread.getI());
        Thread.sleep(3000);
        System.out.println("B="+System.currentTimeMillis()+" i="+myThread.getI());
    }

    static class MyThread extends Thread{
        private long i;

        public long getI() {
            return i;
        }

        public void setI(long i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (true){
                i++;
            }
        }
    }
}

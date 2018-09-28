package chapter1.one;

//suspend()还可能导致共享数据不一致
public class UnsafeSuspendTest10 {
    public static void main(String[] args) throws InterruptedException {
        MyObject myObject = new MyObject();
        new Thread(() -> myObject.setValue("a", "aa"), "a").start();
        Thread.sleep(100);
        new Thread(() -> {
            myObject.print();
        }, "b").start();
    }

    static class MyObject {
        private String o1 = "1";
        private String o2 = "11";

        public void setValue(String o1, String o2) {
            this.o1 = o1;
            if ("a".equals(Thread.currentThread().getName())) {
                Thread.currentThread().suspend();
            }
            this.o2 = o2;
        }

        public void print() {
            System.out.println(this.o1 + " " + this.o2);
        }
    }
}
package chapter1.one;

public class YieldTest11 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000 ; i++) {
            Thread.yield();
            count = i+1;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

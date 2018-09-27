package chapter1.one;

//使用stop()方法可能会造成数据不一致等问题
public class UnsafeStopTest7 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        MyThread myThread = new MyThread(synchronizedObject);
        myThread.start();
        Thread.sleep(500);
        myThread.stop();
        System.out.println(synchronizedObject.getUsername()+" "+synchronizedObject.getPassword());
    }

    static class SynchronizedObject{
        private String username = "a";
        private String password = "aa";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        synchronized void print(String username,String password){
            try {
                this.username = username;
                Thread.sleep(10000);
                this.password = password;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread{
        private SynchronizedObject synchronizedObject;

        public MyThread(SynchronizedObject synchronizedObject) {
            super();
            this.synchronizedObject = synchronizedObject;
        }

        @Override
        public void run() {
            synchronizedObject.print("b","bb");
        }
    }
}

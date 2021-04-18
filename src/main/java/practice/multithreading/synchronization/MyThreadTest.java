package practice.multithreading.synchronization;

public class MyThreadTest {
    public static void main(String[] args) {
        Table t = new Table();
        MyThread1 t1 = new MyThread1(t);
        t1.setName("t1");
        t1.start();
        MyThread2 t2 = new MyThread2(t);
        t2.setName("t2");
        t2.start();
        Table tt = new Table();
        MyThread3 t3 = new MyThread3(tt);
        t3.setName("t3");
        t3.start();
        MyThread4 t4 = new MyThread4(tt);
        t4.setName("t4");
        t4.start();
    }
}

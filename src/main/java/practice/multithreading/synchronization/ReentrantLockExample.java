package practice.multithreading.synchronization;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public synchronized void m() {
        n();
        System.out.println("this is m() method.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException i) {
        }
        //t1 didn't get chance eventhough n() method invocation is completed.
        // This proves Java object monitors are reentrant in nature.
        // It also saves single thread to create cyclic deadlock.
    }

    public synchronized void n() {
        System.out.println("this is n() method acquired by :"
                + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ReentrantLock r = new ReentrantLock();
        ReentrantLockExample re = new ReentrantLockExample();
        Thread t = new Thread(() -> {
            r.lock();
            re.m();
            r.unlock();
        }, "t0");
        t.start();
        Thread t1 = new Thread(() -> {
            re.n();
        }, "t1");
        t1.start();
    }
}

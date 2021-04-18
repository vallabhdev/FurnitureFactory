package practice.multithreading.synchronization;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockApiExample implements Runnable {
    private Perform per;
    private Lock lock;

    public LockApiExample(Perform perform, Lock lock) {
        this.per = perform;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                per.performDbOperations(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
        per.doLogging(Thread.currentThread().getName());
    }

    //    @Override
    public void runWithoutLockApi() {
        synchronized (per) {
            per.performDbOperations(Thread.currentThread().getName());
        }
        per.doLogging(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        LockApiExample obj = new LockApiExample(new Perform(), new ReentrantLock());
        Thread t = new Thread(obj, "t");
        Thread t1 = new Thread(obj, "t1");
        Thread t2 = new Thread(obj, "t2");
        Thread t3 = new Thread(obj, "t3");
        Thread t4 = new Thread(obj, "t4");
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Perform {
    public void performDbOperations(String name) {
        System.out.println("read/write db by.." + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    public void doLogging(String name) {
        System.out.println("logging as usual by.." + name);
    }
}

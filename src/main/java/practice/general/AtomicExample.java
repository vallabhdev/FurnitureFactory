package practice.general;

public class AtomicExample extends Thread {
    //        AtomicInteger ai = new AtomicInteger();
    private volatile int count;

    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + count++);
//            System.out.println(Thread.currentThread().getName() + " - " + ai.getAndIncrement());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main1(String[] args) {
        AtomicExample t1 = new AtomicExample();
        AtomicExample t2 = new AtomicExample();
        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        PThread t = new PThread();
        Thread t1 = new Thread(t, "t1");
        Thread t2 = new Thread(t, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class PThread implements Runnable {
    //    private AtomicInteger count = new AtomicInteger();
    private int count;

    @Override
    public void run() {
        for (int i = 0; i <= 4; i++) {
//            System.out.println(Thread.currentThread().getName() + " - " + count.getAndIncrement());
            System.out.println(Thread.currentThread().getName() + " - " + count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
//        System.out.println(Thread.currentThread().getName() + " - " + flag);
    }
}

package practice.multithreading.synchronization;

public class InterruptedThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 2; i++) {
            if (Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " - interrupted code flow");
            } else {
                System.out.println(Thread.currentThread().getName() + " - normal code flow");
            }
        }
    }

    public static void main(String[] args) {
        InterruptedThread t = new InterruptedThread();
        InterruptedThread t2 = new InterruptedThread();
        t.start();
        t.interrupt();
        t2.start();
    }

/*
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task");
        } catch (InterruptedException e) {
//            throw new RuntimeException("Exception handled " + e);
            System.out.println("Exception handled - " + e);
        }
        System.out.println("Thread is running....!");

    }
*/

/*    public static void main1(String[] args) {
        InterruptedThread t = new InterruptedThread();
        t.start();
        try {
            t.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled.. " + e);
        }
    }*/
}

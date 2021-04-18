package practice.multithreading.synchronization;

public class DeadlockExample {

    public static void main(String[] args) {
        final String s1 = "s1";
        final String s2 = "s2";

        Thread t1 = new Thread(() -> {
            synchronized (s1) {
                System.out.println("t1 acquired lock on s1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }

                synchronized (s2) {
                    System.out.println("t1 acquired lock on s2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (s2) {
                System.out.println("t2 acquired lock on s2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }

                synchronized (s1) {
                    System.out.println("t2 acquired lock on s1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

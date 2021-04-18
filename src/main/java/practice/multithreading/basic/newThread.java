package practice.multithreading.basic;

public class newThread extends Thread {
    static newThread t1;

    public void run() {
        try {
            t1.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("running");
    }

    public static void main(String[] args) {
        t1 = new newThread();
        t1.start();
    }
}

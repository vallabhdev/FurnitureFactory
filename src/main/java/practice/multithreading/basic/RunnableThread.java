package practice.multithreading.basic;

public class RunnableThread implements Runnable {
    public void run() {
        System.out.println("running....");
    }

    public static void main(String[] args) {
        RunnableThread r1 = new RunnableThread();
        Thread t1 = new Thread(r1);
        t1.setDaemon(true);
        t1.start();
        System.out.println(t1.isDaemon());
    }
}

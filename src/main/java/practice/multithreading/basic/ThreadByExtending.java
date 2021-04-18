package practice.multithreading.basic;

public class ThreadByExtending extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Current thread is " + this.getName() + " - " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadByExtending b1 = new ThreadByExtending();
        ThreadByExtending b2 = new ThreadByExtending();
        b1.setPriority(Thread.MAX_PRIORITY);
        b2.setPriority(Thread.MIN_PRIORITY);
        b1.start();
        b2.start();
//        b2.run(); run in current callstack rather than at the beginning of a new callstack.
//        Won't be a thread & results into a sequential call.
//        b1.start(); starting a thread twice will throw IllegalThreadStateException
    }
}

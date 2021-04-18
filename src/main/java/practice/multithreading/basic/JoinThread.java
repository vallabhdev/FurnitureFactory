package practice.multithreading.basic;

public class JoinThread extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(this.getName() + " - " + i);
        }
    }

    public static void main(String[] args) {
        ThreadByExtending t1 = new ThreadByExtending();
        ThreadByExtending t2 = new ThreadByExtending();
        ThreadByExtending t3 = new ThreadByExtending();
        t1.start();
        try {
//            t1.join(); //will make sure t1 to complete before next instruction executed.
            t1.join(1500); // will wait 1500 millis for t1 to complete before next instruction executed.
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        t2.start();
        t3.start();
    }
}

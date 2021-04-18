package practice.multithreading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main1(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            ThreadByExtending runnable = new ThreadByExtending();
            es.execute(runnable);
        }
        es.shutdown();
        while (!es.isTerminated()) {
        }
        System.out.println("finished");
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            WorkerThread wt = new WorkerThread();
            es.execute(wt);
        }
        es.shutdown();
        while (!es.isTerminated()) {
        }
        System.out.println("Finished");
    }
}

class WorkerThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Started..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}

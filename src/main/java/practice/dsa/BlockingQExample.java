package practice.dsa;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);
        Producer producer = new Producer(blockingQueue);
        new Thread(producer).start();

        Consumer consumer = new Consumer(blockingQueue);
        new Thread(consumer).start();
        Thread.sleep(4000);
    }
}
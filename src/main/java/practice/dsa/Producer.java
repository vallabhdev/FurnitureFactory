package practice.dsa;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    protected BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
//          put is a blocking method.
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
            Thread.sleep(1000);
            queue.put("4");
            Thread.sleep(1000);
            queue.put("5");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


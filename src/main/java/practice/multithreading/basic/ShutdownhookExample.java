package practice.multithreading.basic;

public class ShutdownhookExample {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new Thread(() -> System.out.println("Shutdownhook is triggered..")));
        System.out.println("Now sleeping....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

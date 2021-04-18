package practice.multithreading.basic;

import java.io.IOException;

public class GCExample {

    public void finalize() {
        System.out.println("GC finished");
    }

    public static void main(String[] args) throws IOException {
        GCExample gc1 = new GCExample();
        GCExample gc2 = new GCExample();
        gc1 = null;
        gc2 = gc1;
        System.gc();
//        Runtime.getRuntime().exit(0);
//        Runtime.getRuntime().exec("notepad");
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());

    }
}

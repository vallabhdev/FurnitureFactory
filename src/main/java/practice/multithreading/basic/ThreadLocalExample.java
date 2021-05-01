package practice.multithreading.basic;

import practice.multithreading.synchronization.Table;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<Table> tl = new ThreadLocal<>();
        tl.set(new Table());
        Table table = tl.get();
        tl.remove();
    }
}

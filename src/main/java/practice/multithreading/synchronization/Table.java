package practice.multithreading.synchronization;

public class Table {
    public void printTable(int n) {
        synchronized (Table.class) { //class level lock
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + (n * i));
            }
        }
    }

    public void printTable(Integer n) {
        synchronized (this) { //object level lock
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + (n * i));
            }
        }
    }

    public synchronized void printTable(String n) {// object level lock
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + (n + i));
        }
    }

    public static synchronized void printTable(char n) {// class level lock
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + (n + i));
        }
    }
}

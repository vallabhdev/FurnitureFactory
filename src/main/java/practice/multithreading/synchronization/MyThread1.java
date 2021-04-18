package practice.multithreading.synchronization;

public class MyThread1 extends Thread {
    private Table t;

    public MyThread1(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(1);
    }
}

class MyThread2 extends Thread {
    private Table t;

    public MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(10);
    }
}

class MyThread3 extends Thread {
    private Table t;

    static {
        synchronized (MyThread3.class) {
            System.out.println("init");
        }
    }

    public MyThread3(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

class MyThread4 extends Thread {
    private Table t;

    public MyThread4(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(1000);
    }
}

package practice.multithreading.synchronization;

public class InterThreadCom {
    public static void main(String[] args) {
        Customer customer = new Customer();
        new Thread(() -> {
            customer.withdraw(100);
        }).start();
        new Thread(() -> {
            customer.deposit(900);
        }).start();
    }
}

class Customer {
    private int amount;

    synchronized void withdraw(int amount) {
        System.out.println("current balance: " + this.amount);
        System.out.println("requested withdrawal amount is: " + amount);
        if (this.amount < amount) {
            System.out.println("low balance, waiting for deposits...");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.amount -= amount;
        System.out.println("amount withdrawn.. remaining balance is: " + this.amount);
    }

    synchronized void deposit(int amount) {
        this.amount += amount;
        System.out.println("amount deposited");
        notify();
    }
}
package fcc_multithreading;

public class Main {

    public static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, "Thread One");


        Thread t2 = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, "Thread Two");

        t1.start();
        t2.start();

    }

    public static void one() throws InterruptedException{
        synchronized (LOCK){
            System.out.println("Inside Method 1 before Wait");
            LOCK.wait();
            System.out.println("Inside Method 1 After Wait");
        }
    }

    public static void two() throws InterruptedException{
        synchronized (LOCK){
            System.out.println("Inside Method 2 before Notify");
            LOCK.notify();
            System.out.println("Inside Method 2 After Notify");
        }
    }
}
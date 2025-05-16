package fcc_multithreading.countdown_latch;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int numberOfChef = 3;

        CountDownLatch latch = new CountDownLatch(numberOfChef);

        new Thread(new Chef("Suresh", "Samosa", latch)).start();
        new Thread(new Chef("Ramesh", "Chhole Bhature", latch)).start();
        new Thread(new Chef("Mukesh", "Pav Bhaji", latch)).start();

        latch.await();

        System.out.println("All Dishes are prepared");
    }

}

class Chef implements Runnable{
    private final String name;
    private final String dish;
    private final CountDownLatch countDownLatch;

    public Chef(String name, String dish, CountDownLatch countDownLatch) {
        this.name = name;
        this.dish = dish;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is preparing " + dish);
            Thread.sleep(5_000);
            System.out.println(name + " has finished preparing " + dish);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
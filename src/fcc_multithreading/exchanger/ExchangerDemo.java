package fcc_multithreading.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(new FirstThread(exchanger)).start();
        new Thread(new SecondThread(exchanger)).start();
        new Thread(new ThirdThread(exchanger)).start();
        new Thread(new FourthThread(exchanger)).start();
    }
}


class FirstThread implements Runnable{
    private final Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 10;
        System.out.println("First Thread is sending data " + dataToSend);

        try {
            Thread.sleep(1000);
            Integer exchange = exchanger.exchange(dataToSend);
            System.out.println("First Thread Received -> " + exchange);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

class SecondThread implements Runnable{
    private final Exchanger<Integer> exchanger;

    public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 20;
        System.out.println("Second Thread is sending data -> " + dataToSend);

        try {
            Thread.sleep(1000);
            Integer exchange = exchanger.exchange(dataToSend);
            System.out.println("Second Thread Received -> " + exchange);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

class ThirdThread implements Runnable{
    private final Exchanger<Integer> exchanger;

    public ThirdThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 30;
        System.out.println("Third Thread is sending data -> " + dataToSend);

        try {
            Thread.sleep(1000);
            Integer exchange = exchanger.exchange(dataToSend);
            System.out.println("Third Thread Received -> " + exchange);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

class FourthThread implements Runnable{
    private final Exchanger<Integer> exchanger;

    public FourthThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 40;
        System.out.println("Fourth Thread is sending data -> " + dataToSend);

        try {
            Thread.sleep(1000);
            Integer exchange = exchanger.exchange(dataToSend);
            System.out.println("Third Thread Received -> " + exchange);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
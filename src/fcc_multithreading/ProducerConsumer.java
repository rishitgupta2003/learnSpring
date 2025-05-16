package fcc_multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {
        Worker worker = new Worker(0,10);

        Thread producer = new Thread(() -> {
            try {
                worker.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "producer");


        Thread producer1 = new Thread(() -> {
            try {
                worker.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "producer1");


        Thread consumer = new Thread(() -> {
            try {
                worker.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Consumer");

        Thread consumer1 = new Thread(() -> {
            try {
                worker.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "consumer1");


        producer.start();
        producer1.start();
        consumer.start();
        consumer1.start();
    }
}

class Worker{
    private int sequence = 0;
    private final Integer top;
    private final Integer bottom;
    private final List<Integer> container;

    private final Object LOCK = new Object();

    public Worker(Integer bottom, Integer top) {
        this.top = top;
        this.container = new ArrayList<>();
        this.bottom = bottom;
    }

    public void producer() throws InterruptedException{
        synchronized (LOCK){
            while(true){
                if(container.size() == top){
                    System.out.println("Container Full for "+ Thread.currentThread().getName() +"! Waiting for item to be removed");
                    LOCK.wait();
                }else{
                    System.out.println(sequence + " Added to the Container " + Thread.currentThread().getName());
                    container.add(sequence++);
                    LOCK.notifyAll();
                }

                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException{
        synchronized (LOCK){
            while(true){
                if(container.size() == bottom){
                    System.out.println("Container Empty for "+ Thread.currentThread().getName() +"! Waiting for item to be Added");
                    LOCK.wait();
                }else{
                    System.out.println(container.removeFirst() + " Removed from container by " + Thread.currentThread().getName());
                    LOCK.notifyAll();
                }

                Thread.sleep(500);
            }
        }
    }
}

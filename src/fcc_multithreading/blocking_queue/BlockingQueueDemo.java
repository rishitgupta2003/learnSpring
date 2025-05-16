package fcc_multithreading.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    static final int QUEUE_CAPACITY = 10;
    static final BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    private static void processTask(int task, String name) throws InterruptedException {
        System.out.println("Task: " + task + " being processed by Thread -> " + name);
        Thread.sleep(100);
        System.out.println("Task: " + task + " Consumed by Thread -> " + name);
    }

    public static void main(String[] args) {
        //Producer Thread
        Thread producer = new Thread( () -> {
            try{
                for(int i = 0 ; i < 20; i++){
                    taskQueue.put(i);
                    System.out.println("Task Produced -> " + i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Producer");

        //Consumers
        Thread consumerOne = new Thread(() -> {
            try{
                while(true){
                    Integer take = taskQueue.take();
                    processTask(take, Thread.currentThread().getName());
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }, "ConsumerOne");


        Thread consumerTwo = new Thread(() -> {
            try{
                while(true){
                    Integer take = taskQueue.take();
                    processTask(take, Thread.currentThread().getName());
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }, "ConsumerTwo");

        producer.start();
        consumerTwo.start();
        consumerOne.start();
    }
}

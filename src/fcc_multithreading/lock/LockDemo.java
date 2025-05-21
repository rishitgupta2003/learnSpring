package fcc_multithreading.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private static final Lock LOCK = new ReentrantLock();
    private static final Integer MAX_SIZE = 5;
    private static final Queue<Integer> buffer = new LinkedList<>();
    private final Condition bufferNotFull = LOCK.newCondition();
    private final Condition bufferNotEmpty = LOCK.newCondition();


    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();

        Thread producerThread = new Thread(
                () -> {
                    for(int i = 0; i < 10; i++){
                        try {
                            lockDemo.produce(i + 1);
                            Thread.sleep(1_000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            throw new RuntimeException(e);
                        }
                    }
                }, "producer-thread"
        );

        Thread consumerThread = new Thread(
                () -> {
                    try {
                        for(int i = 0; i < 10; i++){
                            lockDemo.consumer();
                            Thread.sleep(2_000);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }, "consumer-thread"
        );

        producerThread.start();
        consumerThread.start();
    }


    private void produce(int item) throws InterruptedException{
        LOCK.lock();

        try {
            while(buffer.size() == MAX_SIZE){
                bufferNotFull.await();
            }
            buffer.offer(item);
            System.out.println(Thread.currentThread().getName() + " Produced >> " + item);
            bufferNotEmpty.signal();

        }finally {
            LOCK.unlock();
        }
    }

    private void consumer() throws InterruptedException {
        LOCK.lock();

        try{
            while(buffer.isEmpty()){
                bufferNotEmpty.await();
            }
            Integer item = buffer.poll();
            System.out.println(Thread.currentThread().getName() + " Consumed << " + item);
            bufferNotFull.signal();

        } finally {
            LOCK.unlock();
        }
    }
}
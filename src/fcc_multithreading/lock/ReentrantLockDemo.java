package fcc_multithreading.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    //    Non-fair sync
        private final Lock lock = new ReentrantLock();

    //    Fair Sync
//    private final Lock lock = new ReentrantLock(true);

    private static int sharedData = 0;


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo obj = new ReentrantLockDemo();
        CountDownLatch latch = new CountDownLatch(10);
//        for(int i = 0; i < 5; i++){
//            new Thread(obj::methodA, "thread"+i).start();
//        }

        for(int i = 0; i < 5; i++){
            new IncrementThread(obj, latch).start();
        }

        for(int i = 0; i < 5; i++){
            new DecrementThread(obj, latch).start();
        }

        latch.await();

        System.out.println("Shared Data >> " + sharedData);
    }


    public void methodA(){

        lock.lock();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        //Critical Section
        try{
            sharedData++;
            System.out.println("Method A: Shared Data -> " + sharedData);
        }finally {
            lock.unlock();
        }

    }


    public void methodB(){

        lock.lock();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            Thread.currentThread().start();
            throw new RuntimeException(e);
        }
        //Critical Section
        try{
            sharedData--;
            System.out.println("Method B: Shared Data -> " + sharedData);
        }finally {
            lock.unlock();
        }

    }
}

class IncrementThread extends Thread{
    private final ReentrantLockDemo lockDemo;
    private final CountDownLatch latch;

    public IncrementThread(ReentrantLockDemo lockDemo, CountDownLatch latch) {
        this.lockDemo = lockDemo;
        this.latch = latch;
    }

    @Override
    public void run() {
        lockDemo.methodA();
        latch.countDown();
    }
}

class DecrementThread extends Thread{
    private final ReentrantLockDemo lockDemo;
    private final CountDownLatch latch;

    public DecrementThread(ReentrantLockDemo lockDemo, CountDownLatch latch) {
        this.lockDemo = lockDemo;
        this.latch = latch;
    }

    @Override
    public void run() {
        lockDemo.methodB();
        latch.countDown();
    }
}

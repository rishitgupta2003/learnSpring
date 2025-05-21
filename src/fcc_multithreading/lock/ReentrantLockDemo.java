package fcc_multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();
    private int sharedData = 0;


    public static void main(String[] args) {
        ReentrantLockDemo obj = new ReentrantLockDemo();

        for(int i = 0; i < 5; i++){
            new Thread(obj::methodA, "thread"+i).start();
        }
    }


    public void methodA(){

        lock.lock();
        //Critical Section
        try{
            sharedData++;
            System.out.println("Method A: Shared Data -> " + sharedData);
            methodB();
        }finally {
            lock.unlock();
            lock.unlock();
        }

    }


    public void methodB(){

        lock.lock();
        //Critical Section
        sharedData--;
        System.out.println("Method B: Shared Data -> " + sharedData);

    }
}

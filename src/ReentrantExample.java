import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    /*
    * Same lock can be acquired by same thread in ReentrantLock Implementation
    * Count is maintained for everytime a lock is acquired
    */

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Outer Method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Inner Method");
        }finally {
            lock.unlock();
        }
    }

}

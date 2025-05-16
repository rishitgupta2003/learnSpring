import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock {

    /*
    * Fair Lock -> Reentrant lock uses fairness (if true then thread order will be maintained)
    *           -> default or false then any order will be followed
    */

    private final Lock lock = new ReentrantLock(true);
    //try without fairness
    //private final Lock lock = new ReentrantLock();

    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " -> Trying to acquire lock");
            Thread.sleep(1000);
        }catch(Exception _){
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " -> Released the lock");
            lock.unlock();
        }
    }
}

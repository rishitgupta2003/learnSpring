import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        try{

            /*
            * tryLock() -> immediate return false if lock is not available;
            * tryLock(time, TimeUnit) -> wait for the time limit then return false if lock is not available;
            * lock() -> infinite wait time to acquire lock
            */

            if(lock.tryLock(4_000, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + " attempting to withdraw -> " + amount);
                if(balance >= amount){
                    Thread.sleep(3_000);
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " successfully withdrawn. Remaining Balance -> " + balance);
                }else{
                    System.out.println(Thread.currentThread().getName() + " Insufficient Balance");
                }
            }else{
                System.out.println(Thread.currentThread().getName() + ": Resource Busy");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
        }
    }

    public int getBalance(){
        return balance;
    }
}

package fcc_multithreading.concurrent_collection;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWADemo {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.addAll(List.of(0,0,0,0,0,0,0,0,0,0,0,0,0));
        Thread thread = new ReadTask("ReadTask", list);
        Thread thread1 = new WriteTask("WriteTask", list);

        thread.start();
        thread1.start();
    }

}

class ReadTask extends Thread{
    private final List<Integer> list;

    public ReadTask(String name, List<Integer> list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": Reading List -> "+ list);
        }
    }
}


class WriteTask extends Thread{
    private final List<Integer> list;
    private Random random;

    public WriteTask(String name, List<Integer> list) {
        super(name);
        this.list = list;
        this.random = new Random();
    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(12_00);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list.set(random.nextInt(list.size()), random.nextInt(10));
        }
    }
}
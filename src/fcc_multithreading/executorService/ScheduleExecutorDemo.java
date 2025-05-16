package fcc_multithreading.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new ProbeTask(),1000,2000, TimeUnit.MILLISECONDS);

        try {
            if(!scheduledExecutorService.awaitTermination(5000, TimeUnit.MILLISECONDS)){
                scheduledExecutorService.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ProbeTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Done by Thread: " + Thread.currentThread().getName());
    }
}

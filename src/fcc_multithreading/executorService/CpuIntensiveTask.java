package fcc_multithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuIntensiveTask {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Cores -> " + cores);
        ExecutorService service = Executors.newFixedThreadPool(cores);

        for(int i = 0; i < 20; i++){
            service.execute(new ImpTask());
        }
    }
}

class ImpTask implements Runnable{
    @Override
    public void run() {
        System.out.println("CPU Intensive Task done by Thread: " + Thread.currentThread().getName());
    }
}

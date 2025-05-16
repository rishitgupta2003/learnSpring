package fcc_multithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        try(ExecutorService service = Executors.newCachedThreadPool()){
            for (int i = 0; i < 100000; i++) {
                service.execute(new Task(i+1));
            }
        }
    }
}

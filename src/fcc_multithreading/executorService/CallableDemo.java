package fcc_multithreading.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        try(ExecutorService service = Executors.newFixedThreadPool(cores)){
            List<Future<Integer>> futures = new ArrayList<>();

            for(int i = 0; i < 20; i++){
                futures.add(service.submit(new ReturnThread()));
            }

            List<Integer> list = futures
                    .stream()
                    .map(future -> {
                try {
                    return future.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            })
                    .toList();

            System.out.println(list);
        }
    }
}

class ReturnThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 10;
    }
}

package fcc_multithreading.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiStageTour {
    private static final int NUM_TOURISTS = 5;
    private static final int NUM_STAGES = 3;

    //Until all threads are executed, barrier will not work

    private static final CyclicBarrier barriers = new CyclicBarrier(NUM_TOURISTS, () -> System.out.println("Tour guide starts speaking"));

    static class Tourists implements Runnable{
        private final int touristId;

        public Tourists(int touristId) {
            this.touristId = touristId;
        }

        @Override
        public void run() {
            for(int i = 0; i < NUM_STAGES; i++){
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Tourist: " + touristId + " arrives at the stage " + (i+1));
                try {
                    barriers.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void main(String[] args) {
        for(int i = 0; i < NUM_TOURISTS; i++){
            Thread thread = new Thread(new Tourists(i), "thread");
            thread.start();
        }
    }
}

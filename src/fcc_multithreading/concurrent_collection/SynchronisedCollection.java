package fcc_multithreading.concurrent_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronisedCollection {
    public static void main(String[] args) throws InterruptedException {
//        List<Integer> list = new ArrayList<>();

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1_000; i++){
                list.add(i);
            }
        }
                , "T1");


        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1_000; i++){
                list.add(i);
            }
        }
                , "T2");


        t1.start();
        t2.start();

        t1.join(); t2.join();


        System.out.println(list.size());
    }
}
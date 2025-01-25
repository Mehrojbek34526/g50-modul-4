package uz.pdp.lesson3;

import java.util.*;

/**
 Created by: Mehrojbek
 DateTime: 07/01/25 21:22
 **/
public class SyncCollections {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> numbers = new ArrayList<>();
        List<Integer> syncNumbers = Collections.synchronizedList(numbers);

//        Map<String, Integer> stringIntegerMap = Collections.synchronizedMap(new HashMap<String, Integer>());

        Runnable task = () -> {
            for (int i = 0; i < 500; i++) {
                syncNumbers.add(i);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task1 = () -> {
            for (int i = 0; i < 500; i++) {
                syncNumbers.add(i);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task).start();
        new Thread(task1).start();
        Thread.sleep(2500);

        System.out.println(syncNumbers.size());

    }

}

package uz.pdp.lesson3;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 Created by: Mehrojbek
 DateTime: 07/01/25 21:26
 **/
public class ConcurrentCollections {

    public static void main(String[] args) throws InterruptedException {

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.plusDays(12);

        System.out.println(localDate1);

//        concurrentCollections();

    }

    private static void concurrentCollections() throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        ConcurrentSkipListSet<String> list = new ConcurrentSkipListSet<>();

//        ConcurrentHashMap.KeySetView<Object, Boolean> objects = new ConcurrentHashMap<>().newKeySet();

//        map.put("A", 1);
//
//        map.size();
//
        List<Integer> numbers = new CopyOnWriteArrayList<>();

        Runnable task = () -> {
            for (int i = 0; i < 500; i++) {
                numbers.add(i);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task1 = () -> {
            for (int i = 0; i < 500; i++) {
                numbers.add(i);
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

        System.out.println(numbers.size());
    }

}

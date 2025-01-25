package uz.pdp.lesson4;

import java.util.concurrent.*;

/**
 Created by: Mehrojbek
 DateTime: 09/01/25 19:13
 **/
public class ThreadReturnTest {

    public static void main(String[] args) {

        //thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = () -> {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " active thread count: " + Thread.activeCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 150; i++) {
            executorService.execute(runnable);
        }

//        executorService.execute(() -> System.out.println("test"));
//        executorService.execute(() -> System.out.println("test"));
//        executorService.execute(() -> System.out.println("test"));
//        executorService.execute(() -> System.out.println("test"));

//        executorService.shutdown();
//        executorService.shutdownNow();

        try {
            executorService.shutdown();
            boolean termination = executorService.awaitTermination(200L, TimeUnit.MILLISECONDS);
            if (!termination) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        throw new RuntimeException("Test");


    }



}

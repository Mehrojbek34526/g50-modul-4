package uz.pdp.lesson5;

import java.util.Random;
import java.util.concurrent.*;

/**
 Created by: Mehrojbek
 DateTime: 12/01/25 12:15
 **/
public class CompletableFutureTest {

    public static void main(String[] args) {

//        CompletableFuture
//                .supplyAsync(() -> checkCard("1"))
//                .thenApply(first -> {
//
//                });

        long start = System.currentTimeMillis();

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> generateCode())
                .thenApplyAsync(code -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(code);
                    System.out.println(Thread.currentThread().getName());
                    return new Random().nextBoolean();
                })
                .thenAcceptAsync(condition -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(condition);
                    System.out.println(Thread.currentThread().getName());
                })
                .thenRun(() -> System.out.println("Tugadi"));

        //40_000 talik int array bor ichidan juftlarini summasini hisoblash kerak

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        RecursiveTask<Long> sumResult;
//        forkJoinPool.execute(sumResult);

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Completable future tugadi: Time is : %s", (System.currentTimeMillis() - start));
    }

    public static String generateCode() {
        return String.valueOf(new Random().nextInt(10000, 99999));
    }

    private static void transferWithCompletableFuture() {

//        CompletableFuture.runAsync(() -> System.out.println(new Date()));

        CompletableFuture<Boolean> firstFuture = CompletableFuture.supplyAsync(() -> checkCard("1"));
        CompletableFuture<Boolean> secondFuture = CompletableFuture.supplyAsync(() -> checkCard("2"));

        try {
            Boolean first = firstFuture.get();
            Boolean second = secondFuture.get();
            Thread.sleep(2000);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void transferWithCallable() {

        Callable<Boolean> firstCardCheckCallable = () -> checkCard("1");
        Callable<Boolean> secondCardCheckCallable = () -> checkCard("2");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Boolean> firstFuture = executorService.submit(firstCardCheckCallable);
        Future<Boolean> secondFuture = executorService.submit(secondCardCheckCallable);

        try {
            Boolean first = firstFuture.get();
            Boolean second = secondFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkCard(String card) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Card checked: " + card);
        return true;
    }

}

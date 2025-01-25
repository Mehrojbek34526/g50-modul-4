package uz.pdp.lesson5;

import java.util.Random;
import java.util.concurrent.*;

/**
 Created by: Mehrojbek
 DateTime: 12/01/25 11:00
 **/
public class ForkJoinPoolTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        forkJoinPool.execute(() -> System.out.println("Hello World!"));

        Random random = new Random();
        int[] ints = new int[40_000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(10);
        }
        System.out.println("Array to'ldi");

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        long beginOfForkJoin = System.currentTimeMillis();

        MyRecursiveTask task = new MyRecursiveTask(ints, 500, 0, ints.length);

        Integer count = forkJoinPool.invoke(task);
        long endOfForkJoin = System.currentTimeMillis();
        System.out.printf("ForkJoin result: %d, Time taken: %s\n", count, endOfForkJoin - beginOfForkJoin);

        singleExecutor(ints);


//        RecursiveTask
//        ForkJoinTask

//        forkJoinPool.execute();


    }

    private static void singleExecutor(int[] ints) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long begin = System.currentTimeMillis();

        Future<Integer> submit = executorService.submit(() -> filter(ints));
        Integer count = submit.get();
        System.out.println("Sigle thread result: " + count);
        executorService.shutdown();

        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    private static int filter(int[] ints) {
        int count = 0;
        for (int num : ints) {
            if (num > 2) {
                count++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return count;
    }

}

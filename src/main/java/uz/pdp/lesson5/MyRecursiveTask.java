package uz.pdp.lesson5;

import java.util.concurrent.RecursiveTask;

/**
 Created by: Mehrojbek
 DateTime: 12/01/25 11:23
 **/
public class MyRecursiveTask extends RecursiveTask<Integer> {

    private final int[] array;

    private final int minimumForkSize;

    private final int start;
    private final int end;

    public MyRecursiveTask(int[] array, int minimumForkSize, int start, int end) {
        this.array = array;
        this.minimumForkSize = minimumForkSize;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        //bo'lish kerak
        if (end - start > minimumForkSize) {
            int middle = (start + end) / 2;
            MyRecursiveTask left = new MyRecursiveTask(array, minimumForkSize, start, middle);
            MyRecursiveTask right = new MyRecursiveTask(array, minimumForkSize, middle, end);

            //bajarilishni boshlaydi
            invokeAll(left, right);

            return left.join() + right.join();

            //minimumdan kichkina bo'lsa
        } else {
            int counter = 0;
            for (int i = start; i < end; i++) {
                if (array[i] > 2) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    counter++;
                }
            }
            return counter;
        }
    }
}

package uz.pdp.lesson3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 Created by: Mehrojbek
 DateTime: 07/01/25 19:55
 **/
public class AtomicityTest {

    public static AtomicInteger counter = new AtomicInteger(0);

    public static final Object object1 = new Object();
    public static final Object object2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            for (int i = 0; i < 500; i++) {
                //read, modify, set
                counter.updateAndGet(operand -> operand + 2);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 500; i++) {
                //read, modify, set
//                counter.incrementAndGet();
                counter.updateAndGet(operand -> operand + 2);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        new Thread(task1).start();
        new Thread(task2).start();

        Thread.sleep(2000);

        System.out.println(counter);

    }

    public static void increment(int count) {
        int oldCount = count;
        do {

            count = count + 1;

        } while (!compareAndSwap(oldCount, count));

    }

    public static boolean compareAndSwap(int oldValue, int newValue) {

        //1-xotiradan countni hozirgi qiymatini o'qiydi
        //if(currentCount == oldCount)
        //count=newCount;

        return true;

        //
    }

}

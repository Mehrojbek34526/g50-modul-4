package uz.pdp.lesson3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 Created by: Mehrojbek
 DateTime: 07/01/25 20:57
 **/
public class AtomicRefTest {
    public static void main(String[] args) throws InterruptedException {

        AtomicReference<Double> atomicRef = new AtomicReference<>(0D);

        Runnable task = () -> {
            for (int i = 0; i < 500; i++) {
                atomicRef.updateAndGet(account -> {
                    return account + 1;
//                    account.count = account.count + 1;
//                    return account;
                });

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task1 = () -> {
            for (int i = 0; i < 500; i++) {
                atomicRef.updateAndGet(account -> {
                    return account + 1;
//                    account.count = account.count + 1;
//                    return account;
                });
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task).start();
        new Thread(task1).start();
        Thread.sleep(3500);
        System.out.println(atomicRef.get());
    }

    public static class Account {
        public int count = 0;
    }
}

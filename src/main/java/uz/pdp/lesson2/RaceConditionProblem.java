package uz.pdp.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Created by: Mehrojbek
 DateTime: 04/01/25 20:29
 **/
public class RaceConditionProblem {

    private static Lock lock = new ReentrantLock();

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 500; i++) {

            Runnable runnable = () -> incrementCountWithLocker();

            Thread thread = new Thread(runnable);

            thread.start();

        }

        Thread.sleep(7000);

        System.err.println(count);

    }

    public static void incrementCountWithLocker() {
        try {

            System.out.println("sbdcjdhsbj");

            int i = 9 + 10;

            //qulfla
            lock.lock();

            Thread.sleep(3);

            //read
            int oldValue = count;

            //modify
            int newValue = oldValue + 1;

            //set
            count = newValue;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

        System.out.println("vaghcvgha");
        try {
            Thread.sleep(240);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //qulfdan och
    }

    public static void incrementCountSimple() {
        try {

            Thread.sleep(1);

            //read
            int oldValue = count;

            //modify
            int newValue = oldValue + 1;

            //set
            count = newValue;

            System.out.println("count: " + count);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

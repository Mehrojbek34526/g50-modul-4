package uz.pdp.lesson2;

import java.util.Random;

/**
 Created by: Mehrojbek
 DateTime: 07/01/25 19:13
 **/
public class FieldVisibilityProblem {

    public volatile boolean condition;

    public static void main(String[] args) throws InterruptedException {

        FieldVisibilityProblem problem = new FieldVisibilityProblem();
        problem.condition = true;

        Runnable task1 = () -> {

            while (problem.condition) {

            }
        };

        Thread thread1 = new Thread(task1);
        thread1.start();

        Thread.sleep(1000);

        problem.condition = false;

        System.out.println("Condition is : " + problem.condition);

    }

}

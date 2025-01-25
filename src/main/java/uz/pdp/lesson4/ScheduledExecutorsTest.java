package uz.pdp.lesson4;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 Created by: Mehrojbek
 DateTime: 09/01/25 21:14
 **/
public class ScheduledExecutorsTest {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);

        System.out.println("Started");
        Runnable runnable = () -> {
            System.out.print("\r" + new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
//        executorService.schedule(runnable, 2500, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
//        executorService.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.SECONDS);

//        executorService.shutdown();

//        while (true){
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println(new Date());
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }

}

package uz.pdp.lesson4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalTest1 {

    //    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {

        Runnable changePatternTask = () -> {
            for (int i = 0; i < 1000; i++) {
                simpleDateFormatThreadLocal.get().applyPattern("MM-dd-yyyy HH:mm:ss");
                simpleDateFormatThreadLocal.get().applyPattern("yyyy-MM-dd HH:mm:ss");
            }
        };

        Runnable formatDateTask = () -> {
            Date date = new Date();
            for (int i = 0; i < 1000; i++) {
                try {
                    ThreadLocalRandom current = ThreadLocalRandom.current();
                    System.out.println(simpleDateFormatThreadLocal.get().format(date));
                } catch (Exception e) {
                    System.err.println("Ошибка: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executorService.execute(changePatternTask);
            executorService.execute(formatDateTask);
        }

        executorService.shutdown();
    }
}
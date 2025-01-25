package uz.pdp.lesson4;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleClass {

    private static final Pattern dateCreateP = Pattern.compile("Дата подачи:\\s*(.+)");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        while (true) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    workConcurrently();
                }
            });
        }
    }

    public static void workConcurrently() {
        Matcher matcher = dateCreateP.matcher("Дата подачи: 19:30:55 03.05.2015");
        Timestamp startAdvDate = null;
        try {
            if (matcher.find()) {
                String dateCreate = matcher.group(1);
                startAdvDate = new Timestamp(sdf.parse(dateCreate).getTime());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        System.out.print("OK ");
    }
}

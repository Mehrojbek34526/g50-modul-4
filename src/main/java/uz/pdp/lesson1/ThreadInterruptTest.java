package uz.pdp.lesson1;

/**
 Created by: Mehrojbek
 DateTime: 28/12/24 21:00
 **/
public class ThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
//            try {
                for (int i = 0; i < 100_000; i++) {
                    System.out.println(i);
//                    Thread.sleep(0);
                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(200);
        thread.interrupt();
    }

}

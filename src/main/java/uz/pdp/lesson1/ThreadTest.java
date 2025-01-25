package uz.pdp.lesson1;

/**
 Created by: Mehrojbek
 DateTime: 28/12/24 19:40
 **/
public class ThreadTest {

    public  void hello(){
        System.out.println("hello");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread currentThread = Thread.currentThread();
//        System.out.println(currentThread);

        int activeCount = Thread.activeCount();
//        System.out.println(activeCount);

        Thread[] threads = new Thread[activeCount];
        Thread.enumerate(threads);

//        for (Thread thread : threads) {
//            System.out.println(thread);
//        }

//        MyThread myThread = new MyThread();
//        myThread.setName("MyThread");
//        myThread.start();
//        Thread.sleep(5);
//        System.out.println("main thread");

        //vazifa
//        MyRunnable myRunnable = new MyRunnable();
//
//        //ishchi
//        Thread thread = new Thread(myRunnable,"MyRunnable");
//
//        //ishchi ishingni qil
//        thread.start();

        Runnable runnable = () -> {
            System.out.println("Hello from MyRunnable : " + Thread.currentThread());
        };

        Thread thread = new Thread(runnable,"Bu mening ishchim");
        thread.start();

        //1. Thread yaratish Threaddan extend qilish orqali
        //2. Thread yaratish Runnableni implement qilish orqali

    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from MyThread : " + Thread.currentThread().getName());
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello from MyRunnable : " + Thread.currentThread().getName());
        }
    }

}

package uz.pdp.lesson1;


/**
 Created by: Mehrojbek
 DateTime: 28/12/24 21:16
 **/
public class DaemonThreadTest {

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            ThreadTest test = new ThreadTest();
            test.hello();
            method1();
            method2();
        }
    }

    public static void main(String[] args) throws InterruptedException {

//        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());

        RunnableImpl runnable = new RunnableImpl();
        RunnableImpl runnable2 = new RunnableImpl();

        Runnable task1 = () -> {
            ThreadTest test = new ThreadTest();
            test.hello();
            method1();
            method2();
        };
        Runnable task2 = () -> method2();

        Thread thread1 = new Thread(task1, "Thread1");
        Thread thread2 = new Thread(task2, "Thread2");

//        thread1.setDaemon(true);
//        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

//        Thread.sleep(2000);

        Thread thread = Thread.currentThread();
        System.out.println("Main method tugadi : " + thread.getName());

    }

    public static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.err.println("Uncaught exception in thread " + t.getName() + " : " + e.getMessage());
        }
    }

    //1. Card classi
    //fields :
    // cardNumber string
    // balance double
    // blocked boolean
    //1-carddan 2-cardga pul o'tkazsin

    //1-method: 1-cardni balanceni tekshiradi pul yetadimi? 1.5 sekund
    //2-method 2-cardni bloklanmaganligini tekshiradi 1.5 sekund
    //3-method transfer 1-dan pul chiqarib 2-ga qo'shish kerak 2.5 sekund

//    public static void pulOtkaz(Card fromCard, Card toCard, double amount) {
////        checkBlockCard(fromCard);//1.5s
////        checkBlockCard(toCard);//1.5s
////        checkBalance(fromCard,amount);//1.5s
//        //
//
//    }

    private static void method1() {

        throw new RuntimeException("Kutilmagan xatolik");

//        try {
//            Thread.sleep(2000);
//            System.out.println(Thread.currentThread().getName() + " : method1");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    private static void method2() {
        try {
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " : method2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

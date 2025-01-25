package uz.pdp.lesson1;

/**
 Created by: Mehrojbek
 DateTime: 28/12/24 20:39
 **/
public class ThreadMethodsExample {

    public static void main(String[] args) throws InterruptedException {

        long before = System.currentTimeMillis();

        Runnable task1 = () -> method1();
        Runnable task2 = () -> method2();

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();

        long currentTimeMillis = System.currentTimeMillis();
//        thread1.join();
//        System.out.println(thread1.getState());
//        thread1.join(1500);
        System.out.println("Pastga tushti dan keyin : " + (System.currentTimeMillis() - currentTimeMillis));

        thread2.start();

        System.out.println("Main thread end");

        long after = System.currentTimeMillis();
        System.out.println("Time taken: " + (after - before));

    }

    private static void method1() {
        try {
//            throw new RuntimeException("Method 1 to'xta");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " : method1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

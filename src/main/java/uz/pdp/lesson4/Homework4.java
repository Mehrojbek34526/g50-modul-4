package uz.pdp.lesson4;

import java.util.concurrent.*;

/**
 Created by: Mehrojbek
 DateTime: 12/01/25 10:34
 **/
public class Homework4 {


    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newWorkStealingPool();

        long begin = System.currentTimeMillis();

        User user = new User("User1");
        registerSingleThread(user);
        System.out.println("Time taken single: " + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        registerMultiThread(user);
        System.out.println("Time taken single: " + (System.currentTimeMillis() - begin));
    }

    private static void registerSingleThread(User user) {

        User savedUser = saveUser(user);
        String code = generateCode();
        boolean sent = sendInviteText("Xush kelibsiz");

        System.out.printf("User is : %s, code is :%s, sent is : %s%n", savedUser, code, sent);
    }

    private static void registerMultiThread(User user) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            Callable<User> savedUserCallable = () -> saveUser(user);
            Callable<String> genCodeCallable = () -> generateCode();
            Callable<Boolean> sentCallable = () -> sendInviteText("Xush kelibsiz");

            Future<User> savedUserFuture = executorService.submit(savedUserCallable);
            Future<String> genCodeFuture = executorService.submit(genCodeCallable);
            Future<Boolean> sentFuture = executorService.submit(sentCallable);

            User savedUser = savedUserFuture.get();
            String code = genCodeFuture.get();
            Boolean sent = sentFuture.get();
            System.out.printf("User is : %s, code is :%s, sent is : %s%n", savedUser, code, sent);
            executorService.shutdown();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean sendInviteText(String text) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(text);
        return true;
    }

    private static String generateCode() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "908785";
    }

    private static User saveUser(User user) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    public static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}

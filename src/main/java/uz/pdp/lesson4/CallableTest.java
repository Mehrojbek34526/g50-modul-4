package uz.pdp.lesson4;

import java.util.concurrent.*;

/**
 Created by: Mehrojbek
 DateTime: 09/01/25 20:32
 **/
public class CallableTest {


    public static void main(String[] args) {

        long begin = System.currentTimeMillis();
        transfer("86001", "98602", 40000);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

    }

    public static void transfer(String fromCard, String toCard, long amount) {

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(4);

            Callable<Boolean> validFromCardCallable = () -> cardCheck(fromCard);
            Callable<Boolean> validToCardCallable = () -> cardCheck(toCard);
            Callable<Boolean> checkedBalanceFromCardCallable = () -> checkBalance(fromCard, amount);

            Future<Boolean> validFromCardFuture = executorService.submit(validFromCardCallable);
            Future<Boolean> validToCardFuture = executorService.submit(validToCardCallable);
            Future<Boolean> checkedBalanceFromCardFuture = executorService.submit(checkedBalanceFromCardCallable);

//            Boolean validToCard = validToCardFuture.get();
            System.out.println(validToCardFuture.isDone());
            Boolean validToCard = validToCardFuture.get(2020, TimeUnit.MILLISECONDS);
            Boolean validFromCard = validFromCardFuture.get();
            Boolean checkedBalanceFromCard = checkedBalanceFromCardFuture.get();

//        boolean validFromCard = cardCheck(fromCard);
//        boolean validToCard = cardCheck(toCard);
//        boolean checkedBalanceFromCard = checkBalance(toCard, amount);

            if (validFromCard && validToCard && checkedBalanceFromCard) {

                System.out.println("Transactioning....");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Transaction completed.");
            } else {
                System.out.println("Transaction not completed.");
            }

            executorService.shutdown();

//            executorService.execute(() -> System.out.println("Done"));

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkBalance(String toCard, long amount) {
        try {
            System.out.println("Card balance checking..");
            Thread.sleep(2000);
            System.out.println("Card balance checked");
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean cardCheck(String number) {
        try {
            System.out.println("Card checking..");
            Thread.sleep(2000);
            System.out.println("Card checked");
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

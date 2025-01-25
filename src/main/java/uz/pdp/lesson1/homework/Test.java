package uz.pdp.lesson1.homework;

/**
 Created by: Mehrojbek
 DateTime: 04/01/25 20:03
 **/
public class Test {

    public static void main(String[] args) {

        Card from = new Card("86001", 1200L, false);
        Card to = new Card("86002", 300L, false);

        MoneyTransfer moneyTransfer = new MoneyTransfer();

        long begin = System.currentTimeMillis();

//        moneyTransfer.transfer(from, to, 200);
        moneyTransfer.transferMultiThread(from, to, 200);

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - begin));

    }

}

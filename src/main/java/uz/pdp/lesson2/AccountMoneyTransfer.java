package uz.pdp.lesson2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Created by: Mehrojbek
 DateTime: 04/01/25 21:24
 **/
public class AccountMoneyTransfer {

    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {


        Account account1 = new Account("John", 10);

        Account account2 = new Account("Bob", 20);

        Account account3 = new Account("Suzy", 50);

        Thread thread1 = new Thread(() -> transfer(account1, account2, 13L));
        thread1.start();

        Thread thread2 = new Thread(() -> transfer(account3, account1, 20));
        thread2.start();

        thread1.join();
        thread2.join();

    }

    private static void transfer(Account from, Account to, long amount) {

        while (from.getBalance() < amount) {
            System.out.println("Insufficient funds : " + from + " " + to);
            try {

                condition.await();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        System.out.println("Transfer successful" + from + " " + to);

        condition.notifyAll();

    }

}

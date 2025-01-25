package uz.pdp.lesson1.homework;

/**
 Created by: Mehrojbek
 DateTime: 04/01/25 19:59
 **/
public class MoneyTransfer {

    public void transfer(Card from, Card to, long amount) {

        checkBlock(from);
        checkBlock(to);
        isEnough(from, amount);

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        System.out.println("Successfull transfer");
    }

    public void transferMultiThread(Card from, Card to, long amount) {

        Thread t1 = new Thread(() -> checkBlock(from));
        t1.start();

        Thread t2 = new Thread(() -> checkBlock(to));
        t2.start();

        Thread t3 = new Thread(() -> isEnough(from, amount));
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        System.out.println("Successfull transfer");
    }

    public void checkBlock(Card card) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (card.isBlocked())
            throw new RuntimeException("%s is blocked".formatted(card));
    }

    public void isEnough(Card card, long amount) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (card.getBalance() < amount)
            throw new RuntimeException("%s is not enough".formatted(card));
    }

}

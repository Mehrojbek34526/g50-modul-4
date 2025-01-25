package uz.pdp.lesson2;

/**
 Created by: Mehrojbek
 DateTime: 04/01/25 21:23
 **/

public class Account {

    private String holder;

    private long balance;

    public Account(String holder, long balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}

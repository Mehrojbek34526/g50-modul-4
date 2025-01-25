package uz.pdp.lesson1.homework;

/**
 Created by: Mehrojbek
 DateTime: 04/01/25 19:58
 **/
public class Card {

    private String number;

    private long balance;
    private boolean blocked;

    public Card(String number, long balance, boolean blocked) {
        this.number = number;
        this.balance = balance;
        this.blocked = blocked;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", blocked=" + blocked +
                '}';
    }
}

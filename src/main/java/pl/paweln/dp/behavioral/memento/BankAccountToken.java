package pl.paweln.dp.behavioral.memento;

public class BankAccountToken {
    private int balance;

    public BankAccountToken(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }
}

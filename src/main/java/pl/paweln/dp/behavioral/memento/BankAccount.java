package pl.paweln.dp.behavioral.memento;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public BankAccountToken deposit(int amount) {
        this.balance += amount;
        return new BankAccountToken(this.balance);
    }

    public void restore(BankAccountToken token) {
        this.balance = token.getBalance();
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

package pl.paweln.dp.behavioral.nullobject;

public class BankAccount {
    private int balance;

    private Log log;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        this.balance += amount;
        this.log.info("Current balance is: " + this.balance);
    }

    public int getBalance() {
        return this.balance;
    }
}

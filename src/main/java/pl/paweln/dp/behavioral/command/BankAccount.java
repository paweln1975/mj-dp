package pl.paweln.dp.behavioral.command;

public class BankAccount {
    private int balance;
    private int overdraftLimit = - 500;

    public boolean deposit (int amount) {
        this.balance+=amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (this.balance - amount >= this.overdraftLimit) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}

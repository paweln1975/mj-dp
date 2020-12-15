package pl.paweln.dp.behavioral.command;

public class BankAccountCommand implements Command {
    public enum Action {
        DEPOSIT, WITHDRAW
    }

    private BankAccount account;
    boolean succeeded;

    @Override
    public void call() {
        switch (this.action) {
            case DEPOSIT:
                this.succeeded = account.deposit(this.amount);
                break;
            case WITHDRAW:
                this.succeeded = account.withdraw(this.amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!this.succeeded) return;
        switch (this.action) {
            case DEPOSIT:
                account.withdraw(this.amount);
                break;
            case WITHDRAW:
                account.deposit(this.amount);
                break;
        }
    }

    private Action action;
    private int amount;



    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }
}

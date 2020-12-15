package pl.paweln.dp.behavioral.command.exercise;

public class Account
{
    public int balance;

    public void process(Command c)
    {
        switch (c.action) {
            case DEPOSIT:
                this.balance += c.amount;
                c.success = true;
                break;
            case WITHDRAW:
                if (this.balance >= c.amount) {
                    this.balance -= c.amount;
                    c.success = true;
                } else
                    c.success = false;
                break;
        }
    }
}
package q3;
import q3.Account.*;
public class SavingAccount extends Account {
    private double interest = 0.05;
    private double withdrawLimit;
    private double minimumBalance = 1000;

    public SavingAccount(String name, int accountNumber, double accountBalance) {
        super(name, accountNumber, accountBalance);
        this.withdrawLimit = accountBalance - minimumBalance;
    }

    public double getBalance(double accountBalance) {
        return accountBalance + accountBalance * interest;
    }

    public double Withdraw(double amount) {
        if (amount <= withdrawLimit) {
            double ans = getBalance() - amount;
            setAccountBalance(ans);
        } else {
            System.out.println("sorry amount exceeded the limit");
        }
        System.out.println("the current balance is: ");
        return getAccountBalance();

    }

}


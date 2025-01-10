package q3;

public class CurrentAccount extends Account {
    private String tradeLicenseNumber;
    private int overdraft = 50;

    public CurrentAccount(String name, int accountNumber, double accountBalance, String tradeLicenseNumber) {
        super(name, accountNumber, accountBalance);
        this.tradeLicenseNumber = tradeLicenseNumber;
    }
    public double getBalance(){
        return getAccountBalance();
    }
    public double Withdraw(double amount) {
        double maxAmount = getAccountBalance()+overdraft;
        if (amount <= maxAmount) {
            double ans = overdraft+getAccountBalance() - amount;
            setAccountBalance(ans);
            System.out.println("amount withdrawn is:"+ amount);
        } else {
            System.out.println("sorry amount exceeded the limit");
        }
        System.out.println("the current balance is: "+getBalance());
        return getAccountBalance();

    }

}

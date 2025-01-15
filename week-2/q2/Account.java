public class Account {
    private int accountNumber;
    private double balance;
    //getter setter
    public Account(){}
    public Account(double amount){
        this.balance=amount;
    }
    public synchronized void addAmount(double amount) {
    this.balance+=amount;
        System.out.println("amount credited successfully and the balance is "+this.balance);
    }
    public synchronized void subtractAmount(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            System.out.println("amount debited successfully and the balance is " + this.balance);
        } else {
            System.out.println("insufficient balance" + Thread.currentThread().getName());
        }
    }

    public double getBalance() {
        return this.balance;
    }
}

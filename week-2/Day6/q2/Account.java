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
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }

        System.out.println("amount credited successfully and the balance is "+this.balance);
    }

    public synchronized void subtractAmount(double amount) {


            if (balance >= amount) {
                this.balance -= amount;
                System.out.println("amount debited successfully and the balance is " + this.balance);
            } else {
                System.out.println("insufficient balance" + Thread.currentThread().getName());
            }
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        }
Object lock = new Object();
    public void addAmountWithLock(double amount) {

        synchronized (lock) {
            this.balance += amount;
            System.out.println("amount credited successfully using lock and the balance is " + this.balance);
        }
    }
    public void subtractAmountWithLock(double amount){
        synchronized (lock){
            if(balance>=amount){
                this.balance-=amount;
                System.out.println("amount debited successfully using lock and the balance is "+this.balance);
            }
            else{
                System.out.println("insufficient balance");
            }
        }
    }

    public double getBalance() {
        return this.balance;
    }
}

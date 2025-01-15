public class BankWithLock implements Runnable{
    Account ac = new Account();
    public BankWithLock(Account ac) {
        this.ac = ac;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){

            ac.addAmountWithLock(1000);


        }
    }
}

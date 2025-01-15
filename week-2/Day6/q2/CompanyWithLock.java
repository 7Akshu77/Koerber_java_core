public class CompanyWithLock implements Runnable{
    Account ac = new Account();
    public CompanyWithLock(Account ac) {
        this.ac = ac;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){

            ac.subtractAmountWithLock(1000);


        }
    }
}

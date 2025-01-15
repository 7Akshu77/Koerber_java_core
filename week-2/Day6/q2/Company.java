public class Company implements Runnable {
    Account ac = new Account();
    public Company(Account ac) {
        this.ac = ac;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){

                ac.subtractAmount(1000);


        }
    }
}

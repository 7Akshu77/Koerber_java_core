public class Bank implements Runnable{
    Account ac = new Account();
    public Bank(Account ac) {
        this.ac = ac;
    }
    public void run() {
        for(int i=0;i<5;i++){

                ac.addAmount(1000);


        }
    }


}

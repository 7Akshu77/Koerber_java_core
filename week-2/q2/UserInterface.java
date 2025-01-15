public class UserInterface {

    public static void main(String[] args)  {
        Account ac = new Account(1000);
        Bank bank = new Bank(ac);
        Company company = new Company(ac);
        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(company);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ac.getBalance());
    }
}

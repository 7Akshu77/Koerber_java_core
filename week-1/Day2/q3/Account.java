package q3;

 class Account {
    private String name;
    private int accountNumber;
    private double accountBalance;
    public String getName(){
        return this.name;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.accountBalance;
    }

     public void setAccountBalance(double accountBalance) {
         this.accountBalance = accountBalance;
     }

     public Account(String name , int accountNumber, double accountBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    public void deposit(double amount){
        System.out.println("the amount deposited is:");
    }
}


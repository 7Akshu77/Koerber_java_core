package q3;

import java.util.Scanner;

public class q3tester {
    public static void main(String [] args){
        System.out.println("Enter the type of bank:");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
            if (type.equals("current")) {
                System.out.println("Enter account number:");
                int accno = sc.nextInt();
                System.out.println("Enter name:");
                String name = sc.next();
                System.out.println("Enter the amount:");
                double accountBalance = sc.nextDouble();
                System.out.println("Enter the trading licence number: ");
                String lnum = sc.next();
                CurrentAccount ac = new CurrentAccount(name, accno, accountBalance, lnum);
                System.out.println("To get the balance enter balance, to withdraw enter withdraw");
                String op = sc.next();
                if(op.equals("balance")){
                    System.out.println(ac.getBalance());
                }
                else if (op.equals("withdraw")){
                    System.out.println("enter the amount");
                    double withd = sc.nextDouble();
                    ac.Withdraw(withd);
                }
                else{
                    System.out.println("invalid");
                }

            } else if (type.equals("savings")) {
                System.out.println("Enter account number:");
                int accno = sc.nextInt();
                System.out.println("Enter name:");
                String name = sc.next();
                System.out.println("Enter the amount:");
                double accountBalance = sc.nextDouble();
                SavingAccount ac = new SavingAccount(name, accno, accountBalance);
                System.out.println("To get the balance enter balance, to withdraw enter withdraw");
                String op = sc.next();
                if(op.equals("balance")){
                    System.out.println(ac.getBalance());
                }
                else if (op.equals("withdraw")){
                    System.out.println("enter the amount");
                    double withd = sc.nextDouble();
                    ac.Withdraw(withd);
                }
                else{
                    System.out.println("invalid");
                }
            } else {
                System.out.println("invalid input");
        }

            }
        }


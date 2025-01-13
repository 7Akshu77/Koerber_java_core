package q6;

import java.util.Scanner;

public class AgeChecker {
    public static void main(String [] args){
//        try{
//            if(args.length !=2){
//                throw new NoProperArguments("Invalid Arguments given");
//            }
//        }
//        catch (NoProperArguments e){
//            System.out.println(e.getMessage());
//        }
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        try{
            int age = sc.nextInt();
            if(age<18 || age>60){
                throw new InvalidAge("Invalid Age entered");
            }
        } catch (InvalidAge e) {
            System.out.println(e.getMessage());
        }
    }
}

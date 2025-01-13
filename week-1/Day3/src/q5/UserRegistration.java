package q5;

import java.util.Scanner;

public class UserRegistration {
    public void registeredUser(String name , String countryName)throws InvalidCountryException{
        if(!"India".equalsIgnoreCase(countryName)){
            throw new InvalidCountryException("User Outside India cannot be registered");
        }
        else{
            System.out.println("Registration done successfully");
        }

    }
    public static void main(String [] args){
        UserRegistration u1 = new UserRegistration();
        UserRegistration u2 = new UserRegistration();
        try{
           u1.registeredUser("John","India");
            u2.registeredUser("Anna","UK");

        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage()) ;
        }

    }
}

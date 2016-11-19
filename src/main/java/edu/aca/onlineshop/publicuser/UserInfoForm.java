package edu.aca.onlineshop.publicuser;

import edu.aca.onlineshop.dao.UserDAO;
import edu.aca.onlineshop.delivery.cluster.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 *
 */
public class UserInfoForm {
    private static Scanner scanner = new Scanner(System.in);
    private UserProfile userProfile;
    @Autowired
    private UserDAO userDAO;
    
    public void createUser(){
        String firstName = collectFirstName();
        String lastName = collectLastName();
        String email = collectEmail();
        String password = collectPassword();
        Address address = collectAddress();
        this.userProfile = new UserProfile(firstName, lastName, email, password, address);
    }
    
    private String collectFirstName(){
        System.out.printf("Enter your first name:");
        return scanner.next();
    }
    private String collectLastName(){
        System.out.printf("Enter your last name:");
        return scanner.next();
    }
    private String collectEmail(){
        System.out.printf("Enter your email address:");
        String email = scanner.next();
        while(userDAO.getUser(email) != null){
            System.out.println("User already exists with this email");
            System.out.printf("Enter your email address:");
            email = scanner.next();
        }
        return email;
    }
    //probably switch to public to reset password
    private String collectPassword(){
        String p1;
        String p2;
        do{
            System.out.println("Enter your password:");
            p1 = scanner.next();
            System.out.println("Confirm your password:");
            p2 = scanner.next();
        } while(!p1.equals(p2));
        return p1;
    }
    public Address collectAddress(){
        System.out.printf("Enter your latitude:");
        double lat = scanner.nextDouble();
        System.out.println("Enter your longitude:");
        return new Address(lat, scanner.nextDouble());
    }
    
    public UserProfile getUserProfile(){
        return userProfile;
    }
}

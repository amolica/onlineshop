package edu.aca.onlineshop.ui;

import edu.aca.onlineshop.backoffice.admin.AdminSession;
import edu.aca.onlineshop.backoffice.user.*;
import edu.aca.onlineshop.publicuser.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 *
 */
public class UserInterface implements Runnable{
    private static Scanner scanner = new Scanner(System.in);
    
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserInfoForm userInfoForm;
    @Autowired
    private AdminSession adminSession;
    @Autowired
    private UserSession userSession;
    
    @Override
    public void run(){
        browser();
    }
    
    public void browser(){
        boolean quit = false;
        while(!quit){
            System.out.println("Welcome to FakeBrowser for console. Enter a web address or \"quit\" to quit");
            System.out.println("www.onlineshop.am/user OR www.onlineshop.am/admin");
            switch(scanner.next().toLowerCase()){
                case "1":
                case "www.onlineshop.am/user":
                    userHome();
                    break;
                case "2":
                case "www.onlineshop.am/admin":
                    adminHome();
                    break;
                case "3":
                case "quit": quit = true;break;
                default:
                    System.out.println("Invalid URL");
            }
        }
    }
    
    /*************************************USER METHODS*************************************/
    
    private void userHome(){
        boolean quit = false;
        while(!quit){
            System.out.println("Welcome to OnlineShop.\n\nLogin\nSign Up\nReturn to browser");
            switch(scanner.next().toLowerCase()){
                case "1":
                case "login":
                    userLogin();
                    break;
                case "2":
                case "sign up":
                    signUp();
                    break;
                case "3":
                case "return to browser":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    userHome();
            }
        }
    }
    
    private void userLogin(){
        while(true){
            System.out.print("Email: ");
            String email = scanner.next();
            if(email.equalsIgnoreCase("quit")){
                break;
            }
            System.out.print("Password: ");
            String password = scanner.next();
            User user = userDAO.getUser(email);
            if(user == null){
                System.out.println("User profile does not exist");
            }
            else if(password.equals(user.getPassword())){
                userSession.setUser(user);
                userSession.startUserSession();
            }
            else{
                System.out.println("Incorrect password. Try again.");
                System.out.println("Enter \"quit\" in email to return to home page.");
            }
        }
    }
    
    private void signUp(){
        userInfoForm.createUser();
        //pass new user to db
        User user = UserProfileConverter.convertToUser(userInfoForm.getUserProfile());
        userDAO.addUser(user);
        System.out.println("Thank you for signing up with OnlineShop");
        System.out.println("Redirecting to Login page\n");
        userLogin();
    }
    
    /*************************************ADMIN METHODS*************************************/
    
    public void adminHome(){
        boolean quit = false;
        while(!quit){
            System.out.println("OnlineShop Back Office\n\nLogin\nReturn to browser");
            switch(scanner.next().toLowerCase()){
                case "1":
                case "login":
                    adminLogin();
                    break;
                case "2":
                case "return to browser":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    
    //hardcoded for speed. Will update for multiple admins.
    private void adminLogin(){
        System.out.println("We hate security. Welcome to the Back Office.");
        adminSession.startAdminSession();
    }
}

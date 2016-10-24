package edu.aca.onlineshop.ui;

import edu.aca.onlineshop.backoffice.admin.AdminSession;
import edu.aca.onlineshop.backoffice.user.*;
import edu.aca.onlineshop.configuration.AppConfig;
import edu.aca.onlineshop.publicuser.UserInfoForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 *
 */
public class UserInterface{
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private static Scanner scanner = new Scanner(System.in);
    private UserDAO userDAO = (UserDAO) context.getBean("UserDAOImp", UserDAOImp.class);
    
    
    public void browser(){
        System.out.println("Welcome to FakeBrowser for console. Enter a web address.");
        System.out.println("www.onlineshop.am/user OR www.onlineshop.am/admin");
        switch(scanner.next().toLowerCase()){
            case "1":case "www.onlineshop.am/user": userHome();break;
            case "2":case "www.onlineshop.am/admin": adminHome();break;
            default:
                System.out.println("Invalid URL"); browser();
        }
        
    }
    
    /*************************************USER METHODS*************************************/
    
    private void userHome(){
        System.out.println("Welcome to OnlineShop.\n\nLogin\nSign Up\nReturn to browser");
        switch(scanner.next().toLowerCase()){
            case "1":case "login": userLogin();break;
            case "2":case "sign up": signUp();break;
            case "3":case "return to browser": browser();break;
            default:
                System.out.println("Invalid input"); userHome();
        }
    }
    
    private void userLogin(){
        System.out.print("Email: ");
        String email = scanner.next();
        if(email.equalsIgnoreCase("quit"))
            System.out.print("Password: ");
        String password = scanner.next();
        User user = userDAO.getUser(email);
        if(password.equals(user.getPassword())){
            UserSession userSession = new UserSession(user);
        } else{
            System.out.println("Incorrect password. Try again.");
            System.out.println("Enter \"quit\" in email to return to home page.");
            userLogin();
        }
    }
    
    private void signUp(){
        UserInfoForm userInfoForm = (UserInfoForm)context.getBean(UserInfoForm.class);
        userInfoForm.createUser();
        //pass new user to db
        User user = UserProfileConverter.convertToUser(userInfoForm.getUserProfile());
        userDAO.addUser(user);
        System.out.println("Thank you for signing up with OnlineShop");
        System.out.println("Redirecting to Login page\n");
        userLogin();
    }
    
    /*************************************ADMIN METHODS*************************************/
    
    private void adminHome(){
        System.out.println("OnlineShop Back Office\n\nLogin\nReturn to browser");
        switch(scanner.next().toLowerCase()){
            case "1":case "login": adminLogin();break;
            case "2":case "return to browser": browser();break;
            default:
                System.out.println("Invalid input"); adminHome();
        }
    }
    
    //hardcoded for speed. Will update for multiple admins.
    private void adminLogin(){
        System.out.println("We hate security. Welcome to the Back Office.");
        AdminSession adminSession = new AdminSession();
    }
}

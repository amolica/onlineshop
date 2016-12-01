package edu.aca.onlineshop.publicuser;

import edu.aca.onlineshop.dao.UserDAO;
import edu.aca.onlineshop.delivery.cluster.Address;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class UserInfoForm {
    private UserProfile userProfile;
    @Autowired
    private UserDAO userDAO;
    
    public void createUser(String firstName, String lastName, String email, String password, Address address){
        this.userProfile = new UserProfile(firstName, lastName, email, password, address);
    }
    
    public UserProfile getUserProfile(){
        return userProfile;
    }
}

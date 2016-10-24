package edu.aca.onlineshop.backoffice.user;

import edu.aca.onlineshop.publicuser.UserProfile;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 */
public class UserProfileConverter{
    
    public static User convertToUser(UserProfile userProfile){
        User user = new User();
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLasttName());
        user.setEmail(userProfile.getEmail());
        user.setPassword(userProfile.getPassword());
        user.setLatitude(userProfile.getAddress().getLatitude());
        user.setLongitude(userProfile.getAddress().getLongitude());
        //not set in public user
        user.setBalance(BigDecimal.ZERO);
        user.setLastLogin(Timestamp.from(Instant.now()));
        return user;
    }
}

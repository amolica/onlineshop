package edu.aca.onlineshop.dao;

import edu.aca.onlineshop.entity.User;

import java.util.List;

/**
 *
 */
public interface UserDAO{
    List<User> getUsers();
    User getUser(int id);
    User getUser(String email);
    void addUser(User user);
    void updatePassword(User user);
    void updateLastLogin(User user);
    void updateBalance(User user);
    void deleteUser(int id);
}

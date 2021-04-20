package org.project.cars.dao;

import org.project.cars.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    UserDetails loadUserByUsername(String username);
}


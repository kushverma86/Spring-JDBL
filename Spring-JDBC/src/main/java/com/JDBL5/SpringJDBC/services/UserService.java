package com.JDBL5.SpringJDBC.services;

import com.JDBL5.SpringJDBC.model.User;
import com.JDBL5.SpringJDBC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Map<String, User> getUsers() throws SQLException {
        List<User> users = userRepository.getAllUsers();
        Map<String, User> userMap = new HashMap<>();
        users.stream().forEach(user -> userMap.put(user.getId(), user));
        return userMap;
    }

    public User getUser(String id){
        return userRepository.getUser(id);
    }

    public void addUser(User user){
        userRepository.insertUser(user);
    }

    public void updateUser(User user){
        userRepository.updateUser(user);
    }

    public void deleteUser(String id){
        userRepository.deleteUser(id);
    }
}

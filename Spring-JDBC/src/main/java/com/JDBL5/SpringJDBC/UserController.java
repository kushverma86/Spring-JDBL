package com.JDBL5.SpringJDBC;

import com.JDBL5.SpringJDBC.model.User;
import com.JDBL5.SpringJDBC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Kush";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") String id){
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public Map<String, User> getUsers() throws SQLException {
        return userService.getUsers();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable(value = "id") String id){
        userService.deleteUser(id);
    }
}

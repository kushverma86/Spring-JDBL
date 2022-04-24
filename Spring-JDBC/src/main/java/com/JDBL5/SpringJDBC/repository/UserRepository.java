package com.JDBL5.SpringJDBC.repository;

import com.JDBL5.SpringJDBC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    public User getUser(String id){
        User user = null;
        Connection connection = DBManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user where userId = ?");
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String userId = result.getString(1);
                String name = result.getString(2);
                String email = result.getString(3);
                user = new User(userId, name, email);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void insertUser(User user){
        Connection connection = DBManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into user" +
                        "(userId, name,email) values (null, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.execute();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        deleteUser(user.getId());
        insertUser(user);
    }

    public void deleteUser(String id){
        Connection connection = DBManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from user where userId = ?");
            statement.setString(1, id);
            statement.execute();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = DBManager.getConnection();
        String sql = "select * from user";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            String userId = result.getString(1);
            String name = result.getString(2);
            String email = result.getString(3);
            userList.add(new User(userId, name, email));
        }
        return userList;
    }

    public static void main(String[] args) throws SQLException {
        UserRepository userRepository = new UserRepository();
        userRepository.getAllUsers();
    }
}

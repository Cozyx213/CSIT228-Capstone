package com.csit228.capstone.dao;

import java.sql.Connection;
import com.csit228.capstone.database.DBConnector;
import com.csit228.capstone.model.Member;
import com.csit228.capstone.model.Role;
import com.csit228.capstone.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> users;
    private List<String> types;

    private
    public void fetchTypes(){
        try(Connection connection = DBConnector.getConnection();

            Statement statement = connection.createStatement();
            ){

            ResultSet rs = statement.executeQuery("SELECT * FROM type ORDER id ASC");
            while(rs.next()){
                types.add(
                        rs.getInt("id") +" "+rs.getString("role")
                );
            }


        }catch( SQLException e){
            e.printStackTrace();
        }
    }

    //int userId, String firstname, String lastname, String username, String passwordHash, Role role
    public UserDao(){
        users = new ArrayList<>();
        users.add((User)new Member(1,"juan","delacruz","bayan","strongpass", Role.MEMBER));
    }


    public User getUserById(int id) {

        for(User u :  users){
            if(u.getUserId() == id){
                return u;
            }
        }
        return null;
    }

    public User fetchUsers(int id)  {
        try(Connection connection = DBConnector.getConnection()
           ;Statement statement = connection.createStatement();){

            ResultSet rs =statement.executeQuery("SELECT * FROM users");
            while(rs.next()){



                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("user_type")

                        ))
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

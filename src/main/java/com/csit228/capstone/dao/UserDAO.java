package com.csit228.capstone.dao;

import java.sql.Connection;
import com.csit228.capstone.database.DBConnector;
import com.csit228.capstone.model.Member;
import com.csit228.capstone.model.Role;
import com.csit228.capstone.model.User;
import com.csit228.capstone.model.UserFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;
    private static  List<String> types;

    public static Role getType(int id){
        fetchTypes();
        for(String s : types){
            String[] res = s.split(" ");
            if(Integer.parseInt(res[0])==id){
                return Role.valueOf(res[1].toUpperCase());
            }
        }
        return null;
    }

    public static void fetchTypes(){
        types = new ArrayList<>();
        try(Connection connection = DBConnector.getConnection();

            Statement statement = connection.createStatement();
            ){

            ResultSet rs = statement.executeQuery("SELECT * FROM type  ORDER BY id ASC");
            while(rs.next()){
                types.add(
                        rs.getInt("id") +" "+rs.getString("role")
                );
            }


        }catch( SQLException e){
            e.printStackTrace();
        }
    }

    //int userId, String firstname, String lastname, String username, String passwordHash, Role
    public UserDAO(){
        users = new ArrayList<>();
        users.add((User)new Member(1,"juan","delacruz","bayan","strongpass",1));
    }


    public User getUserById(int id) {
        if(users==null){
            fetchUsers();
        }

        for(User u :  users){
            if(u.getUserId() == id){
                return u;
            }
        }
        return null;
    }
    public User getUserByDepartment(int id) {
        if(users==null){
            fetchUsers();
        }
        for(User u :  users){
            if(u.getDepartment_id()== id){
                return u;
            }
        }
        return null;
    }



    public static void fetchUsers()  {
        users = new ArrayList<>();
        try(Connection connection = DBConnector.getConnection()
           ;Statement statement = connection.createStatement();){

            ResultSet rs =statement.executeQuery("SELECT * FROM user");
            while(rs.next()){

                Role role = getType(rs.getInt("user_type"));
                User curr = UserFactory.createUser(
                        role,
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password_hash"),
                        rs.getString("lastname"),

                        rs.getInt("department_id")


                        );
                users.add(curr);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Role r= getType(2);
        System.out.println(r);
        fetchUsers();

        for (User u : users){
            System.out.println(u);
            System.out.println(u.getRole());;
        }
    }
}

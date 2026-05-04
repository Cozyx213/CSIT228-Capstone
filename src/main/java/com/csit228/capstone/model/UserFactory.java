package com.csit228.capstone.model;

public class UserFactory {

    public User createUser(String type,int userId, String firstname, String lastname, String username, String passwordHash, Role role){
        if(type.equals("member")){
            return new Member(userId,firstname,lastname,username,passwordHash,role);
        }else if(type.equals("executive")){
            return new Executive(userId,firstname,lastname,username,passwordHash,role);
        }else{
            return new Editor(userId,firstname,lastname,username,passwordHash,role);
        }
    }
}

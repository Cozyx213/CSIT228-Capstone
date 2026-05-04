package com.csit228.capstone.model;

import java.io.Serializable;

public abstract class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userId;
    private String firstname;
    private String lastname;
    private String username;
    private transient String passwordHash;
    private Role role;

    public User() {
    }

    public User(int userId, String firstname, String lastname, String username, String passwordHash, Role role) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public void viewDashboard() {
        // TO DO
    }

    public void viewProfile() {
        // TO DO
    }

    public Role getRole() {
        return role;
    }

    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
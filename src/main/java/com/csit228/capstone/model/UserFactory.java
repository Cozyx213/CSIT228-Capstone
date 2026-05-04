package com.csit228.capstone.model;

public class UserFactory {

    private UserFactory() {
    }

    public static User createUser(Role role, int userId, String firstName, String lastName,
                                  String username, String passwordHash) {
        if (role == null) {
            return null;
        }

        switch (role) {
            case EXECUTIVE:
                return new Executive(userId, firstName, lastName, username, passwordHash);
            case EDITOR:
                return new Editor(userId, firstName, lastName, username, passwordHash);
            case MEMBER:
                return new Member(userId, firstName, lastName, username, passwordHash);
            default:
                return null;
        }
    }
}
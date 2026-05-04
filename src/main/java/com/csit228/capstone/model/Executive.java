package com.csit228.capstone.model;

public class Executive extends User {

    public Executive() {
        setRole(Role.EXECUTIVE);
    }

    public Executive(int userId, String firstname, String lastname, String username, String passwordHash, Role role) {
        super(userId, firstname, lastname, username, passwordHash, role);
    }

    public boolean createTicket(Ticket t) {
        // TO DO: pass ticket to TicketDAO once TicketDAO is created
        return false;
    }

    public boolean assignTicket(Ticket t, Member m) {
        if (t == null || m == null) {
            return false;
        }

        t.assignTo(m);
        return true;
    }

    public void manageUsers() {
        // TO DO: connect this to user management screen or UserDAO
    }

    public void viewAnalytics() {
        // TO DO: connect this to dashboard analytics
    }

    public void sendNotification(Notification n) {
        // TO DO: implement once Notification class is created
    }
}

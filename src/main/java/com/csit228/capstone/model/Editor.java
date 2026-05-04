package com.csit228.capstone.model;

public class Editor extends User {

    public Editor() {
        setRole(Role.EDITOR);
    }

    public Editor(int userId, String firstname, String lastname, String username, String passwordHash, Role role) {
        super(userId, firstname, lastname, username, passwordHash, role);
    }

    public boolean editTicket(Ticket t) {
        // TO DO: update ticket details once TicketDAO or controller logic is created
        return false;
    }

    public boolean updateTicketStatus(Ticket t, TicketStatus status) {
        if (t == null || status == null) {
            return false;
        }

        t.setStatus(status);
        return true;
    }

    public void reviewTicket(Ticket t) {
        // TO DO: implement ticket review logic
    }

    public void notifyMember(Member m) {
        // TO DO: implement once Notification class is created
    }
}

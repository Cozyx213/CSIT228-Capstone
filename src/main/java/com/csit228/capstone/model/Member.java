package com.csit228.capstone.model;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {


    public Member() {
        setRole(Role.MEMBER);
    }

    public Member(int userId, String firstname, String lastname, String username, String passwordHash, Role role) {
        super(userId, firstname, lastname, username, passwordHash, role);
    }

    public void viewVolunteerBoard() {
        // TO DO: connect this to VolunteerBoardController or VolunteerBoard screen
    }

    public boolean volunteerForTicket(Ticket t) {
        // TO DO: connect this to VolunteerManager later
        return false;
    }

    public List<Ticket> viewMyTasks() {
        // TO DO: return tickets assigned to this member from TicketDAO
        return new ArrayList<>();
    }

    public boolean updateTaskStatus(Ticket t) {
        // TO DO: update the status of a task assigned to this member
        return false;
    }

    public void receiveNotification(Notification n) {
        // TO DO: implement once Notification class is created
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}

package com.csit228.capstone.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ticketId;
    private String title;
    private String description;
    private String category;
    private TicketPriority priority;
    private LocalDate deadline;
    private TicketStatus status;
    private User createdBy;
    private Member assignedTo;

    public Ticket() {
        this.status = TicketStatus.OPEN;
    }

    public Ticket(
            int ticketId,
            String title,
            String description,
            String category,
            TicketPriority priority,
            LocalDate deadline,
            TicketStatus status,
            User createdBy,
            Member assignedTo
    ) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
    }

    public TicketMemento createMemento() {
        // TO DO: create and return TicketMemento once TicketMemento class is created
        return null;
    }

    public void restore(TicketMemento m) {
        // TO DO: restore ticket fields from TicketMemento once TicketMemento class is created
    }

    public void assignTo(Member m) {
        this.assignedTo = m;

        if (m != null) {
            this.status = TicketStatus.IN_PROGRESS;
        }
    }

    public void markInProgress() {
        this.status = TicketStatus.IN_PROGRESS;
    }

    public void resolve() {
        this.status = TicketStatus.RESOLVED;
    }

    public void addAttachment(Attachment a) {
        // TO DO: implement once Attachment class is created
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return;
        }

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        if (status == null) {
            return;
        }

        this.status = status;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Member getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Member assignedTo) {
        this.assignedTo = assignedTo;
    }
}

# TIX.org

### Group Members:
+ Bajenting, Jake
+ Endrina, Arth
+ Gabison, Joshua
+ Horigome, Ken
+ Tagalog, Prince Darens

---
### Product Description:
Tix.org is a ticketing system that allows organizations to create, assign, and update tasks all in one centralized platform. It aims to boost organizational productivity through collaborative works by assigning or self-assigning tickets or tasks to which in turn promotes voluntarism between members.

---
### Proposed Features:

| **Feature** | **Description** |
| :--- | :--- | 
| **Ticket Management** | Allows for creation, reading and updating as well as resolution of tickets shared across users.  |
| **Volunteer Board** | Acts as a centralized platform where members can self-assign or volunteer to tasks to boost organizational productivity. |
| **Role-Based Dashboards** | Each member has a dedicated view based on their organizational roles. Executives or people who overlook would have a more extensive dashboard view as to members under their care. |
| **Visual Analytics** | Shows an updated view of the progress such as completed vs pending tasks, or number of on-going works. |
| **Priority Alerts** | Acts as a notification system for upcoming deadlines of tickets. |

---
### Planned Technologies
+ Java
+ JavaFX
+ JDBC
+ Database (MySQL)

---
### Evaluation Criteria Mapping
#### 1.OOP: Planned use of classes such as:
+ **User** - holds user’s ID, username, passwords
+ **Heads & Members** - subclasses of parent class User, with its respective behaviors
+ **Tickets** - encapsulates data with regards to the ticket such as ID, description and etc.
+ **DatabaseManager** - handles all JDBC operations.

#### 2.GUI: JavaFX with FXML view:
+ **Main Dashboard** - shows a centralized view of Ticket Management, Volunteer Board and other information
+ **My View** - shows all assigned tickets, on-going as well as pending tasks. Holds all “productivity” information in response to own tasks.
+ **Navigation Bar** - allows for quick switching between such as “My Task,” “Volunteer Board,” “Profile,” and “Settings.”
+ **Modals** - shows extra information such as confirmation dialogs, extended descriptions along with other supplementary data.

#### 3.UML: Use Case and Class Diagram included:
# Joshua & Prince kamo explain dri! Place here what you guys did for the Diagrams such as the actors and such

#### 4.Design Pattern: (Tentative)
+ **Singleton** - Centralized connection point for MySQL Database
+ **Factory**  - Creation of Users based on type
# Mao pa ako mahuna-huna







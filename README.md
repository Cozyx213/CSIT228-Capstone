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
### Implemented Features:

| **Feature** | **Description** |
| :--- | :--- | 
| **Ticket Management** | Full creation, reading, updating, and resolution of tickets. Tickets carry a title, description, priority (LOW, MEDIUM, HIGH), deadline, and status (OPEN, IN_PROGRESS, COMPLETED, RESOLVED). |
| **Volunteer Board** | Members can self-assign or volunteer for open tickets through the Member dashboard's ticket view. |
| **Role-Based Dashboards** | Three distinct dashboards are rendered at login based on the user's role: `DashboardExecutiveView`, `DashboardEditorView`, and `DashboardMemberView`. Executives have the widest view including department and user management. |
| **Notification System** | An Observer-based notification system dispatches real-time alerts to users on ticket and comment events. Notifications are stored in the database and marked as read/unread per user. |
| **Comment System** | Users can post comments on individual tickets. Comment activity triggers observer notifications to relevant users. |
| **Department Management** | Executives can create and manage departments and assign jobs to members within those departments. |
| **User Management** | Executives can view, manage, and assign roles to users. Admins can also create and edit job entries per department. |
| **Session Persistence** | User sessions are serialized to `user.ser` on login and deserialized on app restart so users remain logged in across sessions. |

---
### Technologies Used
+ Java 21
+ JavaFX (FXML)
+ JDBC
+ MySQL
+ Maven

---
### Evaluation Criteria Mapping
#### 1. OOP: Implemented classes include:
+ **User** *(abstract)* - holds `userId`, `firstName`, `lastName`, `username`, `passwordHash`, `role`, and `departmentId`
+ **Executive, Editor, Member** - concrete subclasses of `User`, each mapped to a specific role and dashboard
+ **Ticket** - encapsulates `ticketId`, `title`, `description`, `priority`, `status`, `deadline`, `assignedTo`, and `createdBy`
+ **TicketView** - a flattened read model used for list rendering in the UI
+ **Comment** - holds `commentId`, `ticketId`, `userId`, `message`, and `createdAt`
+ **Notification** - holds `notificationId`, `title`, `message`, `read`, `createdAt`, and `userId`
+ **Department / Job** - represent organizational structure
+ **DBConnector** - handles all JDBC connections; credentials are loaded from `.env`
+ **UserFactory** - creates `User` subclass instances based on `Role` enum

#### 2. GUI: JavaFX with FXML views:
+ **LoginView.fxml** - initial login screen for user authentication
+ **RegisterView.fxml** - registration screen for new users
+ **DashboardExecutiveView.fxml** - executive overview with ticket, department, and user management
+ **DashboardEditorView.fxml** - editor-focused ticket dashboard
+ **DashboardMemberView.fxml** - member dashboard with volunteer board and assigned tasks
+ **StaffTicketView.fxml** - ticket list for staff-level ticket browsing
+ **BaseTicketDetailModalView.fxml** - single unified modal for rendering ticket details, shared across all roles
+ **CreateTicketModalExecView.fxml / CreateTicketModalEditorView.fxml** - ticket creation forms per role
+ **DepartmentExecutiveView.fxml** - department management for executives
+ **ManageUserExecutive.fxml** - user management panel for executives
+ **ProfileView.fxml** - user profile viewer and editor
+ **ViewDepartment.fxml / ViewMembers.fxml / ViewUser.fxml** - modals for viewing department, member, and user details
+ **CreateDepartmentModal.fxml / CreateJobModal.fxml** - modals for creating departments and job entries

#### Running the JavaFX app in IntelliJ
To avoid the error `The JavaFX runtime is not configured...`, run the project through Maven instead of using a plain Java `main()` run configuration.

1. Use a JDK that matches the project source level (`Java 21`).
2. In IntelliJ, import the project as a Maven project so dependencies are resolved automatically.
   - If IntelliJ still shows the JavaFX runtime warning, right-click `pom.xml` and choose **Add as Maven Project**.
3. Configure the `.env` file in the project root with three lines: the JDBC URL, database username, and database password.
4. Run the Maven goal `javafx:run`.
5. The application starts from `com.csit228.capstone.application.MainApplication`, which loads a saved session (if present) and opens the appropriate dashboard, or falls back to `LoginView.fxml`.

#### 3. UML: Use Case and Class Diagram included in `/diagrams`:
The **Use Case Diagram** (`diagrams/use-case-diagram.png`) presents the main interactions within the TIX.org system through three primary actors: Executive, Editor, and Member. The Executive is associated with functions such as logging in, viewing the dashboard, creating and assigning tickets, managing departments, managing users, and receiving notifications. The Editor is associated with creating and editing tickets from a focused dashboard view. The Member is associated with logging in, viewing the dashboard, volunteering for tickets, viewing assigned tasks, and receiving priority alerts.

The **Class Diagram** (`diagrams/class-diagram.png`) presents the structural design of the system. The abstract `User` class serves as the parent containing shared attributes, while `Executive`, `Editor`, and `Member` are concrete subclasses with role-specific behaviors. The `Ticket` class contains the core task-related data including title, description, priority, deadline, and status. Supporting classes such as `NotificationManager`, `CommentDAO`, `TicketDAO`, `UserDAO`, `DepartmentDAO`, `JobDAO`, `NotificationDAO`, and `UserJobDAO` handle all database access. Observer interfaces `NotificationObserver`, `TicketObserver`, and `CommentObserver` are implemented by watchers to drive real-time updates. `UserFactory` and `AppSession` support object creation and session management.

These diagrams reflect the overall functionality and structure of TIX.org in relation to ticket management, volunteer participation, monitoring of tasks, and role-based system access.

#### 4. Design Patterns Implemented:
+ **Singleton** - `DBConnector` uses a synchronized `ensureEnvLoaded()` guard to ensure database credentials from `.env` are only loaded once across the application's lifetime, making it the single centralized connection point for all MySQL operations.
+ **Factory** - `UserFactory.createUser(Role, ...)` instantiates the correct `User` subclass (`Executive`, `Editor`, or `Member`) based on the `Role` enum
+ **Observer** - `NotificationWatcher`, `TicketWatcher`, and `CommentWatcher` extend `BaseWatcher` and implement observer interfaces (`NotificationObserver`, `TicketObserver`, `CommentObserver`) to push real-time updates to subscribed controllers
+ **Composite UI / Strategy** - `BaseTicketDetailModalView.fxml` is a single shared modal for rendering ticket details across all roles. The `BaseTicketDetailModalController` is subclassed per role (e.g., `TicketDetailModelController`) which configures the view's behavior at runtime, avoiding separate FXML files per role or ticket state

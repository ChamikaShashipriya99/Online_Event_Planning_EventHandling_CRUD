# Online Event Planning System

## Description
A web application for managing events. Users can create, view, update, and delete event listings.

## Features
- **Create Events:** Add new events with details such as name, date, time, venue, ticket price, and event type.
- **View Events:** Display a list of all upcoming and past events.
- **Update Events:** Modify the details of existing events.
- **Delete Events:** Remove events from the system.

## Technologies Used
- **Backend:** Java, Servlets
- **Frontend:** JSP, HTML, CSS
- **Database:** MySQL
- **Server:** Apache Tomcat (or any Servlet-compatible container)

## Setup Instructions

### 1. Database Setup
   - Ensure you have MySQL installed and running.
   - Create a database named `online_event_planning_system`.
     ```sql
     CREATE DATABASE online_event_planning_system;
     ```
   - Use the created database.
     ```sql
     USE online_event_planning_system;
     ```
   - Import the schema and initial data from the `online_event_planning_system_DB.sql` file provided in the project root.
     ```bash
     mysql -u your_username -p online_event_planning_system < online_event_planning_system_DB.sql
     ```
     (Replace `your_username` with your MySQL username)
   - **Important:** Verify and update the database connection details if necessary. These can be found in `src/main/java/util/DBUtil.java`. The default credentials are:
     - **Username:** `root`
     - **Password:** `Chamika1999`
     You might need to change the username, password, and JDBC URL according to your local MySQL setup.

### 2. Project Build
   - This project is typically built using a Java IDE (like Eclipse, IntelliJ IDEA) that supports Maven or Gradle, or it can be compiled manually.
   - If using an IDE, import the project and build it to produce a `.war` (Web Application Archive) file.
   - Ensure all dependencies specified (e.g., Servlet API, JDBC driver for MySQL) are correctly included in the build. The `.classpath` and `.project` files suggest an Eclipse setup.

### 3. Deployment
   - Deploy the generated `.war` file to your Apache Tomcat server (or any other Java Servlet container).
   - This is usually done by copying the `.war` file to the `webapps` directory of your Tomcat installation.
   - Tomcat will automatically deploy the application.

## How to Run
1.  **Start your MySQL server.**
2.  **Start your Apache Tomcat server** (or other Servlet container).
3.  **Access the application** in your web browser. The default URL will typically be `http://localhost:8080/your-project-context-path/`. The `your-project-context-path` is the name of the deployed `.war` file (e.g., `online-event-planning-system`) or as configured in your server/IDE.
    - To see the list of events, navigate to: `http://localhost:8080/your-project-context-path/event?action=list`
    - To add a new event, you can start from the event list page which should have a link/button to the event creation form (`eventForm.jsp`).
    - The application allows for editing and deleting events directly from the event list.

Remember to replace `your-project-context-path` with the actual context path of your deployed application.

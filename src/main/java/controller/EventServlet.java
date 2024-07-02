package controller;

import dao.EventDAO;
import model.Event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/event")
public class EventServlet extends HttpServlet {
    private EventDAO eventDAO;

    public void init() {
        eventDAO = new EventDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Default action
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertEvent(request, response);
                    break;
                case "delete":
                    deleteEvent(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateEvent(request, response);
                    break;
                default:
                    listEvents(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEvents(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Event> events = eventDAO.getAllEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("eventList.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("eventForm.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam); // Ensure the id is correctly parsed
            Event existingEvent = eventDAO.getEventById(id);
            request.setAttribute("event", existingEvent);
            request.getRequestDispatcher("EditForm.jsp").forward(request, response); // Ensure this points to the correct JSP
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Event ID is required for editing.");
        }
    }

    private void insertEvent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String eventName = request.getParameter("eventName");
        Date eventDate = Date.valueOf(request.getParameter("eventDate"));
        String eventTimeStr = request.getParameter("eventTime"); // Get the event time as a String
        Time eventTime;

        // Check if the eventTimeStr is not null or empty
        if (eventTimeStr != null && !eventTimeStr.isEmpty()) {
            try {
                // Format the time string to HH:MM:SS
                eventTime = Time.valueOf(eventTimeStr + ":00"); // Append ':00' for seconds
            } catch (IllegalArgumentException e) {
                request.setAttribute("message", "Invalid time format. Please use HH:MM:SS.");
                showNewForm(request, response); // Show the form again with an error message
                return; // Exit the method
            }
        } else {
            request.setAttribute("message", "Event time cannot be empty.");
            showNewForm(request, response); // Show the form again with an error message
            return; // Exit the method
        }

        String venue = request.getParameter("venue");
        double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));
        String eventType = request.getParameter("eventType");

        Event newEvent = new Event(eventName, eventDate, eventTime, venue, ticketPrice, eventType);

        try {
            eventDAO.addEvent(newEvent);
            request.setAttribute("message", "Event added successfully!");
        } catch (SQLException e) {
            e.printStackTrace(); // Print to server logs
            request.setAttribute("message", "Error adding event: " + e.getMessage());
            showNewForm(request, response); // Show the form again with an error message
            return; // Exit the method
        }

        listEvents(request, response); // Redirect to list events after successful addition
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id")); // Ensure the id is correctly parsed
        String eventName = request.getParameter("eventName");
        Date eventDate = Date.valueOf(request.getParameter("eventDate"));
        String eventTimeStr = request.getParameter("eventTime"); // Get the event time as a String
        Time eventTime;

        // Handle the conversion of the event time string to Time
        if (eventTimeStr != null && !eventTimeStr.isEmpty()) {
            try {
                // Append ":00" to convert HH:MM to HH:MM:SS
                eventTime = Time.valueOf(eventTimeStr + ":00");
            } catch (IllegalArgumentException e) {
                request.setAttribute("message", "Invalid time format. Please use HH:MM:SS.");
                showEditForm(request, response); // Show the form again with an error message
                return; // Exit the method
            }
        } else {
            request.setAttribute("message", "Event time cannot be empty.");
            showEditForm(request, response); // Show the form again with an error message
            return; // Exit the method
        }

        String venue = request.getParameter("venue");
        double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));
        String eventType = request.getParameter("eventType");

        Event event = new Event(eventName, eventDate, eventTime, venue, ticketPrice, eventType);
        event.setId(id); // Set the ID for updating the correct event
        eventDAO.updateEvent(event);
        request.setAttribute("message", "Event updated successfully!");

        // Redirect to the list events page
        listEvents(request, response); // This should refresh the event list after the update
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam); // Ensure the id is correctly parsed
            eventDAO.deleteEvent(id);
            request.setAttribute("message", "Event deleted successfully!");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Event ID is required for deletion.");
            return; // Stop further execution
        }
        listEvents(request, response); // Redirect to the list events page after deletion
    }
}

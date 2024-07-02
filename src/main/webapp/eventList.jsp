<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Event List</h2>
        
        <%-- Display success message if exists --%>
        <c:if test="${not empty message}">
            <div class="alert alert-success">
                ${message}
            </div>
        </c:if>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Event Name</th>
                    <th>Event Date</th>
                    <th>Event Time</th>
                    <th>Venue</th>
                    <th>Ticket Price</th>
                    <th>Event Type</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.eventName}</td>
                        <td>${event.eventDate}</td>
                        <td>${event.eventTime}</td>
                        <td>${event.venue}</td>
                        <td>${event.ticketPrice}</td>
                        <td>${event.eventType}</td>
                        <td>
                            <form action="event" method="post" style="display:inline;">
							    <input type="hidden" name="id" value="${event.id}">
							    <button type="submit" name="action" value="edit" class="btn btn-warning">Edit</button>
							</form>
                            <form action="event" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="${event.id}">
                                <button type="submit" name="action" value="delete" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this event?');">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="event?action=new" class="btn btn-success">Add New Event</a>
    </div>
</body>
</html>

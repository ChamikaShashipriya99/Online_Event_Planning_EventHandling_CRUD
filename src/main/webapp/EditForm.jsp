<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Event</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Edit Event</h2>
        
        <%-- Display message if it exists --%>
        <c:if test="${not empty message}">
            <div class="alert alert-info">${message}</div>
        </c:if>
        
        <form action="event?action=update" method="post">
            <input type="hidden" name="id" value="${event.id}">
            <div class="form-group">
                <label for="eventName">Event Name</label>
                <input type="text" class="form-control" name="eventName" value="${event.eventName}" required>
            </div>
            <div class="form-group">
                <label for="eventDate">Event Date</label>
                <input type="date" class="form-control" name="eventDate" value="${event.eventDate}" required>
            </div>
            <div class="form-group">
                <label for="eventTime">Event Time</label>
                <input type="time" class="form-control" name="eventTime" value="${event.eventTime.toLocalTime().toString().substring(0, 5)}" required>
            </div>
            <div class="form-group">
                <label for="venue">Venue</label>
                <input type="text" class="form-control" name="venue" value="${event.venue}" required>
            </div>
            <div class="form-group">
                <label for="ticketPrice">Ticket Price</label>
                <input type="number" step="0.01" class="form-control" name="ticketPrice" value="${event.ticketPrice}" required>
            </div>
            <div class="form-group">
                <label for="eventType">Event Type</label>
                <input type="text" class="form-control" name="eventType" value="${event.eventType}" required>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="event" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
    
    <br><br>
</body>
</html>

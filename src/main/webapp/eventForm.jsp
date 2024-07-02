<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="navbar.jsp" />
    
    <br>
    
    <div class="container mt-5">
        <h2 class="text-center">Add New Event</h2>
        
        <!-- Display message -->
        <c:if test="${not empty message}">
            <div class="alert alert-info">${message}</div>
        </c:if>
        
        <form action="event?action=insert" method="post" class="mt-4">
            <div class="form-group">
                <label for="eventName">Event Name:</label>
                <input type="text" name="eventName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="eventDate">Event Date:</label>
                <input type="date" name="eventDate" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="eventTime">Event Time:</label>
                <input type="time" name="eventTime" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="venue">Venue:</label>
                <input type="text" name="venue" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="ticketPrice">Ticket Price:</label>
                <input type="number" name="ticketPrice" class="form-control" step="0.01" min="0" required>
            </div>
            <div class="form-group">
                <label for="eventType">Event Type:</label>
                <select name="eventType" class="form-control" required>
                	<option value="None">None</option>
                    <option value="Wedding">Wedding</option>
                    <option value="Engagement">Engagement</option>
                    <option value="Musical Concert">Musical Concert</option>
                    <option value="Movie">Movie</option>
                    <option value="Party">Party</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="event?action=list" class="btn btn-secondary">View Details</a>
        </form>
    </div>
    
    <br>

    <jsp:include page="footer.jsp" />
    
    <!-- JavaScript for validation -->
    <script>
        function validateForm() {
            // Get form values
            var eventName = document.forms["eventForm"]["eventName"].value;
            var eventDate = document.forms["eventForm"]["eventDate"].value;
            var eventTime = document.forms["eventForm"]["eventTime"].value;
            var venue = document.forms["eventForm"]["venue"].value;
            var ticketPrice = document.forms["eventForm"]["ticketPrice"].value;
            var eventType = document.forms["eventForm"]["eventType"].value;

            // Validate that all fields are filled
            if (eventName == "" || eventDate == "" || eventTime == "" || venue == "" || ticketPrice == "" || eventType == "None") {
                alert("Please fill out all fields and select an event type.");
                return false;
            }

            // Validate ticket price (must be a positive number)
            if (ticketPrice <= 0) {
                alert("Ticket price must be a positive value.");
                return false;
            }

            // Validate that event date is not in the past
            var currentDate = new Date().toISOString().split('T')[0]; // Get today's date in YYYY-MM-DD format
            if (eventDate < currentDate) {
                alert("Event date cannot be in the past.");
                return false;
            }

            return true; // Form is valid
        }
    </script>
</body>
</html>
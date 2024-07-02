<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Planning System - Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <jsp:include page="navbar.jsp" />
    
    <br>

    <div class="container mt-5">
        <h1 class="text-center mb-4">Welcome to Event Planning System</h1>
        
        <div class="row mb-4">
            <div class="col-md-4">
                <img src="images/event1.jpg" alt="Event 1" class="img-fluid">
            </div>
            <div class="col-md-4">
                <img src="images/event2.jpg" alt="Event 2" class="img-fluid">
            </div>
            <div class="col-md-4">
                <img src="images/event3.jpg" alt="Event 3" class="img-fluid">
            </div>
        </div>
        
        <div class="text-center">
            <a href="eventForm.jsp" class="btn btn-primary btn-lg">Add Event Here</a>
        </div>
        
        <br>
        
        <div class="row mb-4">
            <div class="col-md-4">
                <img src="images/event5.jpg" alt="Event 1" class="img-fluid">
            </div>
            <div class="col-md-4">
                <img src="images/event4.jpg" alt="Event 2" class="img-fluid">
            </div>
            <div class="col-md-4">
                <img src="images/event6.jpg" alt="Event 3" class="img-fluid">
            </div>
        </div>
        
    </div>

    <jsp:include page="footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
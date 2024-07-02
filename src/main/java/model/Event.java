package model;

import java.sql.Date;
import java.sql.Time;

public class Event {
    private int id;
    private String eventName;
    private Date eventDate;
    private Time eventTime;
    private String venue;
    private double ticketPrice;
    private String eventType;

    public Event() {}

    public Event(String eventName, Date eventDate, Time eventTime, String venue, double ticketPrice, String eventType) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venue = venue;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public Date getEventDate() { return eventDate; }
    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }
    public Time getEventTime() { return eventTime; }
    public void setEventTime(Time eventTime) { this.eventTime = eventTime; }
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    public double getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
}
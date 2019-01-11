package com.example.jack.security;

public class EventDetails {
    String eventName, hostName,contactNumber;
    int capacityLeft;

    public EventDetails(String eventName, String hostName, String contactNumber, int capacityLeft) {
        this.eventName = eventName;
        this.hostName = hostName;
        this.contactNumber = contactNumber;
        this.capacityLeft = capacityLeft;
    }

    public EventDetails() {
    }

    public String getEventName() {
        return eventName;
    }

    public String getHostName() {
        return hostName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getCapacity() {
        return capacityLeft;
    }
}

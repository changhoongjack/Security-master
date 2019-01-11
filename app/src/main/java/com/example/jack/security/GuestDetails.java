package com.example.jack.security;

public class GuestDetails {
    String guestName,guestIC,guestCar,intime,indate,security;

    public GuestDetails() {
    }

    public GuestDetails(String guestName, String guestIC, String guestCar, String INtime, String INdate, String security) {
        this.guestName = guestName;
        this.guestIC = guestIC;
        this.guestCar = guestCar;
        this.intime = INtime;
        this.indate = INdate;
        this.security = security;
    }

    public String getSecurity() {
        return security;
    }

    public String getINtime() {
        return intime;
    }

    public String getINdate() {
        return indate;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestIC() {
        return guestIC;
    }

    public String getGuestCar() {
        return guestCar;
    }
}

package com.example.jack.security;

public class DutyReportDetails {
    String security,checkINdate,checkINtime,checkOutdate,checkOuttime;

    public DutyReportDetails() {
    }

    public DutyReportDetails(String security, String checkINdate, String checkINtime, String checkOutdate, String checkOuttime) {
        this.security = security;
        this.checkINdate = checkINdate;
        this.checkINtime = checkINtime;
        this.checkOutdate = checkOutdate;
        this.checkOuttime = checkOuttime;
    }

    public String getSecurity() {
        return security;
    }

    public String getCheckINdate() {
        return checkINdate;
    }

    public String getCheckINtime() {
        return checkINtime;
    }

    public String getCheckOutdate() {
        return checkOutdate;
    }

    public String getCheckOuttime() {
        return checkOuttime;
    }
}

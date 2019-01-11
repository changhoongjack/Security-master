package com.example.jack.security;

public class ContractorDetails {
    String dataID;
    String indate;
    String intime;
    String contractorName;
    String contractorIC;
    String company;
    String address;
    String guardID;

    public ContractorDetails() {
    }

    public ContractorDetails(String dataID, String indate, String intime, String contractorName, String contractorIC, String company, String address,String guardID) {
        this.dataID = dataID;
        this.indate = indate;
        this.intime = intime;
        this.contractorName = contractorName;
        this.contractorIC = contractorIC;
        this.company = company;
        this.address = address;
        this.guardID = guardID;
    }

    public String getGuardID() {
        return guardID;
    }

    public String getDataID() {
        return dataID;
    }

    public String getINdate() {
        return indate;
    }

    public String getINtime() {
        return intime;
    }

    public String getContractorName() {
        return contractorName;
    }

    public String getContractorIC() {
        return contractorIC;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }
}

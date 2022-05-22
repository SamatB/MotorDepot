package com.company;

public class Driver {
    private int driverId;
    private String driverName;

    public Driver(int driverId, String driverName) {
        this.driverId = driverId;
        this.driverName = driverName;
    }

    public Driver() {
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return driverId + " | " + driverName + "      |";
    }
}

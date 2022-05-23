package com.company;


public class Driver {
    private int driverId;
    private String driverName;
    private String truck;

    public Driver(int driverId, String driverName, String truck) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.truck = truck;
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

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    @Override
    public String toString() {
        return driverId + " | " + driverName + "   |" + "       |";
    }
}

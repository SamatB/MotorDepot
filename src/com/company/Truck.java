package com.company;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Truck createTruck(int id, String name, Driver driver, Status status) {
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.status = status;
        return truck;
    }

    @Override
    public String toString() {
        return "Truck: " +
                "id = " + id +
                ", name = " + name +
                ", driver = " + driver +
                ", status = " + status;
    }
}

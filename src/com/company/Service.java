package com.company;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static com.company.Main.*;

public class Service {
    static Driver driver = new Driver();
    static Driver[] drivers = GSON.fromJson(readDriverFile(), Driver[].class);
    static String notChosenDriver;
    static String driverNewName = null;
    static String newTruckName;
    static Scanner scanner = new Scanner(System.in);

    public static void truckInfo(Truck[] trucks, int truckId) throws Exception {
        while (true) {
            for (Truck truck : trucks) {
                newTruckName = truck.getName();
//                truckId = scanner.nextInt();
                if (truck.getId() == truckId) {
                    if (truck.getDriver().getDriverName() == null) {
                        notChosenDriver = " ";
                    } else if (truck.getDriver().getDriverName() != null) {
                        notChosenDriver = truck.getDriver().getDriverName();
                    }
                    System.out.println("Truck below is : ");
                    System.out.println("N | " + "Truck         | " + "Driver| " + "Truck status |");
                    System.out.println("--|---------------|-------|--------------|");
                    System.out.println(truck.getId() + " |" + truck.getName() + " |" + notChosenDriver + "      |" + truck.getStatus() + "  |");
                    System.out.println("--|---------------|-------|--------------|");
                    System.out.println("""
                            Press 1 to set/change driver
                            Press 2 to send to road
                            Press 3 to send to repairing
                            Press 5 to send to base
                            Press 0 to quit""");
                    int toChange = scanner.nextInt();
                    if (toChange == 1 && truck.getStatus().equals(Status.BASE)) {
                        System.out.println("Choose the driver");
                        changeDriver(scanner.nextInt());
                        truck.setDriver(driver);
                        System.out.println("N | " + "Truck         | " + "Driver| " + "Truck status |");
                        System.out.println("--|---------------|-------|--------------|");
                        System.out.println(truck.getId() + " |" + truck.getName() + " |" + driverNewName + "  |" + truck.getStatus() + "  |");
                        System.out.println("--|---------------|-------|--------------|");
                        System.out.println("If you want to send the driver to road press 2, or press 0 not to send, \nor press 4 to send to repair");
                        toChange = scanner.nextInt();
                        if (toChange == 2) {
                            startDriving(newTruckName, driverNewName);
                            truck.setStatus(Status.ROAD);
                            System.out.println("successfully on the road");
                        } else if (toChange == 0) {
                            truck.setStatus(Status.BASE);
                            System.out.println("The driver and truck are on the base");
                        } else if (toChange == 4) {
                            truck.setStatus(Status.REPAIR);
                        } else if (driver.getTruck() == null && truck.getStatus().equals(Status.BASE) && toChange == 1) {
                            throw new Exception("There are no available drivers");
                        }
                    } else if (toChange == 1 && truck.getStatus().equals(Status.ROAD) && truck.getStatus().equals(Status.REPAIR)
                            && truck.getDriver().getDriverName().equals(driverNewName)) {
                        throw new Exception("Drivers are not available to change");
                    } else if (toChange == 1 && truck.getStatus().equals(Status.ROAD)) {
                        throw new Exception("You can not change the driver on the road");
                    } else if (toChange == 2 && truck.getStatus().equals(Status.ROAD)) {
                        throw new Exception("The truck is already on road");
                    } else if (truck.getStatus().equals(Status.REPAIR) && toChange == 2) {
                        Random random = new Random();
                        int condition = random.nextInt(2);
                        switch (condition) {
                            case 0 -> truck.setStatus(Status.ROAD);
                            case 1 -> truck.setStatus(Status.BASE);
                            default -> throw new Exception("There is no another condition");
                        }
                    } else if (toChange == 0) {
                        System.exit(0);
                    } else if (toChange == 2) {
                        System.out.println("Firstly choose the driver");
                        changeDriver(scanner.nextInt());
                        startDriving(newTruckName, driverNewName);
                        truck.setDriver(driver);
                        truck.setStatus(Status.ROAD);
                    } else if (toChange == 5 && truck.getStatus().equals(Status.REPAIR)) {
                        truck.setStatus(Status.BASE);
                        System.out.println("The truck on the base");
                    } else if (toChange == 5 && truck.getStatus().equals(Status.ROAD)) {
                        truck.setStatus(Status.BASE);
                        System.out.println("The truck on the base");
                    } else if (toChange == 3 && truck.getStatus().equals(Status.BASE)) {
                        startRepair(newTruckName);
                        truck.setStatus(Status.REPAIR);
                    } else if (toChange == 3 && truck.getStatus().equals(Status.ROAD)) {
                        startRepair(newTruckName);
                        truck.setStatus(Status.REPAIR);
                    } else if (toChange == 3 && truck.getStatus().equals(Status.REPAIR)) {
                        throw new Exception("Already on repairing");
                    } else if (toChange == 1 && truck.getStatus().equals(Status.REPAIR)) {
                        throw new Exception("You can not change the driver on repairing");
                    }
                }
            }
            if (trucks.length < truckId) {
                throw new Exception("We have only 3 trucks\n" +
                        "Choose a truck again");
            }
        }
    }

    public static void changeDriver(int drierID) throws Exception {
        for (Driver driver1 : drivers) {
            if (driver1.getDriverId() == drierID) {
                driverNewName = driver1.getDriverName();
                driver = driver1;
            } else if (drivers.length < drierID) {
                throw new Exception("We have only 3 drivers");
            }
        }
        System.out.println("The truck " + newTruckName + " has a driver - " + driverNewName);
    }

    public static void startDriving(String newTruckName, String driverNewName) {
        System.out.println(driverNewName + " is driving the " + newTruckName + " truck on the way");
    }

    public static void startRepair(String newTruckName) {
        System.out.println("The " + newTruckName + " truck is on repairing");
    }
}

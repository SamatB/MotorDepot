package com.company;

import java.util.Scanner;
import static com.company.Main.*;

public class Service {
    static Driver driver = new Driver();
    static String notChosenDriver;
    public static void changeDriver() {
        Truck[] trucks = GSON.fromJson(readTruckFile(), Truck[].class);
        Driver[] drivers = GSON.fromJson(readDriverFile(), Driver[].class);
        Scanner scanner = new Scanner(System.in);

        for (Truck truck: trucks) {
            System.out.println("00000");
           int truckId = scanner.nextInt();
            if (truck.getId() == truckId) {
                if (truck.getDriver().getDriverName() == null) {
                    notChosenDriver = " ";
                } else {
                    notChosenDriver = truck.getDriver().getDriverName();
                }
                System.out.println("Truck below is chosen: ");
                System.out.println("N | " + "Truck         | " + "Driver| " + "Truck status |");
                System.out.println("--|---------------|-------|--------------|");

                System.out.println(truck.getId() + " |" + truck.getName() + " |"+ notChosenDriver+ "      |" + truck.getStatus()+ "  |");
                System.out.println("--|---------------|-------|--------------|");
            }
        }



//        int truckInId;
//        int driverChange;
//
//        Truck[] trucks = GSON.fromJson(readTruckFile(), Truck[].class);
//        Driver[] drivers = GSON.fromJson(readDriverFile(), Driver[].class);

    }

    public static void startDriving () {

    }

    public static void startRepair() {

    }
}

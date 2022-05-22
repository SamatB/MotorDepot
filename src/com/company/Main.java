package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    private static final Path WRITE_PATH = Paths.get("./truck.gson");

    private static final Path WRITE_PATHD = Paths.get("./driver.gson");

    public static void main(String[] args) {
        Truck[] trucks = {Truck.createTruck(1, "Renault Magnum", new Driver(), Status.BASE),
                Truck.createTruck(2, "Volvo", new Driver(), Status.REPAIR),
                Truck.createTruck(3, "DAF XT", new Driver(), Status.ROAD)
        };

        Driver[] drivers = {new Driver(1, "Maga"),
                new Driver(2, "Samat"), new Driver(3, "Tilek")
        };

        String gson = GSON.toJson(trucks);
//        System.out.println(gson);
        writeTruck(gson);
        System.out.println("# | Truck            | State      | Driver\n" +
                            "__|__________________|__________");
        Truck [] trucks1 = GSON.fromJson(readTruckFile(), Truck[].class);
        for (Truck truck: trucks1) {
            System.out.println(truck.toString());
        }

        System.out.println("************************");

        String gsonD = GSON.toJson(drivers);
        writeDriver(gsonD);
        System.out.println("#   Driver    | Truck\n" +
                "__|___________|______");
        Driver [] drivers1 = GSON.fromJson(readDriverFile(), Driver[].class);
        for (Driver driver: drivers1) {
            System.out.println(driver.toString());
        }

    }

    public static void writeTruck(String truck) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, truck, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTruckFile() {
        String gson = " ";
        try (FileReader reader = new FileReader(String.valueOf(WRITE_PATH))) {
            int a;
            while ((a = reader.read()) != -1) {
                gson += (char) a;
            }
            return gson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson;
    }

    public static void writeDriver(String drive) {
        Path writeD = Paths.get(String.valueOf(WRITE_PATHD));
        try {
            Files.writeString(writeD, drive, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readDriverFile() {
        String gsonD = " ";
        try (FileReader readerD = new FileReader(String.valueOf(WRITE_PATHD))){
            int b;
            while ((b = readerD.read()) != -1) {
                gsonD += (char) b;
            }
            return gsonD;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gsonD;
    }
}

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

    public static void main(String[] args) {
        Truck[] trucks = {Truck.createTruck(1, "Renault Magnum", new Driver(), Status.BASE),
                Truck.createTruck(2, "Volvo", new Driver(), Status.BASE),
                Truck.createTruck(3, "DAF XT", new Driver(), Status.BASE)
        };

        String gson = GSON.toJson(trucks);
//        System.out.println(gson);
        write(gson);
        System.out.println(readFile());

    }

    public static void write(String truck) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, truck, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile() {
        String gson = " ";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = reader.read()) != -1) {
                gson += (char) a;
            }
            return gson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  gson;
    }
}

package com.ranthas.day01.part02;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.io.IOException;

public class DayOne {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day01/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();

        try {
            long fuelRequiredSum =
                    fileService.readAllLinesFromFile(DATA_INPUT_FILE)
                            .stream()
                            .mapToLong(stringValue -> calculateFuelRequirement(Long.parseLong(stringValue)))
                            .sum();

            System.out.println(fuelRequiredSum);

        } catch (IOException e) {
            System.err.print("Error en la lectura del fichero!!!!");
            e.printStackTrace();
        }
    }

    private static Long calculateFuelRequirement(long mass) {
        long massOfFuelRequired = (mass / 3L) - 2;
        return massOfFuelRequired <= 0 ?
                0 :
                massOfFuelRequired + calculateFuelRequirement(massOfFuelRequired);
    }
}

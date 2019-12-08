package com.ranthas.day01.part01;

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
                            .map(stringValue -> calculateFuelRequirement(Long.parseLong(stringValue)))
                            .mapToLong(Long::longValue)
                            .sum();

            System.out.println(fuelRequiredSum);

        } catch (IOException e) {
            System.err.print("Error en la lectura del fichero!!!!");
            e.printStackTrace();
        }
    }

    private static Long calculateFuelRequirement(long mass) {
        return (mass / 3L) - 2;
    }
}

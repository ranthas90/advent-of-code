package com.ranthas.day01.part02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DayOne {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day01/data-input.aoc";

    public static void main(String[] args) {
        try {
            long fuelRequiredSum =
                    readAllLinesFromFile(DATA_INPUT_FILE)
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
        long massOfFuelRequired = (mass / 3L) - 2;
        return massOfFuelRequired <= 0 ?
                0 :
                massOfFuelRequired + calculateFuelRequirement(massOfFuelRequired);
    }

    private static List<String> readAllLinesFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}

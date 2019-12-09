package com.ranthas.day02.part01;

import com.ranthas.day02.IntcodeCalculator;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.io.IOException;
import java.util.Arrays;

public class DayTwo {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day02/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();

        try {
            String[] split =
                    fileService
                            .readFile(DATA_INPUT_FILE)
                            .split(",");

            int[] intcodes =
                    Arrays.asList(split)
                            .stream()
                            .mapToInt(Integer::parseInt)
                            .toArray();

            IntcodeCalculator calculator = new IntcodeCalculator(intcodes);
            calculator.doCalculation();
            calculator.printOutput();

        } catch (IOException e) {
            System.err.print("Error en la lectura del fichero!!!!");
            e.printStackTrace();
        }

    }
}

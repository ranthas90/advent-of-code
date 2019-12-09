package com.ranthas.day02.part02;

import com.ranthas.day02.IntcodeCalculator;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.io.IOException;
import java.util.Arrays;

public class DayTwo {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day02/data-input.aoc";
    private static final long VALUE_TO_ACHIEVE = 19690720L;

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

            int[] intcodesCalc = resetIntcodes(intcodes);

            for (int noun = 0; noun < 99; noun++) {
                for (int verb = 0; verb < 99; verb++) {
                    intcodesCalc[1] = noun;
                    intcodesCalc[2] = verb;

                    IntcodeCalculator calculator = new IntcodeCalculator(intcodesCalc);

                    if (calculator.doCalculation()[0] == VALUE_TO_ACHIEVE) {
                        System.out.println(100 * noun + verb);
                        System.exit(0);
                    } else {
                        intcodesCalc = resetIntcodes(intcodes);
                    }
                }
            }

        } catch (IOException e) {
            System.err.print("Error en la lectura del fichero!!!!");
            e.printStackTrace();
        }
    }

    private static int[] resetIntcodes(int[] intcodes) {
        return Arrays.copyOf(intcodes, intcodes.length);
    }
}

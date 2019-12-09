package com.ranthas.day02;

public class IntcodeCalculator {

    private int[] intcodes;

    public IntcodeCalculator(int[] intcodes) {
        this.intcodes = intcodes;
    }

    /**
     * ********************************************************
     */

    public int[] doCalculation() {
        for (int i = 0; i < intcodes.length; i++) {

            if (isAdditionOpcode(intcodes[i])) {
                addition(intcodes[i + 1], intcodes[i + 2], intcodes[i + 3]);
                i = moveToNextOpcode(i);

            } else if (isMultiplicationOpcode(intcodes[i])) {
                multiply(intcodes[i + 1], intcodes[i + 2], intcodes[i + 3]);
                i = moveToNextOpcode(i);

            } else if (isEndOfProgram(intcodes[i])) {
                return intcodes;
            }
        }

        return intcodes;
    }

    public void printOutput() {
        System.out.println(intcodes[0]);
    }



    /**
     * ********************************************************
     */

    private boolean isAdditionOpcode(int value) {
        return value == 1;
    }

    private void addition(int firstIndex, int secondIndex, int storeIndex) {
        intcodes[storeIndex] = intcodes[firstIndex] + intcodes[secondIndex];
    }

    private boolean isMultiplicationOpcode(int value) {
        return value == 2;
    }

    private void multiply(int firstIndex, int secondIndex, int storeIndex) {
        intcodes[storeIndex] = intcodes[firstIndex] * intcodes[secondIndex];
    }

    private boolean isEndOfProgram(int value) {
        return value == 99;
    }

    // Remember that for loop adds one in the next iteration to index, so if we add 4, we are missing one input
    private int moveToNextOpcode(int currentIndex) {
        return currentIndex + 3;
    }
}

package com.vatoka;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        myMethod();
    }

    static void myMethod() {
        String range = JOptionPane.showInputDialog(null, "Enter Number Range (eg. 1-100)");

        if (range == null) {

            Object[] choices = {"Restart", "Close"};
            Object defaultChoice = choices[0];
            int rangeError = JOptionPane.showOptionDialog(null,
                    "The number range requires a value! Would you like to exit?",
                    "Random Number",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    defaultChoice);

            if (rangeError == JOptionPane.YES_OPTION) {
                myMethod();
            } else {
                System.exit(0);
            }
        }


        System.out.println(range);
        String[] arrOfStr = null;
        if (range.contains("-")) {
            arrOfStr = range.split("-", 2);

        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Range must be a integer");
            myMethod();
        }

        String minString = arrOfStr[0];
        String maxString = arrOfStr[1];

        int min = 0;
        int max = 0;

        if (arrOfStr[0].contains(",")) {
            System.out.println();
            minString = arrOfStr[0].replace(",", "");
            System.out.println(minString);
        }
        if (arrOfStr[1].contains(",")) {
            maxString = arrOfStr[1].replace(",", "");
            System.out.println(maxString);
        }
        System.out.println(minString);
        System.out.println("MAX" + maxString);
        try {
            min = (Integer.parseInt(minString));
            max = (Integer.parseInt(maxString));
        } catch (NumberFormatException e) { // Checks for a valid number
            JOptionPane.showMessageDialog(null, "ERROR: Range must be a integer");
            myMethod();
        }


        try {
            min = Integer.parseInt(minString);
            max = Integer.parseInt(maxString);
        } catch (NumberFormatException e) { // Checks for a valid number
            JOptionPane.showMessageDialog(null, "ERROR: Range must be a integer");
            myMethod();
        }

        if (max < min) {
            JOptionPane.showMessageDialog(null, "ERROR: That range is not valid!");
            myMethod();
        }

        if (max == min) {
            JOptionPane.showMessageDialog(null, "ERROR: The range must be at least 1 number apart.");
            myMethod();
        }

        if (!(min == 0) && !(max == 0)) {
            System.out.println("Values are not = 0");
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            String confMsg = "Did you want me to pick a number between " + minString + " and " + maxString + "?";
            int dialogResult = JOptionPane.showConfirmDialog(null, confMsg, "Confirm", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                // Saving code here
                int rangeex = max - min + 1;
                int rand = (int) (Math.random() * rangeex) + min;
                // Output is different everytime this code is executed
                System.out.println(rand);
                Object[] choices = {"Restart", "Close"};
                Object defaultChoice = choices[0];
                int dialogResult2 = JOptionPane.showOptionDialog(null,
                        "Your random number is: " + rand,
                        "Random Number",
                        JOptionPane.YES_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        choices,
                        defaultChoice);
                if (dialogResult2 == JOptionPane.YES_OPTION) {
                    myMethod();
                }

            } else if (dialogResult == JOptionPane.NO_OPTION) {
                myMethod();
            } else {
                JOptionPane.showConfirmDialog(null, "Uh oh, I have encountered an error!", "ERROR", JOptionPane.OK_CANCEL_OPTION);
            }

        }
    }
}


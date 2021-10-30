package fi.tuni.tamk.tiko.jarvinenjoonas.util;

import java.io.Console;

/**
*Contains methods related to Console inputs
*
*@author Joonas Järvinen
*/
public class MyConsole {
    /**
    *A method that asks the user to input an integer value until the user does
    *
    *@param errorMessage the message that is outputted if the user gives an invalid input
    *@return the valid integer value the user gives
    */
    public static int readInt(String errorMessage) {
        Console c = System.console(); 

        boolean correctValue = false;
        int returnValue = 0;
        while(correctValue == false) {
            try {
                System.out.println("Give an integer value");
                int input = Integer.parseInt(c.readLine());
                returnValue = input;
                correctValue = true;
            } catch(NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
        return returnValue;
    }
    /**
    *A method that asks the user for an integer value within a given range until the user gives a valid input
    *
    *@param min the lowest acceptable integer value
    *@param max the highest acceptable integer value
    *@param errorMessageNonNumeric the message outputted if the user does not input an integer
    *@param errorMessageNonMinAndMax the mesage outputted if the user does not input an integer value within the given range
    *@return the valid integer value given by the user
    */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();

        boolean correctValue = false;
        int returnValue = 0;
        while(correctValue == false) {
            try {
                System.out.println(errorMessageNonNumeric + " between " + min + " and " + max);
                int input = Integer.parseInt(c.readLine());
                if(input < min || input > max) {
                    System.out.println(errorMessageNonMinAndMax);
                } else {
                    returnValue = input;
                    correctValue = true;
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        }
        return returnValue;
    }
}
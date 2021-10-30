package fi.tuni.tamk.tiko.jarvinenjoonas;

import fi.tuni.tamk.tiko.jarvinenjoonas.util.Math;

import fi.tuni.tamk.tiko.jarvinenjoonas.util.Arrays;

import fi.tuni.tamk.tiko.jarvinenjoonas.util.MyConsole;

/**
*Contains the main method
*
*@author Joonas Järvinen
*/
public class Main {
    /** 
    * Purely for testing other methods
    */
    public static void main(String [] args) {
        System.out.println(Math.getRandom(1, 10));
        String [] array = {"1", "2", "3", "4"};
        int [] IntArray = Arrays.toIntArray(array);
        System.out.println(Arrays.contains(6, IntArray));
        int [] array1 = {1,52,6,4,7};
        int [] array2 = {2,24,6,5,7,52};
        System.out.println(Arrays.containsSameValues(array1, array2));
        int integerValue1 = MyConsole.readInt("Not a valid integer");
        int integerValue2 = MyConsole.readInt(5, 26, "Please input an integer value", "Please input a value within the range");
    }
}
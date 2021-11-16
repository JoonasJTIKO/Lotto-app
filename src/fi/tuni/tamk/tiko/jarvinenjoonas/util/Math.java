package fi.tuni.tamk.tiko.jarvinenjoonas.util;

/**
*Contains various methods related to mathematics.
*
*@author Joonas Järvinen
*/
public class Math {
    /**
    *Returns a random whole number within a range
    *
    *@param min the minimum value
    *@param max the maximum value
    *@return a random whole number greater or equal to min and less or equal to max
    */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}


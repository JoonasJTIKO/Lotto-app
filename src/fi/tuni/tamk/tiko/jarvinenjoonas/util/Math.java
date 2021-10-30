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
    /** 
    *A method that removes a given index from a given int array
    *
    *@param original the int array that is to be updated
    *@param index the index that is removed from original
    *@return the new int array with one index removed
    */
    public static int[] removeIndex(int [] original, int index) {
        original[index] = 0;
        int [] updated = new int[original.length - 1];
        int i = 0;
        int j = 0;
        while(i < updated.length - 1) {
            if(j == index) {
                j++;
            } else {
                updated[i] = original[j];
                i++;
                j++;
            }
        }
        return updated;
    }
}


package fi.tuni.tamk.tiko.jarvinenjoonas.util;

/**
*Contains methods related to Arrays
*
*@author Joonas Järvinen
*/
public class Arrays {
    /**
    *A method that converts a String type array into an int type array
    *
    *@param array the String array that is to be converted
    *@return an int array
    */
    public static int [] toIntArray(String [] array) {
        int [] IntArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            IntArray[i] = Integer.parseInt(array[i]);
        }
        return IntArray;
    }
    /**
    *A method that checks if a given value is found within a given array
    *
    *@param value the given value that is checked to see if it is contained in the array
    *@param array the given array from which the given value is searched for
    *@return true if the value is in the array, false if it is not
    */
    public static boolean contains(int value, int [] array) {
        boolean contains = false;
        for(int i = 0; i < array.length && contains == false; i++) {
            if(array[i] == value) {
                contains = true;
            }
        }
        return contains;
    }
    /**
    *A method that checks how many int values are shared between to int arrays
    *
    *@param array1 the first array
    *@param array2 the second array
    *@return the number of values that appear in both arrays
    */
    public static int containsSameValues(int [] array1, int [] array2) {
        int sameValues = 0;
        int length1 = 0;
        int length2 = 0;
        if(array1.length <= array2.length) {
            length1 = array1.length;
            length2 = array2.length;
        } else {
            length1 = array2.length;
            length2 = array1.length;
        }
        for(int i = 0; i < length1; i++) {
            boolean matchFound = false;
            for(int j = 0; j < length2 && matchFound == false; j++) {
                if(array1[i] == array2[j]) {
                    sameValues++;
                    matchFound = true;
                }
            }
        }
        return sameValues;
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
        while(i < updated.length) {
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
    /** 
    *A method that sorts an int array into ascending order
    *
    *@param array the array that is to be sorted
    *@return the sorted array
    */
    public static int [] sort(int [] array) {
        int n = array.length;
        for(int i = 0; i < n-1; i++) {
            int min_idx = i;
            for(int j = i+1; j < n; j++)
                if(array[j] < array[min_idx])
                    min_idx = j;
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        return array;
    }
    /** 
    *A method that converts the values in an array into a string with a given amount of zeros added as a prefix to each
    *
    *@param array the array which will be converted into a string
    *@param prefixAmount the amount of zeros added to the beginning of each value
    *@param autoPrefix if true, the amount zeros added is determined by the amount of digits in the largest value
    *@return the values from the array with the prefix added as a list in String format
    */
    public static String addPrefix(int [] array, int prefixAmount, boolean autoPrefix) {
        String output = "";
        int autoPrefixAmount = prefixAmount + 1;
        if(autoPrefix == true) {
            autoPrefixAmount = findLongest(array);
        }
        String [] stringArray = toStringArray(array);
        for(int i = 0; i < stringArray.length; i++) {
            if(!(i == stringArray.length - 1)) {
                String prefix = "";
                for(int j = 0; j < autoPrefixAmount - stringArray[i].length(); j++) {
                    prefix = prefix + "0";
                }
                output = output + prefix + stringArray[i] + ", ";
            } else {
                String prefix = "";
                for(int j = 0; j < autoPrefixAmount - stringArray[i].length(); j++) {
                    prefix = prefix + "0";
                }
                output = output + prefix + stringArray[i];
            }
        }
        return output;
    }
    /** 
    *A method that finds out the amount if digits in the longest number within an array
    *
    *@param array the array from which the largest amount of digits is determined
    *@return the amount of digits in the longest number
    */
    public static int findLongest(int [] array) {
        int longest = 0;
        for(int i = 0; i < array.length; i++) {
            String value = "" + array[i];
            if(value.length() > longest) {
                longest = value.length();
            }
        }
        return longest;
    }
    /** 
    *A method that converts an int array to a String array
    *
    *@param array the int array that is converted
    *@return the new String array
    */
    public static String [] toStringArray(int [] array) {
        String [] stringArray = new String[array.length];
        for(int i = 0; i < array.length; i++) {
            stringArray[i] = "" + array[i];
        }
        return stringArray;
    }
}
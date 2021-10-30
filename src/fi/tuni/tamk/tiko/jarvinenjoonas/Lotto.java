package fi.tuni.tamk.tiko.jarvinenjoonas;

import fi.tuni.tamk.tiko.jarvinenjoonas.util.Math;

import fi.tuni.tamk.tiko.jarvinenjoonas.util.Arrays;

import fi.tuni.tamk.tiko.jarvinenjoonas.util.MyConsole;

import java.io.Console;

/**
*Contains the Lotto app
*
*@author Joonas Järvinen
*/
//The app works with any amount of possible lotto numbers and any amount needed for jackpot
public class Lotto {
    static int jackpotLength = 7;
    public static void main(String [] args) {
        Console c = System.console();

        int [] lottoNumbers = Arrays.toIntArray(args);
        if(!(lottoNumbers.length == jackpotLength)) {
            lottoNumbers = userLotto(40);
        }

        boolean printNumbers = false;
        System.out.println("Do you wish to see your numbers and the result numbers every week? [y/n]");
        if(c.readLine().equals("y")) {
            printNumbers = true;
        } 
        boolean lifetime = false;
        while(lifetime == false) {
            for(int i = 0; i < jackpotLength; i++) {
                lifetime = getResults(lottoNumbers, i + 1, printNumbers);
                System.out.println();
            }
            System.out.println("You won!");
            if(lifetime == false) {
                System.out.println("Took more than one lifetime, let's try again!");
                System.out.println();
            } else {
                System.out.println("You got " + jackpotLength + " correct within a lifetime!");
            }
        }
    }
    /** 
    *Generates a random array containing unique numbers withing a range
    *
    *@param numberAmount the amount of possible lotto numbers
    *@return an array containing unique numbers within a range
    */
    public static int[] calculateLotto(int numberAmount) {
        int [] lottoResults = new int[jackpotLength];
        int [] allNumbers = new int[numberAmount];
        int n = 1;
        for(int i = 0; i < allNumbers.length; i++) {
            allNumbers[i] = n;
            n++;
        }
        int i = 0;
        while(i < 7) {
            int index = Math.getRandom(0, allNumbers.length - 1);
            lottoResults[i] = allNumbers[index];
            i++;
            allNumbers = Arrays.removeIndex(allNumbers, index);
        }
        return lottoResults;
    }
    /** 
    *Asks unique lotto numbers from the user
    *
    *@param numberAmount the amount of possible lotto numbers
    *@return an array that contains the unique numbers from the user
    */
    public static int[] userLotto(int numberAmount) {
        int [] lottoNumbers = new int[jackpotLength];
        int i = 0;
        while(i < jackpotLength) {
            int lottoNumber = MyConsole.readInt(1, numberAmount, "Please give a unique number", "");
            if(Arrays.contains(lottoNumber, lottoNumbers) == true) {
                System.out.println("Not unique numbers!");
            } else {
                lottoNumbers[i] = lottoNumber;
                i++;
            }
        }
        return lottoNumbers;
    }
    /** 
    *Generates sets of numbers until a given amount match the users numbers
    *
    *@param lottoNumbers the array containing the users numbers
    *@param howMany the amount of numbers we wish to match between the user and the generated numbers
    *@return true if won in less than 120 years, false if over
    */
    public static boolean getResults(int [] lottoNumbers, int howMany, boolean printNumbers) {
        int weeks = 0;
        int years = 0;
        int correctNumbers = 0;
        boolean jackpot = false;
        while(jackpot == false) {
            int [] results = calculateLotto(40);
            correctNumbers = Arrays.containsSameValues(lottoNumbers, results);
            weeks++;
            if(weeks == 52) {
                weeks = 0;
                years++;
            }
            if(correctNumbers == howMany) {
                jackpot = true;
            }
            if(printNumbers == true) {
                int [] userSorted = Arrays.sort(lottoNumbers);
                System.out.print("User lotto: ");
                boolean autoPrefix = false;
                System.out.println(Arrays.addPrefix(userSorted, 1, autoPrefix));
                int [] resultsSorted = Arrays.sort(results);
                System.out.print("Results: ");
                System.out.println(Arrays.addPrefix(resultsSorted, 1, autoPrefix));
                System.out.println("You got " + correctNumbers + " correct numbers!");
                System.out.println("It took " + years + " years and " + weeks + " weeks");
            } else if(printNumbers == false) {
                if(jackpot == true) {
                    System.out.println("You got " + correctNumbers + " correct numbers!");
                    System.out.println("It took " + years + " years and " + weeks + " weeks");
                }
            }
        }
        boolean output = false;
        if(years < 120) {
            output = true;
        }
        return output;
    }
}
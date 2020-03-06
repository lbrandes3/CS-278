// Program Name: Lab 5
// Author:       Luke Brandes
// Date:         3/5/20
// Purpose:      Determine which subsets of a set sum to a value

import java.util.Scanner;

public class Lab5 {

    public static void printSubset(int[] set, boolean[] mask) {
        String subsetString = "{ ";
        for (int i = 0; i < set.length; i++) {
            if (mask[i])
                subsetString = subsetString + set[i] + ", ";

        } // end for
        if (subsetString.length() > 2) {
            subsetString = subsetString.substring(0, subsetString.length() - 2);
        }
        subsetString = subsetString + " }";
        System.out.println(subsetString);
    } // end method

    public static boolean next(boolean[] mask) {
        int i;
        for (i = 0; i < mask.length && mask[i]; i++)
            mask[i] = false;
        if (i < mask.length) {
            mask[i] = true;
            return true;
        }
        return false;
    } // end method

    public static int sumMaskedArr(int[] set, boolean[] mask) {
        int sum = 0;
        for (int i = 0; i < set.length; i++) {
            if (mask[i]) {
                // adds a value if its bool val is true
                sum += set[i];
            } // if
        } // for
        return sum;
    } // sumMaskedArr

    public static void main (String[] args) {
        int count = 0;
        Scanner scan = new Scanner(System.in);

        // input the size of the set
        System.out.println("How many elements does your set have?");
        int n = scan.nextInt();

        // input the elements of the set
        System.out.println("Enter " + n + " integers for the elements of the array:");
        int[] mySet = new int[n];
        for (int i = 0; i < mySet.length; i++)
            mySet[i] = scan.nextInt();

        // create the initial mask with all false values
        boolean[] mask = new boolean[n];
        for (int index = 0; index < mask.length; index++ )
            mask[index] = false;

        // asks for int to check
        System.out.println("Enter the integer you want to find the sets that sum to it:");
        n = scan.nextInt();

        System.out.println("Here are the subsets of your set:");

        // Repeat until there are no more possible masks
        while (next( mask )) {
            // tests whether the sum is equal to the int
            if (sumMaskedArr(mySet, mask) == n) {
                printSubset(mySet, mask);
            } // if
        } // end while
    } // end main
} // end class
      
// Program Name:    Lab 6
// Author:          Luke Brandes
// Date:            4/2/20
// Purpose:         To test various functions

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        // initializes y
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Y: ");
        List<Integer> y = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            y.add(i);
        } // for
        int functionNumber = 0, numOneToOne = 0, numOnto = 0, numBijection = 0;
        for (int i = 1; i <= y.size(); i++) {
            for (int j = 1; j <= y.size(); j++) {
                for (int k = 1; k <= y.size(); k++) {
                    // hardcoded solution to off-by-one error with whitespace
                    if (i != 1 || j != 1 || k != 1) {
                        System.out.println();
                    } // if
                    // finds if function is onto
                    boolean onto = true;
                    if (y.size() <= 3) {
                        for (int l = 1; l <= 3 && l <= y.size(); l++) {
                            if (i != l && j != l && k != l) {
                                onto = false;
                                break;
                            } // if
                        } // for
                    } // if
                    // finds if function is one-to-one
                    boolean oneToOne = (i != j  && j != k && k != i);
                    functionNumber++;

                    // prints the table
                    System.out.println("\nFunction f" + functionNumber);
                    System.out.println("\n X    Y");
                    System.out.println("---  ---");
                    System.out.println(" a    " + i);
                    System.out.println(" b    " + j);
                    System.out.println(" c    " + k);

                    // formats output
                    System.out.print("f" + functionNumber + " is ");
                    if (!oneToOne) {
                        System.out.print("not ");
                    } else { numOneToOne++; }
                    System.out.print("one-to-one, ");
                    if(!onto) {
                        System.out.print("not ");
                    } else { numOnto++; }
                    System.out.print("onto, and ");
                    if (!onto || !oneToOne) {
                        System.out.print("not ");
                    } else { numBijection++; }
                    System.out.println("a bijection.");
                } // for 3
            } // for 2
        } // for 1

        // writes the number of each type of function
        System.out.println("\nThere are " + functionNumber + " functions total");
        System.out.println(numOneToOne + " of them are one-to-one.");
        System.out.println(numOnto + " of them are onto.");
        System.out.println(numBijection + " of them are bijections.");
    } // main
} // Lab6

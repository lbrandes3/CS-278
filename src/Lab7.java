// Program Name - Lab 7
// Author - Luke Brandes
// Date - 4/16/20
// Purpose - create cnf and dnf expressions

import java.util.Scanner;

public class Lab7 {
    // hardcoded table
    static boolean[][] mainTable = {{true, true, true},
                                    {true, true, false},
                                    {true, false, true},
                                    {true, false, false},
                                    {false, true, true},
                                    {false, true, false},
                                    {false, false, true},
                                    {false, false, false}};

    public static void printDNF(int[] vals) {
        // check for ones
        boolean b = true;
        for (int i :
                vals) {
            if (i == 1) {
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("There is no DNF for this function.");
            return;
        }

        boolean hasOne = false;

        System.out.println("DNF expression for the input/output table is");

        // print function
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == 1) {
                if (hasOne) {
                    System.out.print(" + ");
                } else {
                    hasOne = true;
                }
                System.out.print("p");
                if (!mainTable[i][0]) {
                    System.out.print("'");
                }
                System.out.print("q");
                if (!mainTable[i][1]) {
                    System.out.print("'");
                }
                System.out.print("r");
                if (!mainTable[i][2]) {
                    System.out.print("'");
                }
            }
        }
        System.out.println();
    }

    public static void printCNF(int[] vals) {
        // check for 0s
        boolean b = true;
        for (int i : vals) {
            if (i == 0) {
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("There is no CNF for this function.");
            return;
        }

        // print the function
        System.out.println("CNF expression for the input/output table is ");
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == 0) {
                System.out.print("(p");
                if(mainTable[i][0]) {
                    System.out.print("'");
                }
                System.out.print(" + q");
                if(mainTable[i][1]) {
                    System.out.print("'");
                }
                System.out.print(" + r");
                if(mainTable[i][2]) {
                    System.out.print("'");
                }
                System.out.print(")");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] in = new int[8];
        Scanner s = new Scanner(System.in);

        // inputs arr
        System.out.println("This program finds Boolean expressions (in CNF and/or DNF)that have a given input/output table.");
        System.out.println();
        System.out.println("Please enter values (0 or 1) for each row of the input/output table.");
        System.out.print("p=1, q=1, r=1. Truth value is (enter 1 or 0): ");
        in[0] = s.nextInt();
        System.out.print("p=1, q=1, r=0. Truth value is (enter 1 or 0): ");
        in[1] = s.nextInt();
        System.out.print("p=1, q=0, r=1. Truth value is (enter 1 or 0): ");
        in[2] = s.nextInt();
        System.out.print("p=1, q=0, r=0. Truth value is (enter 1 or 0): ");
        in[3] = s.nextInt();
        System.out.print("p=0, q=1, r=1. Truth value is (enter 1 or 0): ");
        in[4] = s.nextInt();
        System.out.print("p=0, q=1, r=0. Truth value is (enter 1 or 0): ");
        in[5] = s.nextInt();
        System.out.print("p=0, q=0, r=1. Truth value is (enter 1 or 0): ");
        in[6] = s.nextInt();
        System.out.print("p=0, q=0, r=0. Truth value is (enter 1 or 0): ");
        in[7] = s.nextInt();

        // prints functions
        printDNF(in);
        System.out.println();
        printCNF(in);

    }
}

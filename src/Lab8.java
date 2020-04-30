// Prog name: Lab 8
// Author:    Luke Brandes
// Date:      4/30/20
// Purpose:   Recursively calculate various sums

import java.util.Scanner;

public class Lab8 {
    public static int sum1(int n) {
        // base case
        if (n <= 0) {
            return 0;
        } // if

        // recursive case
        return 2 * n + sum1(n - 1);
    } // sum1

    public static int sum2(int n) {
        // base case
        if (n <= 1) {
            return 2;
        } // if
        // recursive case
        return n * (n + 1) + sum2(n - 1);
    } // sum2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // inputs n and outputs both summations
        System.out.print("Please enter the value of n: ");
        n = sc.nextInt();

        System.out.println();
        System.out.println("The value of the 1st summation is " + sum1(n) + ".");
        System.out.println();
        System.out.println("The value of the 2nd summation is " + sum2(n) + ".");
    } // main
} // Lab8

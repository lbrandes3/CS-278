// Program Name Lab4
// Author: Luke Brandes
// Date 2/27/20
// Purpose: to disprove a theorem

public class Lab4 {

    public static void main(String[] args) {
        boolean b = true;
        int[] squares = buildSquareArray();
        for (int i = 3; i < 10000 && b; i += 2) {
            boolean theorem = false;
            for (int j = 0; squares[j] < i; j++) {
                // runs until it finds a valueset that works.
                if (isPrime(i - 2 * squares[j])) {
                    theorem = true;
                    break;
                } // if
            } // for 2
            // runs if no valueset works
            if (!theorem) {
                System.out.println(i + " is a counterexample");
                b = false;
            } // if
        } // for 1
        if (b) {
            System.out.println("No counterexample found.");
        } // if
    } // main

    public static boolean isPrime(int num) {
        // edgeCases
        if (num < 2) {
            return false;
        } // if

        // runs until sqrt(num) to check for even divisors
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            } // if
        } // for
        return true;
    } // isPrime

    public static int[] buildSquareArray() {
        int[] arr = new int[100];
        // builds array of squares 0-99
        for (int i = 0; i < 100; i++) {
            arr[i] = i * i;
        } // for
        return arr;
    } // buildSquareArray
}
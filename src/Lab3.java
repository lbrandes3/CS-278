import java.util.Scanner;

/*
     Luke Brandes
     C S  278 M02
     Lab3
     2 / 13 / 2020
     Quantified Statements
*/
public class Lab3 {

    public static final char[] chars = {'T', 'F'};
    public static final boolean[] bools = {true, false};
    /*
         Main method, runs on execution of .java file
         Args parameter, takes input from cmd line
         Void return
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // fills array
        // int[] ints = {3, 5, -3, 6, 0, -5, 1, 7, -1, 8};
        int[] ints = new int[10];
        System.out.println("Please enter 10 different integers: ");
        for (int i = 0; i < ints.length; i++) {
            ints[i] = sc.nextInt();
        } // for
        // outputs each statement's results
        System.out.println("a) is " + statementA(ints));
        System.out.println("b) is " + statementB(ints));
        System.out.println("c) is " + statementC(ints));
        System.out.println("d) is " + statementD(ints));
    } // main
    /*
        first proposition
        ints: array to test statement A with
        output: whether statement A is true
    */
    public static boolean statementA(int[] ints) {
        for (int i : ints) {
            if(!charToBoolean(implies(booleanToChar(i < 0), booleanToChar(i % 2 == 0)))) {
                return false;
            } // if
        } // for
        return true;
    } // statement A
    /*
        second proposition
        ints: array to test statement B with
        output: whether statement B is true
    */
    public static boolean statementB(int[] ints) {
        for (int i : ints) {
            if (charToBoolean(implies(booleanToChar(i < 0), booleanToChar(i % 2 == 0)))) {
                return true;
            } // if
        } // for
        return false;
    } // statement B
    /*
        third proposition
        ints: array to test statement C with
        output: whether statement C is true
    */
    public static boolean statementC(int[] ints) {
        for (int i : ints) {
            if (i < 0 && i % 2 == 0) {
                return true;
            } // if
        } // for
        return false;
    } // statement C
    /*
        fourth proposition
        ints: array to test statement D with
        output: whether statement D is true
    */
    public static boolean statementD(int[] ints) {
        for (int i : ints) {
            if (!((i - 1) % 3 == 0 || (i - 1) % 2 == 0)) {
                return false;
            } // if
        } // for
        return true;
    } // statement D
    /*
         negates char
         p: argument
         output: negated char
    */
    public static char not(char p) {
        try {
            return booleanToChar(!charToBoolean(p));
        } catch (IllegalArgumentException e) { throw e; } // try/catch
    } // not
    /*
         or operator
         p: arg 1, q: arg 2
         output: p || q
    */
    public static char or(char p, char q) {
        try {
            return booleanToChar(charToBoolean(p) || charToBoolean(q));
        } catch (IllegalArgumentException e) { throw e; } // try/catch
    } // or
    /*
         and operator
         p: arg 1, q: arg 2
         output: p && q
    */
    public static char and(char p, char q) {
        try {
            return booleanToChar(charToBoolean(p) && charToBoolean(q));
        } catch (IllegalArgumentException e) { throw e; } // try/catch
    } // and
    /*
         implies operator
         p: arg 1, q: arg 2
         output: p -> q
    */
    public static char implies(char p, char q) {
        if (!charToBoolean(p)) { return booleanToChar(true); } // if
        return q;
    } // implies
    /*
         sends boolean to capital char
         b: boolean to be converted
         output: 'T' or 'F'
    */
    public static char booleanToChar(boolean b){
        if (b) {
            return 'T';
        } // if
        return 'F';
    } // booleanToChar
    /*
         sends capital char to boolean
         c: must be 'T' or 'F'
         output: accompanying boolean
    */
    public static boolean charToBoolean(char c) {
        if (c == 'T') { return true;  } // if
        if (c == 'F') { return false; } // if

        throw new IllegalArgumentException("Parameter must be 'T' or 'F'.");
    } // charToBoolean
    /*
         makes 3x8 table of T and F to make truth table
         no input
         output: 8 strs, one for each row
    */
    public static String[] buildTableRows() {
        String[] rows = new String[8];
        int i = 0;
        for (int p = 0; p < 2; p++) {
            for (int q = 0; q < 2; q++) {
                for (int r = 0; r < 2; r++) {
                    if (p == 0) {
                        rows[i] = "T  ";
                    } else { // if
                        rows[i] = "F  ";
                    } // else

                    if (q == 0) {
                        rows[i] += "T  ";
                    } else { // if
                        rows[i] += "F  ";
                    } // else

                    if (r == 0) {
                        rows[i] += "T  ";
                    } else { // if
                        rows[i] += "F  ";
                    } // else

                    i++;
                } // for 3
            } // for 2
        } // for 1
        return rows;
    } // buildTableRows
} // class

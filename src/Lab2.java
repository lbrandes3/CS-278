/*
     Luke Brandes
     C S  278 M02
     Lab2
     2 / 3 / 2020
     Logical Operators, Tautologies vs. Contradictiosn
*/
public class Lab2 {

    public static final char[] chars = {'T', 'F'};
    public static final boolean[] bools = {true, false};
    /*
         Main method, runs on execution of .java file
         Args parameter, takes input from cmd line
         Void return
    */
    public static void main(String[] args) {
        String[] strs = buildTableRows();
        for (int i = 1; i <= 4; i++) {
            System.out.println(
                    "p  q  r  Proposition " + i +
                    "\n-- -- -- -------------"
            );

            int trues = 0;

            for (int j = 0; j < 8; j++) {
                String thisLine = strs[j];
                char p = thisLine.charAt(0);
                char q = thisLine.charAt(3);
                char r = thisLine.charAt(6);

                // Runs statement for each proposition, demarkated by 1, 2, 3, 4
                if (i == 1) {
                    char truthVal = and(implies(not(p), q), implies(r, p));
                    if (charToBoolean(truthVal)) {
                        trues++;
                    }
                    System.out.println(thisLine + truthVal);
                }
                if (i == 2) {
                    char truthVal = and( or(p, not(q)), or(r, not( implies(p, q))));
                    if (charToBoolean(truthVal)) {
                        trues++;
                    }
                    System.out.println(thisLine + truthVal);
                }
                if (i == 3) {
                    char truthVal = implies(p, implies( not( or(p, not(q))), and(p, q)));
                    if (charToBoolean(truthVal)) {
                        trues++;
                    }
                    System.out.println(thisLine + truthVal);
                }
                if (i == 4) {
                    char truthVal = and( and(p, implies(p, q)), not(q));
                    if (charToBoolean(truthVal)) {
                        trues++;
                    }
                    System.out.println(thisLine + truthVal);
                }
            }
            System.out.println(trues + " combinations result in proposition " + i +
                    " being T.\n" +
                    (8 - trues) + " combinations result in proposition " + i +
                    " being F.");

            // Tests for contradiction or tautology
            if (trues == 8) {
                System.out.println("Proposition " + i + " is a tautology.\n");
            } else if (trues == 0) {
                System.out.println("Proposition " + i + " is a contradiction.\n");
            } else {
                System.out.println("Proposition " + i + " is neither a tautology nor a contradiction.\n");
            }
        }
    }
    /*
         negates char
         p: argument
         output: negated char
    */
    public static char not(char p) {
        try {
            return booleanToChar(!charToBoolean(p));
        } catch (IllegalArgumentException e) { throw e; }
    }
    /*
         or operator
         p: arg 1, q: arg 2
         output: p || q
    */
    public static char or(char p, char q) {
        try {
            return booleanToChar(charToBoolean(p) || charToBoolean(q));
        } catch (IllegalArgumentException e) { throw e; }
    }
    /*
         and operator
         p: arg 1, q: arg 2
         output: p && q
    */
    public static char and(char p, char q) {
        try {
            return booleanToChar(charToBoolean(p) && charToBoolean(q));
        } catch (IllegalArgumentException e) { throw e; }
    }
    /*
         implies operator
         p: arg 1, q: arg 2
         output: p -> q
    */
    public static char implies(char p, char q) {
        if (!charToBoolean(p)) { return booleanToChar(true); }
        return q;
    }
    /*
         sends boolean to capital char
         b: boolean to be converted
         output: 'T' or 'F'
    */
    public static char booleanToChar(boolean b){
        if (b) {
            return 'T';
        }
        return 'F';
    }
    /*
         sends capital char to boolean
         c: must be 'T' or 'F'
         output: accompanying boolean
    */
    public static boolean charToBoolean(char c) {
        if (c == 'T') { return true;  }
        if (c == 'F') { return false; }

        throw new IllegalArgumentException("Parameter must be 'T' or 'F'.");
    }
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
                    } else {
                        rows[i] = "F  ";
                    }

                    if (q == 0) {
                        rows[i] += "T  ";
                    } else {
                        rows[i] += "F  ";
                    }

                    if (r == 0) {
                        rows[i] += "T  ";
                    } else {
                        rows[i] += "F  ";
                    }

                    i++;
                }
            }
        }
        return rows;
    }
}

/*
     Luke Brandes
     C S  278 M02
     Lab1
     1 / 29 / 2020
     To print all possible truth tables
*/
public class Lab1 {

    public static final char[] chars = {'T', 'F'};
    public static final boolean[] bools = {true, false};
/*
     Main method, runs on execution of .java file
     Args parameter, takes input from cmd line
     Void return
*/
    public static void main(String[] args) {
        int truthTableNum = 1;
        String[] rows = buildTableRows();

        System.out.println("Hello World!");

        for (char char0 : chars) {
            for (char char1: chars) {
                for (char char2: chars) {
                    for (char char3: chars) {
                        for (char char4: chars) {
                            for (char char5: chars) {
                                for (char char6: chars) {
                                    for (char char7: chars) {
                                        System.out.println("Truth table " + truthTableNum + ":\n" +
                                                "p  q  r  proposition\n" +
                                                "-- -- -- -----------\n" +
                                                rows[0] + char0 + "\n" +
                                                rows[1] + char1 + "\n" +
                                                rows[2] + char2 + "\n" +
                                                rows[3] + char3 + "\n" +
                                                rows[4] + char4 + "\n" +
                                                rows[5] + char5 + "\n" +
                                                rows[6] + char6 + "\n" +
                                                rows[7] + char7);
                                        truthTableNum++;
                                    }//8
                                }//7
                            }//6
                        }//5
                    }//4
                }//3
            }//2
        }//1
        
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
     return: 8 strs, one for each row
*/
    public static String[] buildTableRows() {
        String[] rows = new String[8];
        int i = 0;
        for (char c1 : chars) {
            for (char c2 : chars) {
                for (char c3 : chars) {
                    rows[i] = c1 + "  " + c2 + "  " + c2 + "  ";


                    i++;
                }
            }
        }

        return rows;
    }
}

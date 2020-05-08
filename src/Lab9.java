// Program Name: Lab 9
// Author:       Luke Brandes
// Date:         5/7/19
// Purpose:      To count the various plays available in Scrabble

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab9 {
    // saves names of the files for convenient editing
    private static final String SCRABBLE_THREES = "scrabble3.txt";
    private static final String SCRABBLE_FOURS = "scrabble4.txt";

    private static List<String> input(String fileName) {
        File f = new File(fileName);
        List<String> fin = new ArrayList<>();
        try {
            // inputs all words from the file
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                fin.add(sc.nextLine());
            } // while
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } // catch
        return fin;
    } // input

    public static void main(String[] args) {
        // saves files in a dynamic array
        List<String> threes = input(SCRABBLE_THREES);
        List<String> fours = input(SCRABBLE_FOURS);

        Scanner in = new Scanner(System.in);

        System.out.print("Enter 3 letters with no spaces in between: ");
        char[] chars = in.nextLine().toCharArray();
        System.out.println();

        // finds all permutations
        List<String> permutations = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    for (int k = 0; k < 3; k++) {
                        if (k != j && k != i) {
                            permutations.add("" + chars[i] + chars[j] + chars[k]);
                        } // if
                    } // for
                } // if
            } // for
        } // for

        // finds all valid 3 letter words
        List<String> validWords = new ArrayList<>();
        for (String s : permutations) {
            if (threes.contains(s)) {
                validWords.add(s);
            } // if
        } // for

        // finds all valid four letter words
        List<String> validFours = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (String s: permutations) {
                String temp = c + s;
                if (fours.contains(temp)) {
                    validFours.add(temp);
                } // if
            } // for
        } // fpr

        // prints out all analysis necessary
        System.out.println("There are 6 3-letter permutations. They are:");
        permutations.forEach(System.out::println);
        System.out.println();

        if (validWords.size() == 0) {
            System.out.println("There are none that are valid 3-letter Scrabble words.");
            System.out.println();
        } else {
            System.out.println("The permutations that are valid 3-letter Scrabble words are:");
            validWords.forEach(System.out::println);
            System.out.println();
        } // else

        System.out.println("If one letter is added at the beginning, there are 156 permutations.");
        System.out.println();

        if(validFours.size() == 0) {
            System.out.println("There are none that are valid 4-letter Scrabble words.");
            System.out.println();
        } else {
            System.out.println("The permutations that are valid 3-letter Scrabble words are:");
            validFours.forEach(System.out::println);
            System.out.println();
        } // else

        System.out.println("Depending on the letters on the board,  you have " + validWords.size() + " 3-letter moves and " + validFours.size() + " 4-letter moves.");
    } // main
} // Lab9

package org.javiermf.tuenti8.challenge6;

import org.javiermf.tuenti8.challenge6.graph.Case;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.String.format;

public class Application {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = getScanner();
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCases; i++) {
            int numberOfNotes = scanner.nextInt();
            scanner.nextLine();

            Case aCase = new Case();

            for (int j = 0; j < numberOfNotes; j++) {
                int initPos = scanner.nextInt();
                int length = scanner.nextInt();
                int speed = scanner.nextInt();
                int score = scanner.nextInt();
                scanner.nextLine();

                aCase.addNote(initPos, length, speed, score);
            }

            int maxScore = aCase.maxScore();
            System.out.println(format("Case #%d: %d", i + 1, maxScore));
        }
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
        //File file = new File("/path/to/testInputSubmit.txt");
        //return new Scanner(file);
    }
}

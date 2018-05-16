package org.javiermf.tuenti8.challenge4;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            scanner.nextLine();
            Case aCase = new Case(new Board(rows, columns));

            for (int j = 0; j < rows; j++) {
                String caseRow = scanner.nextLine();
                aCase.addRow(j, caseRow);
            }

            System.out.println(String.format("Case #%d: %s", i + 1, aCase.minSteps()));
        }
    }
}

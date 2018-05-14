package org.javiermf.tuenti8.challenge3;

import org.javiermf.tuenti8.challenge3.scales.ScaleFactory;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ScaleFactory scalesFactory = new ScaleFactory();

    public static void main(String[] args) {
        int numberOfLines = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfLines; i++) {
            int numberOfNotes = scanner.nextInt();
            scanner.nextLine();
            String notesLine = (numberOfNotes > 0) ? scanner.nextLine() : "";

            Melody melody = new Melody(notesLine, scalesFactory);
            SelectedScalesPrinter scalesPrinter = new SelectedScalesPrinter(melody.fittingScales());
            System.out.println(String.format("Case #%d:%s", i + 1, scalesPrinter.toResultFormat()));
        }
    }
}

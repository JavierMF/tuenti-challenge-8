package org.javiermf.tuenti8.challenge1;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfLines = scanner.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            scanner.nextLine();
            int verticalLines = scanner.nextInt();
            int horizontalLines = scanner.nextInt();

            int squares = (verticalLines - 1) * (horizontalLines - 1);
            System.out.println(String.format("Case #%d: %d", i + 1, squares));
        }
    }
}

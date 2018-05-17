package org.javiermf.tuenti8.challenge5;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.err.println("Dicarted: " + scanner.nextLine());
        System.err.println("Dicarted: " + scanner.nextLine());
        System.err.println("Dicarted: " + scanner.nextLine());
        System.err.println("Dicarted: " + scanner.nextLine());
        System.err.println("Dicarted: " + scanner.nextLine());


        System.out.println("SUBMIT");
        while (true) {
            solveCase();
        }
    }

    private static void solveCase() {
        String caseString = scanner.nextLine();
        if (caseString.contains("Timeout")) {
            return;
        }
        System.err.println(caseString);
        Case aCase = new Case(caseString.trim());
        String solved = aCase.solve();
        System.out.println(solved);
        System.err.println(solved);
        System.err.println("Dicarted: " + scanner.nextLine());
    }
}

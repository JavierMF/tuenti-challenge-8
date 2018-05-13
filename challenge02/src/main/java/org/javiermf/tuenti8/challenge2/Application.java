package org.javiermf.tuenti8.challenge2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfLines = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfLines; i++) {
            String code = scanner.nextLine();

            BigDecimal rangeDifference = new BaseDecoder(code).rangeDifference();
            System.out.println(String.format("Case #%d: %s", i + 1, rangeDifference.toBigInteger().toString()));
        }
    }
}

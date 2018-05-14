package org.javiermf.tuenti8.challenge3;

import org.javiermf.tuenti8.challenge3.scales.Scale;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SelectedScalesPrinter {
    private final Set<Scale> scalesToPrint;

    public SelectedScalesPrinter(Set<Scale> scaleSet) {
        this.scalesToPrint = scaleSet;
    }

    public String toResultFormat() {
        if (scalesToPrint.isEmpty()) {
            return " None";
        }

        Stream<Scale> sortedScales = scalesToPrint.stream()
                .sorted(comparing(Scale::getSortingWeight));

        StringBuilder buffer = new StringBuilder();
        sortedScales.forEach((scale -> buffer.append(scale)));
        return buffer.toString();
    }
}

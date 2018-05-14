package org.javiermf.tuenti8.challenge3;

import org.javiermf.tuenti8.challenge3.scales.Scale;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Stream;

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
                .sorted(Comparator.comparing(Scale::getSortingWeight));

        StringBuffer buffer = new StringBuffer();
        sortedScales.forEach((scale -> {
            buffer.append(scale);
        }));
        return buffer.toString();
    }
}

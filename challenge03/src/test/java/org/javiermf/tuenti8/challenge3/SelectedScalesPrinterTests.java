package org.javiermf.tuenti8.challenge3;

import org.javiermf.tuenti8.challenge3.scales.Scale;
import org.javiermf.tuenti8.challenge3.scales.ScaleFactory;
import org.javiermf.tuenti8.challenge3.scales.ScaleMode;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class SelectedScalesPrinterTests {

    private ScaleFactory scaleFactory = new ScaleFactory();

    @Test
    public void deberiImprimirNone() {
        SelectedScalesPrinter printer = new SelectedScalesPrinter(Collections.emptySet());

        assertEquals(" None", printer.toResultFormat());
    }

    @Test
    public void deberiImprimirUnaMaj() {
        Set<Scale> selectedScales = Stream.of(
                scaleFactory.getScale(Note.C, ScaleMode.MAJOR)
        ).collect(Collectors.toSet());

        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MC", printer.toResultFormat());
    }

    @Test
    public void deberiImprimirUnaMin() {
        Set<Scale> selectedScales = Stream.of(
                scaleFactory.getScale(Note.A, ScaleMode.MINOR)
        ).collect(Collectors.toSet());
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" mA", printer.toResultFormat());
    }

    @Test
    public void deberiImprimirUnaSharp() {
        Set<Scale> selectedScales = Stream.of(
                scaleFactory.getScale(Note.F_, ScaleMode.MAJOR)
        ).collect(Collectors.toSet());

        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MF#", printer.toResultFormat());
    }

    @Test
    public void deberiImprimirOrdenadasAlfabeticamente() {
        Set<Scale> selectedScales = Stream.of(
                scaleFactory.getScale(Note.C, ScaleMode.MAJOR),
                scaleFactory.getScale(Note.D, ScaleMode.MAJOR),
                scaleFactory.getScale(Note.A, ScaleMode.MAJOR)
        ).collect(Collectors.toSet());
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MA MC MD", printer.toResultFormat());
    }

    @Test
    public void deberiImprimirPrimeroMajors() {
        Set<Scale> selectedScales = Stream.of(
                scaleFactory.getScale(Note.C, ScaleMode.MINOR),
                scaleFactory.getScale(Note.D, ScaleMode.MAJOR),
                scaleFactory.getScale(Note.A, ScaleMode.MAJOR)
        ).collect(Collectors.toSet());
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MA MD mC", printer.toResultFormat());
    }

    @Test
    public void deberiImprimirDespuesSostenidos() {
        Set<Scale> selectedScales = Stream.of(
                scaleFactory.getScale(Note.C, ScaleMode.MINOR),
                scaleFactory.getScale(Note.A_, ScaleMode.MAJOR),
                scaleFactory.getScale(Note.D, ScaleMode.MAJOR),
                scaleFactory.getScale(Note.A, ScaleMode.MAJOR)
        ).collect(Collectors.toSet());
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MA MA# MD mC", printer.toResultFormat());
    }

    @Test
    public void deberiaImprimirCaso1() {
        String melodyString = "C C G G A A G";
        Set<Scale> selectedScales = new Melody(melodyString, scaleFactory).fittingScales();
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MA# MC MF MG mA mD mE mG", printer.toResultFormat());
    }

    @Test
    public void deberiaImprimirCaso2() {
        String melodyString = "E D# E D# E B D C A";
        Set<Scale> selectedScales = new Melody(melodyString, scaleFactory).fittingScales();
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" None", printer.toResultFormat());
    }

    @Test
    public void deberiaImprimirCaso3() {
        String melodyString = "E D# E F# G# G# F# G# A A G# C# B A G# D# E F# G# G# F# E";
        Set<Scale> selectedScales = new Melody(melodyString, scaleFactory).fittingScales();
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" ME mC#", printer.toResultFormat());
    }

    @Test
    public void deberiaImprimirCaso4() {
        String melodyString = "E";
        Set<Scale> selectedScales = new Melody(melodyString, scaleFactory).fittingScales();
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MA MB MC MD ME MF MG mA mB mC# mD mE mF# mG#", printer.toResultFormat());
    }

    @Test
    public void deberiaImprimirCaso5() {
        String melodyString = "Fb";
        Set<Scale> selectedScales = new Melody(melodyString, scaleFactory).fittingScales();
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MA MB MC MD ME MF MG mA mB mC# mD mE mF# mG#", printer.toResultFormat());
    }

    @Test
    public void deberiaImprimirCaso6() {
        String melodyString = "";
        Set<Scale> selectedScales = new Melody(melodyString, scaleFactory).fittingScales();
        SelectedScalesPrinter printer = new SelectedScalesPrinter(selectedScales);

        assertEquals(" MA MA# MB MC MC# MD MD# ME MF MF# MG MG# mA mA# mB mC mC# mD mD# mE mF mF# mG mG#", printer.toResultFormat());
    }
}

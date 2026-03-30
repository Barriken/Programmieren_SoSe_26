package de.tha.prog2.airport.staff;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PilotTest {

    @Test
    void rankShouldProvideCorrectBaseSalary() {
        assertEquals(5000.0, Rank.COPILOT.getBaseSalary());
        assertEquals(7000.0, Rank.FIRST_OFFICER.getBaseSalary());
        assertEquals(9000.0, Rank.CAPTAIN.getBaseSalary());
    }

    @Test
    void pilotShouldStartWithSalaryOfGivenRank() {
        Pilot pilot = new Pilot("Mustermann", "Max", Rank.COPILOT);

        assertEquals(5000.0, pilot.calculateSalary());
    }

    @Test
    void firstPromotionShouldPromoteToFirstOfficer() {
        Pilot pilot = new Pilot("Mustermann", "Max", Rank.COPILOT);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            pilot.promote();
        } finally {
            System.setOut(original);
        }

        assertEquals(7000.0, pilot.calculateSalary());
        assertEquals("Max Mustermann promoted to FIRST_OFFICER." + System.lineSeparator(), out.toString());
    }

    @Test
    void secondPromotionShouldPromoteToCaptain() {
        Pilot pilot = new Pilot("Mustermann", "Max", Rank.FIRST_OFFICER);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            pilot.promote();
        } finally {
            System.setOut(original);
        }

        assertEquals(9000.0, pilot.calculateSalary());
        assertEquals("Max Mustermann promoted to CAPTAIN." + System.lineSeparator(), out.toString());
    }

    @Test
    void captainPromotionShouldPrintHighestRankMessage() {
        Pilot pilot = new Pilot("Mustermann", "Max", Rank.CAPTAIN);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            pilot.promote();
        } finally {
            System.setOut(original);
        }

        assertEquals(9000.0, pilot.calculateSalary());
        assertEquals("Max Mustermann is already at highest rank." + System.lineSeparator(), out.toString());
    }
}

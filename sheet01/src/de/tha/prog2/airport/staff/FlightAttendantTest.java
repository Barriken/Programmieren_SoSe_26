package de.tha.prog2.airport.staff;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightAttendantTest {

    @Test
    void flightAttendantShouldStartWithDefaultSalary() {
        FlightAttendant attendant = new FlightAttendant("Mustermann", "Max");

        assertEquals(3500.0, attendant.calculateSalary());
    }

    @Test
    void firstPromotionShouldIncreaseSalaryAndPrintMessage() {
        FlightAttendant attendant = new FlightAttendant("Mustermann", "Max");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            attendant.promote();
        } finally {
            System.setOut(original);
        }

        assertEquals(4025.0, attendant.calculateSalary(), 0.01);
        assertEquals("Max Mustermann promoted to lead flight attendant." + System.lineSeparator(), out.toString());
    }

    @Test
    void secondPromotionShouldNotChangeSalaryAndShouldPrintAlreadyLeadMessage() {
        FlightAttendant attendant = new FlightAttendant("Mustermann", "Max");
        attendant.promote();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            attendant.promote();
        } finally {
            System.setOut(original);
        }

        assertEquals(4025.0, attendant.calculateSalary(), 0.01);
        assertEquals("Max Mustermann is already a lead flight attendant." + System.lineSeparator(), out.toString());
    }
}

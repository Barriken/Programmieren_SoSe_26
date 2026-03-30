package de.tha.prog2.airport.staff;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroundStaffTest {

    @Test
    void departmentShouldProvideCorrectBaseSalary() {
        assertEquals(3500.0, Department.TECHNICAL.getBaseSalary());
        assertEquals(3000.0, Department.HANDLING.getBaseSalary());
        assertEquals(3200.0, Department.SECURITY.getBaseSalary());
        assertEquals(2800.0, Department.CHECK_IN.getBaseSalary());
    }

    @Test
    void groundStaffShouldStartWithDepartmentSalaryAndZeroOvertime() {
        GroundStaff staff = new GroundStaff("Mustermann", "Max", Department.CHECK_IN);

        assertEquals(2800.0, staff.calculateSalary());
    }

    @Test
    void addExtraTimeWithoutParameterShouldAddOneHour() {
        GroundStaff staff = new GroundStaff("Mustermann", "Max", Department.CHECK_IN);
        staff.addExtraTime();

        assertEquals(2800.0 + 2800.0 / 160.0, staff.calculateSalary());
    }

    @Test
    void addExtraTimeWithParameterShouldAddGivenHours() {
        GroundStaff staff = new GroundStaff("Mustermann", "Max", Department.CHECK_IN);
        staff.addExtraTime(10);

        assertEquals(2800.0 + 2800.0 * 10 / 160.0, staff.calculateSalary());
    }

    @Test
    void promoteShouldIncreaseSalaryByFivePercentAndPrintMessage() {
        GroundStaff staff = new GroundStaff("Mustermann", "Max", Department.CHECK_IN);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            staff.promote();
        } finally {
            System.setOut(original);
        }

        assertEquals(2800.0 * 1.05, staff.calculateSalary());
        assertEquals("Max Mustermann promoted to level 1." + System.lineSeparator(), out.toString());
    }

    @Test
    void fourthPromotionShouldNotChangeSalaryAndShouldPrintMessage() {
        GroundStaff staff = new GroundStaff("Mustermann", "Max", Department.CHECK_IN);
        staff.promote();
        staff.promote();
        staff.promote();
        double salaryAfterThirdPromotion = staff.calculateSalary();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            staff.promote();
        } finally {
            System.setOut(original);
        }

        assertEquals(salaryAfterThirdPromotion, staff.calculateSalary());
        assertEquals("Max Mustermann cannot be promoted further." + System.lineSeparator(), out.toString());
    }

    @Test
    void changeDepartmentShouldResetLevelKeepOvertimeAndPrintMessage() {
        GroundStaff staff = new GroundStaff("Mustermann", "Max", Department.CHECK_IN);
        staff.promote();
        staff.addExtraTime();
        staff.addExtraTime(7);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            staff.changeDepartment(Department.SECURITY);
        } finally {
            System.setOut(original);
        }

        assertEquals(3200.0 + 3200.0 * 8 / 160.0, staff.calculateSalary());
        assertEquals("Max Mustermann changed department from CHECK_IN to SECURITY." + System.lineSeparator(), out.toString());
    }
}

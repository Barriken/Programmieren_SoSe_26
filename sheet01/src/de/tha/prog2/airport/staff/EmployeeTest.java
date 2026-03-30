package de.tha.prog2.airport.staff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;

class EmployeeTest {

    private static class DummyEmployee extends Employee {
        DummyEmployee(String lastName, String firstName, double baseSalary) {
            super(lastName, firstName, baseSalary);
        }

        @Override
        public void promote() {
            // nothing to do for test double
        }
    }

    static DummyEmployee first;
    static DummyEmployee second;
    
    @BeforeAll
    static void setupEmployees() {
    	first = new DummyEmployee("Mustermann", "Max", 3500.0);
    	second = new DummyEmployee("Schmidt", "Anna", 4200.0);
    }
    
    @Test
    void employeeIdsShouldBeAssignedSequentially() {
        assertEquals(1, first.getEmployeeId());
        assertEquals(2, second.getEmployeeId());
    }

    @Test
    void calculateSalaryShouldReturnBaseSalary() {
        assertEquals(3500.0, first.calculateSalary());
    }

    @Test
    void toStringShouldMatchRequiredFormat() {
        assertEquals(
                "Employee{id=1, lastName=Mustermann, firstName=Max, baseSalary=3500.0}",
                first.toString()
        );
    }
}

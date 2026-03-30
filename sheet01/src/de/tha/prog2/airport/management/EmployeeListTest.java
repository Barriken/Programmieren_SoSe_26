package de.tha.prog2.airport.management;

import de.tha.prog2.airport.staff.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeListTest {

    @Test
    void addShouldInsertEmployeesInSortedOrder() {
        EmployeeList employeeList = new EmployeeList();

        Employee flightAttendant = new FlightAttendant("Mustermann", "Max");   // id 1
        Employee pilot = new Pilot("Schmidt", "Anna", Rank.COPILOT);           // id 2
        Employee groundStaff = new GroundStaff("Mueller", "Tom", Department.SECURITY); // id 3

        // bewusst unsortiert hinzufügen
        employeeList.add(groundStaff);
        employeeList.add(flightAttendant);
        employeeList.add(pilot);

        String expected =
                flightAttendant + "\n" +
                pilot + "\n" +
                groundStaff;

        assertEquals(expected, employeeList.toString());
    }

    @Test
    void removeShouldDeleteEmployeeById() {
        EmployeeList employeeList = new EmployeeList();

        Employee flightAttendant = new FlightAttendant("Mustermann", "Max");
        Employee pilot = new Pilot("Schmidt", "Anna", Rank.COPILOT);

        employeeList.add(flightAttendant);
        employeeList.add(pilot);

        employeeList.remove(flightAttendant.getEmployeeId());

        assertEquals(pilot.toString(), employeeList.toString());
    }

    @Test
    void removeWithUnknownIdShouldNotChangeList() {
        EmployeeList employeeList = new EmployeeList();

        Employee flightAttendant = new FlightAttendant("Mustermann", "Max");
        Employee pilot = new Pilot("Schmidt", "Anna", Rank.COPILOT);

        employeeList.add(flightAttendant);
        employeeList.add(pilot);

        String originalState = employeeList.toString();

        employeeList.remove(999);

        assertEquals(originalState, employeeList.toString());
    }

    @Test
    void getPilotsShouldReturnOnlyPilotObjects() {
        EmployeeList employeeList = new EmployeeList();

        Employee flightAttendant = new FlightAttendant("Mustermann", "Max");
        Employee firstPilot = new Pilot("Schmidt", "Anna", Rank.COPILOT);
        Employee groundStaff = new GroundStaff("Mueller", "Tom", Department.SECURITY);
        Employee secondPilot = new Pilot("Klein", "Eva", Rank.FIRST_OFFICER);

        employeeList.add(flightAttendant);
        employeeList.add(firstPilot);
        employeeList.add(groundStaff);
        employeeList.add(secondPilot);

        EmployeeList pilotList = employeeList.getPilots();

        String expected =
                firstPilot + "\n" +
                secondPilot;

        assertEquals(expected, pilotList.toString());
    }

    @Test
    void getGroundStaffShouldReturnOnlyGroundStaffObjects() {
        EmployeeList employeeList = new EmployeeList();

        Employee firstGroundStaff = new GroundStaff("Mueller", "Tom", Department.SECURITY);
        Employee pilot = new Pilot("Schmidt", "Anna", Rank.COPILOT);
        Employee secondGroundStaff = new GroundStaff("Klein", "Eva", Department.CHECK_IN);

        employeeList.add(firstGroundStaff);
        employeeList.add(pilot);
        employeeList.add(secondGroundStaff);

        EmployeeList groundStaffList = employeeList.getGroundStaff();

        String expected =
                firstGroundStaff + "\n" +
                secondGroundStaff;

        assertEquals(expected, groundStaffList.toString());
    }

    @Test
    void getFlightAttendantsShouldReturnOnlyFlightAttendantObjects() {
        EmployeeList employeeList = new EmployeeList();

        Employee firstAttendant = new FlightAttendant("Mustermann", "Max");
        Employee pilot = new Pilot("Schmidt", "Anna", Rank.COPILOT);
        Employee secondAttendant = new FlightAttendant("Klein", "Eva");

        employeeList.add(firstAttendant);
        employeeList.add(pilot);
        employeeList.add(secondAttendant);

        EmployeeList attendantList = employeeList.getFlightAttendants();

        String expected =
                firstAttendant + "\n" +
                secondAttendant;

        assertEquals(expected, attendantList.toString());
    }

    @Test
    void filterMethodsShouldNotModifyOriginalList() {
        EmployeeList employeeList = new EmployeeList();

        Employee flightAttendant = new FlightAttendant("Mustermann", "Max");
        Employee pilot = new Pilot("Schmidt", "Anna", Rank.COPILOT);

        employeeList.add(flightAttendant);
        employeeList.add(pilot);

        String originalState = employeeList.toString();

        employeeList.getPilots();
        employeeList.getGroundStaff();
        employeeList.getFlightAttendants();

        assertEquals(originalState, employeeList.toString());
    }
}
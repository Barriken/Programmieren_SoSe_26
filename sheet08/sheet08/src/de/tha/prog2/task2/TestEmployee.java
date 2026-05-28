package de.tha.prog2.task2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

public class TestEmployee {
	@Test
	public void testEmployeeAttributes() throws Exception {
		assertTrue(TestClassHandler.classExists(TestClassNames.EMPLOYEE_CLASS));
		assertTrue(TestClassHandler.methodExistsWithReturnType(TestClassNames.EMPLOYEE_CLASS, "getName", String.class));
		assertTrue(TestClassHandler.methodExistsWithReturnType(TestClassNames.EMPLOYEE_CLASS, "getDepartment", String.class));
		assertTrue(TestClassHandler.methodExistsWithReturnType(TestClassNames.EMPLOYEE_CLASS, "getYearsEmployed", double.class));
		assertTrue(TestClassHandler.methodExistsWithReturnType(TestClassNames.EMPLOYEE_CLASS, "getEmployeeID", int.class));
		@SuppressWarnings("unused")
		Constructor<?> constructor = Class.forName(TestClassNames.EMPLOYEE_CLASS).getConstructor(int.class, String.class, String.class, double.class);
		
	}
}

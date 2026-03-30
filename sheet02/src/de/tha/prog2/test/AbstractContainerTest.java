package de.tha.prog2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import de.tha.prog2.AbstractContainer;

class AbstractContainerTest {

	/**
	 * Minimale Testklasse für AbstractContainer
	 */
	private class TestContainer extends AbstractContainer {

		private java.util.List<Object> arrayList = new ArrayList<>();

		@Override
		public boolean add(Object o) {
			return arrayList.add(o);
		}

		@Override
		public Object get(int i) {
			return arrayList.get(i);
		}

		@Override
		public int size() {
			return arrayList.size();
		}

		@Override
		public boolean remove(Object o) {
			return arrayList.remove(o);
		}
	}

	@Test 
	void testNotEquals() {
		TestContainer tc1 = new TestContainer();
		TestContainer tc2 = new TestContainer();

		tc1.add("Test1");
		tc1.add("Test2"); 

		tc2.add("Test2"); 
		tc2.add("Test2"); 
		assertNotEquals(tc1, tc2); 

	} 

	@Test 
	void testEquals() { 
		TestContainer tc1 = new TestContainer(); 
		TestContainer tc2 = new TestContainer(); 

		tc1.add("Test1"); 
		tc1.add("Test2"); 

		tc2.add("Test1"); 
		tc2.add("Test2"); 

		assertEquals(tc1, tc2); 

	} 

	@Test 
	void testToString() { 
		TestContainer tc = new TestContainer(); 
		tc.add("Test1"); 
		tc.add("Test2"); 
		String result = tc.toString(); 

		assertNotNull(result); 
		assertTrue(result.contains("Test1")); 
		assertTrue(result.contains("Test2")); 
	} 
}
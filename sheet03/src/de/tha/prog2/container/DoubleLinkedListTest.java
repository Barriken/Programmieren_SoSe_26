package de.tha.prog2.container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    private Container list;

    @BeforeEach
    void setup() throws Exception {
        boolean myContainerTestExists = classExists("de.tha.prog2.container.MyContainerTest");
        assertTrue(myContainerTestExists, "Schreiben zunächst eigene Test in MyContainerTest.");

        list = new DoubleLinkedList();
    }

    private boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Test
    void testAddAndSize() {
        assertTrue(list.add("A"));
        assertTrue(list.add("B"));
        assertEquals(2, list.size());
    }

    @Test
    void testGetValidIndex() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));
    }

    @Test
    void testGetInvalidIndexThrowsException() {
        list.add("A");
        list.add("B");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void testRemoveExistingElement() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.remove("B"));
        assertEquals(2, list.size());
        assertEquals("C", list.get(0));
        assertEquals("A", list.get(1));
    }

    @Test
    void testRemoveNonExistentElement() {
        list.add("A");
        list.add("B");

        assertFalse(list.remove("X"));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirstElement() {
        list.add("A");
        list.add("B");

        assertTrue(list.remove("B"));
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    void testRemoveLastElement() {
        list.add("A");
        list.add("B");

        assertTrue(list.remove("A"));
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }
}
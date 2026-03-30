package de.tha.prog2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.tha.prog2.Container;

abstract class ContainerBasicTest {

    protected abstract Container createContainer();

    @Test
    void testAddAndSize() {
        Container c = createContainer();

        assertEquals(0, c.size());

        c.add("A");
        c.add("B");

        assertEquals(2, c.size());
    }

    @Test
    void testGet() {
        Container c = createContainer();

        c.add("A");
        c.add("B");
        c.add("C");

        assertEquals("A", c.get(0));
        assertEquals("B", c.get(1));
        assertEquals("C", c.get(2));
    }

    @Test
    void testRemove() {
        Container c = createContainer();

        c.add("A");
        c.add("B");
        c.add("C");

        boolean removed = c.remove("B");

        assertTrue(removed);
        assertEquals(2, c.size());
        assertEquals("A", c.get(0));
        assertEquals("C", c.get(1));
    }

    @Test
    void testRemoveNonExisting() {
        Container c = createContainer();

        c.add("A");
        c.add("B");

        boolean removed = c.remove("X");

        assertFalse(removed);
        assertEquals(2, c.size());
    }
}
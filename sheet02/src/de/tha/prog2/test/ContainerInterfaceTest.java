package de.tha.prog2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import de.tha.prog2.Container;

class ContainerInterfaceTest {

    private Container createContainer() {
        return new Container() {
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
        };
    }

    @Test
    void testIsEmpty() {
        Container container = createContainer();

        assertTrue(container.isEmpty());
        assertEquals(0, container.size());

        container.add("Test");

        assertFalse(container.isEmpty());
        assertEquals(1, container.size());
    }

    @Test
    void testContains() {
        Container container = createContainer();

        String s1 = new String("Test String");
        String s2 = new String("Zweiter Test String");

        container.add(s1);
        container.add(s2);

        assertTrue(container.contains(s1));
        assertTrue(container.contains(s2));
        assertFalse(container.contains("Nicht im Container"));
    }

    @Test
    void testToArray() {
        Container container = createContainer();

        container.add("Test String");
        container.add("Zweiter Test String");
        container.add("Dritter Test String");

        Object[] array = container.toArray();

        assertEquals(3, array.length);
        assertEquals("Test String", array[0]);
        assertEquals("Zweiter Test String", array[1]);
        assertEquals("Dritter Test String", array[2]);
    }

    @Test
    void testClear() {
        Container container = createContainer();

        container.add("Test String");
        container.add("Zweiter Test String");
        container.add("Dritter Test String");

        assertEquals(3, container.size());

        container.clear();

        assertEquals(0, container.size());
    }
}
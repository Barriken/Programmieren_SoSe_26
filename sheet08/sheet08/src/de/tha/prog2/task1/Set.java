package de.tha.prog2.task1;

import java.util.Enumeration;

public interface Set<E> {
    boolean add(E e);
    boolean test(E e);
    boolean remove(E e);
    Enumeration<E> elements();
}

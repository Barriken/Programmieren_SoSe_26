package de.tha.prog2.task1;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public abstract class AbstractSet<T>  {
	
	protected DoubleLinkedList content = new DoubleLinkedList();
	
	public boolean remove (T obj) {
		if (test(obj)) {
			content.remove(obj);
			return true;
		}
		return false;
	}
	
	public Enumeration elements() {
		Object[] array = content.toArray();
		return Collections.enumeration(List.of(array));
	}
	
	public boolean test (T obj) {
		if (content.contains(obj)) {
			return true;
		}
		return false;
	}
}

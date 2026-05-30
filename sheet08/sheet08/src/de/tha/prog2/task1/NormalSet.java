package de.tha.prog2.task1;

public class NormalSet <T> extends AbstractSet<T> {
	public boolean add (T obj) {
		if (!test(obj)) {
			content.add(obj);
			return true;
		}
		return false;
	}
}
	
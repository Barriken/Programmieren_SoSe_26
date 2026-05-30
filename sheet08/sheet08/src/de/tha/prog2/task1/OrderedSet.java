package de.tha.prog2.task1;

public class OrderedSet <T extends Comparable> extends AbstractSet<T>{
	
	public boolean add (T obj) {
		if (!test(obj)) {
			int currentIndex = 0;
			while (obj.compareTo(content.get(currentIndex)) < 0) {
				currentIndex++;
			}
			content.insert(obj, currentIndex);
			return true;
		}
		return false;
	}
}

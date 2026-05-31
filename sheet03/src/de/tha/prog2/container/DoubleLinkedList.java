package de.tha.prog2.container;

import de.tha.prog2.task1.ListElement;

public class DoubleLinkedList extends AbstractContainer {

	public ListElement head;
	public ListElement tail;
	
	public boolean add(Object o) {
		if (head == null) {
			ListElement newElement = new ListElement(o, null, null);
			
			head = newElement;
			tail = newElement;
		}
		else {
			ListElement newElement = new ListElement(o, null, null);
			newElement.next = head;
			head.prev = newElement;
			head = newElement;
		}
		return true;
	}

	public Object get(int i) {
		
		
		if (i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListElement currentElement = head;
		for (int j = 1; j <= i; j++) {
			currentElement = currentElement.next;
			
			if (currentElement == null) {
				throw new IndexOutOfBoundsException();
			}
		}
		return currentElement.content;
	}

	public int size() {
		ListElement currentElement = head;
		if (currentElement == null) {
			return 0;
		}
		int size = 1;
		
		currentElement = currentElement.next;
		while (currentElement != null) {
			currentElement = currentElement.next;
			size++;
		}
		return size;
	}
	
	public<T> boolean insert(T o, int index) {
		int currentIndex = 0;
		ListElement currentElement = head;
		do {
			if (currentIndex == index) {
				ListElement hilfsV = currentElement;
				currentElement = new ListElement(o, hilfsV, hilfsV.prev);
				currentElement.next.prev = currentElement;
				return true;
			}
			currentElement = currentElement.next;
			currentIndex++;
		} while (currentIndex != index);
		return false;
	}
	
	public boolean remove(Object o) {
		ListElement currentElement = head;
		
		while(currentElement != null) {
			
			if (currentElement.content.equals(o)) {
				
				if (!head.equals(currentElement) && !tail.equals(currentElement)) {
					currentElement.prev.next = currentElement.next;
					currentElement.next.prev = currentElement.prev;
					return true;
				}
				if (head.equals(currentElement)) {
					head = currentElement.next;
					head.prev = null;
				}
				if (tail.equals(currentElement)){
					tail = currentElement.prev;
					tail.next = null;
				}
				return true;
			}
			else {
				currentElement = currentElement.next;
			}
		}
		return false;
	}


}

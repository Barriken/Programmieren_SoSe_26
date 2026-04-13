package de.tha.prog2.container;

public class ListElement {
	
	public ListElement (Object content, Object next, Object prev){
		this.content = content;
		this.next = next;
		this.prev = prev;
	}
	
	public Object content;
	
	public Object next;
	public Object prev;
}

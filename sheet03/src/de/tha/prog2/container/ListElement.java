package de.tha.prog2.container;

public class ListElement {
	
	public ListElement (Object content, ListElement next, ListElement prev){
		this.content = content;
		this.next = next;
		this.prev = prev;
	}
	
	public Object content;
	
	public ListElement next;
	public ListElement prev;
}

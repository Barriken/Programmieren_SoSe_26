package de.tha.prog2.task1;

import java.util.Iterator;
import java.util.List;

import de.tha.prog2.tools.TextProvider;

public class Task1 {
	public static void main(String[]args) {
		TextProvider provider = new TextProvider();

	
		for(String zeile : provider) {
			System.out.println(zeile);
		}
	}
	
	public void countChars() {
		
	}
}
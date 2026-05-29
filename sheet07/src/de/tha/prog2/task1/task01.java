package de.tha.prog2.task1;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.TreeMap;

import de.tha.prog2.tools.TextProvider;

public class task01 {
	public static void main (String [] args) 
	{
		TextProvider provider = new TextProvider();
		
		for ( String s : provider) 
		{
			System.out.println(s);
		}
		
		TextOperations op = new TextOperations();
		op.countChars(new HashMap<Character, Integer>(), new TextProvider());
		
		op.countChars(new TreeMap<Character, Integer>().descendingMap(), new TextProvider());
		
		op.countChars(new TreeMap<Character, Integer>(), new TextProvider());

	}
}

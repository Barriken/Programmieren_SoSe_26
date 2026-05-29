package de.tha.prog2.task1;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import de.tha.prog2.tools.TextProvider;

public class TextOperations
{
	public void countChars(Map<Character, Integer> map, TextProvider provider) 
	{
		for (String s : provider) 
		{
			s = s.toLowerCase();
			for (char c : s.toCharArray()) 
			{
				if (c >= 'a' && c <= 'z') 
				{
					if (map.containsKey(c)) 
					{
						int counter = map.get(c);
						map.put(c, counter + 1);
					}
					else {
						map.put(c, 1);
					}
				}
			}
		}
		
		map.forEach((key, value) -> { System.out.println(key + "->" + value);});
		
		System.out.println("Häufigster Buchstabe:" + Collections.max(map.entrySet(), Map.Entry.comparingByValue()));
	}

}
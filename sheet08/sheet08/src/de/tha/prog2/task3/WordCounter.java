package de.tha.prog2.task3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import de.tha.prog2.task3.Word.Position;

public class WordCounter {

    // Reader zum Einlesen der Zeichenquelle
    private Reader reader;

    private HashMap<Word, Integer> wordMap = new HashMap<Word, Integer>();
    
    // Konstruktor speichert den uebergebenen Reader
    public WordCounter(Reader reader) {
        this.reader = reader;
    }

    public void read() throws IOException {

        // BufferedReader ermoeglicht das zeilenweise Lesen
        BufferedReader br = new BufferedReader(reader);

        // Erste Zeile einlesen
        String line = br.readLine();

        // Solange noch Zeilen vorhanden sind
        while (line != null) 
        {
        	var allWords = line.split(" ");
        	int currentWord = 1;
        	int wordCounter = allWords.length;
        	
        	for (String w : allWords) 
        	{
        		if (wordCounter == 1) 
        		{
        			Word[] ws =  {new Word(w.toLowerCase(), Position.START), 
        					new Word(w.toLowerCase(), Position.END), 
        					new Word(w.toLowerCase(), Position.MIDDLE) };
        			
        			for (Word w2 : ws) {
        				if (wordMap.containsKey(w2)) {
        					wordMap.put(w2, wordMap.get(w2) + 1);
        				}
        				else {
        					wordMap.put(w2, 1);
        				}
        			}
        		}
        		else {
        			Word cw = new Word(w.toLowerCase(), Position.MIDDLE);
        			if (currentWord == 1) {
        				 cw = new Word(w.toLowerCase(), Position.START);
        				
        			}
        			else if (currentWord == wordCounter) {
        				 cw = new Word(w.toLowerCase(), Position.END);
        			}
        			if (wordMap.containsKey(cw)) {
    					wordMap.put(cw, wordMap.get(cw) + 1);
    				}
    				else {
    					wordMap.put(cw, 1);
    				}
        			
        		}
        		currentWord++;
        	}
            // TODO:
            // - Zeile in Woerter zerlegen
            // - Position der Woerter bestimmen
            // - Word-Objekte erzeugen
            // - Woerter in der Map zaehlen

            System.out.println(line);

            // Naechste Zeile einlesen
            line = br.readLine();
        }
    }
    
    public Map<Word, Integer> getWordMap(){
    	return wordMap;
    }

    public static void main(String[] args) throws IOException {

        // Datei oeffnen und Reader erzeugen (Decorator Pattern!)
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(
                    new File("src/de/tha/prog2/task3/dummy.txt")
                )
            )
        );

        // WordCounter erzeugen
        WordCounter counter = new WordCounter(reader);

        // Text einlesen und verarbeiten
        counter.read();
    }
}
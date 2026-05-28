package de.tha.prog2.task3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    // Reader zum Einlesen der Zeichenquelle
    private Reader reader;

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
        while (line != null) {

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
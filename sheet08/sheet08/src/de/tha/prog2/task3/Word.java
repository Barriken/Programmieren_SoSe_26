package de.tha.prog2.task3;

import java.util.Objects;

public class Word {
	
	public Word(String word, Position position) {
		this.word = word.toLowerCase();
		this.position = position;
	}
	private String word;
	
	public enum Position {
		START,
		MIDDLE,
		END
	}
	
	private Position position;
	
	public String getWord() {
		return this.word;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
	Word other = (Word) obj;
		return (this.word.equals(other.getWord()) && this.position == other.getPosition());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(word, position);
	}
}

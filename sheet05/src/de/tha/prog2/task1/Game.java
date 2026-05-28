package de.tha.prog2.task1;

public interface Game {
	public int getPoints();
	public boolean recordAnswer(String answer);
	public String nextQuestion();
	public boolean hasMoreQuestions();
}

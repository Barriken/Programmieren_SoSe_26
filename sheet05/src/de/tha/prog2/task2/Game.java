package de.tha.prog2.task2;

public interface Game {
	public int getPoints();
	public boolean recordAnswer(String answer);
	public String nextQuestion();
	public boolean hasMoreQuestions();
}

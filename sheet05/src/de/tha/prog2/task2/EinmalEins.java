package de.tha.prog2.task2;

import java.util.Random;

public class EinmalEins implements GameDefinition{
	public EinmalEins() {
		
	}
	
	public Game getGame(int questions) {
		
		return new EinmalEinsGame(questions);
	}
	
	public static class EinmalEinsGame implements Game{
		public EinmalEinsGame(int questions) {
			numberOfQuestions = questions;
			answeredQuestions = 0;
		}

		private int numberOfQuestions;
		private int answeredQuestions;
		private int points;
		
		private int currentNumber1;
		private int currentNumber2;
		
		
		public String nextQuestion() {
			Random rnd = new Random();
			currentNumber1 = rnd.nextInt(1, 11);
			currentNumber2 = rnd.nextInt(1, 11);
			return "Wie viel ist " + currentNumber1 + " * " + currentNumber2 + "?";
		}

		@Override
		public int getPoints() {
			return this.points;
		}

		@Override
		public boolean recordAnswer(String answer) {
			if (Integer.parseInt(answer) == currentNumber1 * currentNumber2) {
				points++;
				answeredQuestions++;
				return true;
			}
			answeredQuestions++;
			return false;
		}

		@Override
		public boolean hasMoreQuestions() {
			return (numberOfQuestions > answeredQuestions);
		}
		
	}
}

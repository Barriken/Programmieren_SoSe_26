package de.tha.prog2.task1;

public class EinmalEins implements GameDefinition{
	public EinmalEins() {
		
	}
	
	public Game getGame(int questions) {
		
		return new EinmalEinsGame(questions);
	}
	
	public static class EinmalEinsGame implements Game{
		public EinmalEinsGame(int questions) {
			
		}

		@Override
		public int getPoints() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean recordAnswer(String answer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String nextQuestion() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasMoreQuestions() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}

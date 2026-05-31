package de.tha.prog2.task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class QuestionGame {
	protected GameDefinition gameDefinition;
	protected Game game;
	
	protected Player player;
	
	private HighScore highScore = new HighScore();;
	
	public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		QuestionGame newGame = new QuestionGame();
		newGame.gameLoop();
	}
	
	public void gameLoop() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		
		System.out.println("Spielername: ");
		Scanner scan1 = new Scanner( System.in);
		player = new Player(scan1.next());
		
		
		System.err.println("Welches Spiel?");
		Scanner scan2 = new Scanner( System.in);
		String input = scan2.next();
		
		createGameDefinition(input);
	}
	
	public void createGameDefinition(String input) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Class<?> kek = Class.forName("de.tha.prog2.task2." + input);
		Object obj = kek.getDeclaredConstructor().newInstance();
		
		Method method = kek.getDeclaredMethod("getGame", int.class);
		game = (Game) method.invoke(obj, 5);
		
		while (game.hasMoreQuestions()) 
		{
			System.out.println(game.nextQuestion());
			Scanner scan = new Scanner( System.in);
			if (game.recordAnswer(scan.next())) {
				player.recordPoints(1);
			}
			
		}
		highScore.recordEntry(player);
		highScore.toString();
	}
}

package debug;

import java.util.Random;
import java.util.Scanner;

public class CalculatorQuiz {
	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);

	public static void askQuestion() {
		float number1 = (float) random.nextInt(100) / 10;
		float number2 = (float) random.nextInt(100) / 10;
		
		System.out.print(String.format("Please answer: %.1f + %.1f = ? \n> ", number1, number2));
		
		float answer = 0;
		try {
			answer = scanner.nextFloat();
		} catch (java.util.InputMismatchException e) {
			System.out.println(String.format("Wrong answer! Correct answer is: %.1f", number1 + number2));
			scanner.nextLine(); // discard input
			return;
		}
		
		if (answer == number1 + number2) {
			System.out.println("Your answer is correct!");
		} else {
			System.out.println(String.format("Wrong answer! Correct answer is: %.1f", number1 + number2));
		}		
	}
	
	public static void main(String[] args) {
		while (true) {
			askQuestion();
		}
	}

}

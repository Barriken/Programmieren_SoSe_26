package debug;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class CalculatorQuizBigDecimal {
	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	
	public static void askQuestion1() {
		BigDecimal number1 = new BigDecimal((float) random.nextInt(100) / 10).setScale(1, RoundingMode.HALF_UP);
		BigDecimal number2 = new BigDecimal((float) random.nextInt(100) / 10).setScale(1, RoundingMode.HALF_UP);
		
		System.out.print(String.format("Please answer: %.1f + %.1f = ? \n> ", number1, number2));
		
		BigDecimal answer;
		try {
			answer = new BigDecimal(scanner.nextFloat()).setScale(1, RoundingMode.HALF_UP);
		} catch (java.util.InputMismatchException e) {
			System.out.println("Wrong answer! Correct answer is: " + number1.add(number2));
			scanner.nextLine(); // discard input
			return;
		} 
		
		if (answer.compareTo(number1.add(number2)) == 0) {
			System.out.println("Your answer is correct!");
		} else {
			System.out.println("Wrong answer! Correct answer is: " + number1.add(number2));
		}		
	}
	
	public static void main(String[] args) {
		while (true) {
			askQuestion1();
		}
	}

}
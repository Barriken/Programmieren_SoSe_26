package debug;

import java.util.Random;

public class DebugMe {	
	public static void main(String[] args) {
		int[] array = new int[100];
		Random random = new Random();
		for (int i = 1; i != random.nextInt(1000); ++i) {
			int index = random.nextInt(i);
			System.out.println("Value of array at pos " + index + " is " + array[index]);
		}
	}
}

package lc2.task1;

public class RoundCalculator {
	public Calculator getCalculator() {
		return new Calculator() {
			public double log10(double value) {
				return Math.ceil(Math.log10(value));
			}

			@Override
			public double multiply(double a, double b) {
				return Math.ceil(a * b);
			}
		};
	}
}

package lc2.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void testLog10() {
		RoundCalculator rcalc = new RoundCalculator();
		Calculator calc = rcalc.getCalculator();
		assertEquals( 3.0d, calc.log10(101));
		assertEquals( 3.0d, calc.log10(999));
		assertEquals(0.0d, calc.log10(1));
	}
	
	
	@Test
	public void testMultiply() {
		RoundCalculator rcalc = new RoundCalculator();
		Calculator calc = rcalc.getCalculator();
		assertEquals( 8.0d, calc.multiply(2.5d, 3d));
		assertEquals( 1.0d, calc.multiply(0.1d, 0.1d));
	}
	

}

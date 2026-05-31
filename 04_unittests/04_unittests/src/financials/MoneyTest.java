package financials;

import financials.Money;
import financials.NoNegMoney;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {
	private final Money money1 = new Money(30);
	private final Money money2 = new Money(20);
	private Money money3 = new Money(100);
	private Money money4 = new Money(200);
	private static int staticTest = 0;
	
	MoneyTest() {
		System.out.println("Newly created instance of MoneyTest");
	}

	@BeforeEach
	void setUp() {
        staticTest++;
		System.out.println("BeforeEach");
        System.out.println("     money1 = " + money1 + " money2 = " + money2 + " money 3: " + money3 + " money4: " + money4);
        System.out.println("     Beware of static members in TestCases: " + staticTest);
        System.out.println("     Beware of static members in tested Classes: " + money1.getCounter());
	}

	@AfterEach
	void tearDown() {
        System.out.println("AfterEach");
	}

	@BeforeAll
	static void setupBeforeAll() {
        System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterAll() {
        System.out.println("AfterAll");
	}
	
	@Test
	public void testAdd() {
        System.out.println("testAdd");
		assertEquals(new Money(50), money1.add(money2), "30+20=50");
		// change money3 and money4  in testAdd to see the effects (if any) in subsequent tests
		money3 = money3.add(money1);
		money4 = money4.add(money1);
		System.out.println("  Values of money3: " + money3 + " money4: " + money4);
	}

	@Test
	public void testSubtract() {
        System.out.println("testSubstract");
		assertEquals(new Money(10), money1.subtract(money2), "30-20=10");
	}

	@Test
	public void testNegativeMoney() {
        System.out.println("testNegativeNumber");
		assertThrows( NoNegMoney.class, () -> { money2.subtract(money1); });
	}
	
	@Test
	public void testNegativeMoneyWithoutLambdas() {
		System.out.println("testNegativeMoneyWithoutLambdas");
		try {
			money2.subtract(money1);
			// this should throw an exception so the next line
			// should never be reached
			fail("testNegativeMoneyWithoutLambdas does not throw an exception");
		} catch (NoNegMoney e) {
			// we are fine here
		}
	}

}
	

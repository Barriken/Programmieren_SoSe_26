package financials;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	  MoneyTest.class,
	  SecondMoneyTest.class
})

public class FinancialsTestSuite {

}

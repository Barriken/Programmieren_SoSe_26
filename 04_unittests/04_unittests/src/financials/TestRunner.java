package financials;

import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;

import java.io.PrintWriter;

public class TestRunner {

	public static void main(String[] args) {
		SummaryGeneratingListener listener = new SummaryGeneratingListener();
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
				.selectors(
						selectClass(MoneyTest.class),
						selectClass(SecondMoneyTest.class)
						)
				.build();
	    Launcher launcher = LauncherFactory.create();
	    //TestPlan testPlan = launcher.discover(request);
	    launcher.registerTestExecutionListeners(listener);
	    launcher.execute(request);
	
	    TestExecutionSummary summary = listener.getSummary();
	    summary.printTo(new PrintWriter(System.out));
	}

}

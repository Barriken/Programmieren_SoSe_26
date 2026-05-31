package container3;

// Container Test with JUint 5
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A sample test case, testing container3.StackArrayImpl.
 */
class StackTest {
	protected Stack emptyStack;
	protected Stack stack;

	@BeforeEach
	void setUp() throws Exception {
		emptyStack = new StackArrayImpl(5);
		stack = new StackArrayImpl(5);
		try {
			stack.push(Integer.valueOf(1));
			stack.push(Integer.valueOf(2));
			stack.push(Integer.valueOf(3));
		} catch (Exception ex) {
			fail("setup Fehler: " + ex);
		}
	}

	@Test
	public void empty() {
		assertTrue(emptyStack.empty(), "Leerer stack muss empty sein");
		assertTrue(!stack.empty(), "Nichtleerer stack darf nicht empty sein");
	}

	@Test
	public void top() {
		try {
			assertEquals(Integer.valueOf(4), stack.top(), "top() liefert falsches Element ");
		} catch (StackEmptyException e) {
			fail("Stack darf hier nicht leer sein");
		}

		try {
			emptyStack.top();
			fail("top() fuer leeren Stack sollte StackEmptyException werfen");
		} catch (StackEmptyException e) {
			return;
		}

	}

	@Test
	public void pop() {
		// test working with an empty stack 
		try {
			Integer pushElement = Integer.valueOf(5);
			emptyStack.push(pushElement);
			assertEquals(pushElement, emptyStack.pop());
			assertTrue(emptyStack.empty(), "pop(push()) muss wieder den Ausgangsstack ergeben");
		} catch (Exception e) {
			fail("Exception trotz ordentlichem push u. pop");
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}

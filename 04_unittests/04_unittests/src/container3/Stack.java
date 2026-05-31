package container3;

/**
 * Specification of a simple stack
 */
public interface Stack {

	void push(Object obj) throws StackOverflowException;

	Object pop() throws StackEmptyException;

	Object top() throws StackEmptyException;

	boolean empty();
}

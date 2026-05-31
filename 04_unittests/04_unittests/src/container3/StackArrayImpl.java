package container3;

/**
 * A simple stack implementation backed by an array of fixed size, which can
 * hold objects.
 */
public class StackArrayImpl implements Stack {
	private Object[] objects;
	private int h; // height and index of first free component

	public StackArrayImpl(int cap) {
		objects = new Object[cap];
		h = 0; // nur zur Betonung
	}

	public void push(Object obj) throws StackOverflowException {
		if (h == objects.length)
			throw new StackOverflowException("Stack with fixed size " + objects.length);
		objects[h++] = obj;
	}

	public Object pop() throws StackEmptyException {
		if (h == 0)
			throw new StackEmptyException("unable to pop");
		return objects[--h];
	}

	public Object top() throws StackEmptyException {
		if (h == 0)
			throw new StackEmptyException("unable to top");
		return objects[h - 1];
	}

	public boolean empty() {
		return (h == 0);
	}

	public String toString() {
		String s = "content of stack \n";
		for (int i = 0; i < h; i++)
			s += i + "-te Komponente: " + objects[i] + "\n";
		return s;
	}
}

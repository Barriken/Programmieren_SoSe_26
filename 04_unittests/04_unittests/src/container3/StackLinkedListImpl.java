package container3;

/**
 * A simple stack implementation backed by a linked list of objects.
 */
public class StackLinkedListImpl implements Stack {
	// gekapselte Daten
	private ListLinkElement h; // head of list which is top of stack

	// generated default constructor is sufficient

	public void push(Object c) {
		h = new ListLinkElement(c, h);
	}

	public Object pop() throws StackEmptyException {
		if (h == null)
			throw new StackEmptyException("unable to pop");

		Object c = h.data;
		h = h.next;
		return c;
	}

	public Object top() throws StackEmptyException {
		if (h == null)
			throw new StackEmptyException("unable to pop");

		return h.data;
	}

	public boolean empty() {
		return (h == null);
	}

	public String toString() {
		String s = "content of circle stack \n";

		ListLinkElement lnk = h;
		while (lnk != null) {
			s += lnk.data.toString() + "\n";
			lnk = lnk.next;
		}
		return s;
	}
}

class ListLinkElement {
	Object data;
	ListLinkElement next;

	ListLinkElement(Object data, ListLinkElement next) {
		this.data = data;
		this.next = next;
	}
}
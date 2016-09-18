public class SLinkedQueue implements Queue {

	private Node head;
	private Node rear;
	private int size;

	public void add(Object data) {
		if (isEmpty())
			head = rear = new Node(data, null);
		else
			rear = rear.next = new Node(data, null);
		++size;
	}

	public Object remove() {
		if (isEmpty())
			throw new IllegalStateException("***** Queue is Empty *****");
		Object temp = head.data;
		if (head == rear)
			head = rear = null;
		else
			head = head.next;
		--size;
		return temp;
	}

	public Object first() {
		if (isEmpty())
			throw new IllegalStateException("***** Queue is Empty *****");
		return head.data;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public void print() {
		for (Node p = head; p != null; p = p.next)
			System.out.print(p.data + " ");
		System.out.println();
	}

	private static class Node {

		Object data;
		Node next;

		Node(Object data) {
			this.data = data;
		}

		Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}

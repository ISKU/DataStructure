public class DLinkedQueue implements Queue {

	private Node head = new Node(null);
	private int size;

	public boolean isEmpty() {
		return (size == 0);
	}

	public Object first() {
		if (isEmpty())
			throw new IllegalStateException("queue is empty");
		return head.next.data;
	}

	public int size() {
		return size;
	}

	public void add(Object data) {
		head.prev = head.prev.next = new Node(data, head.prev, head);
		++size;
	}

	public Object remove() {
		Object temp = head.next.data;
		head.next = head.next.next;
		head.next.prev = head;
		--size;
		return temp;
	}
	
	public void print(){
		for(Node p = head.next; p!=head; p=p.next)
			System.out.print(" "+p.data);
		System.out.println();
	}

	private class Node {
		Node prev = this;
		Node next = this;
		Object data;

		Node(Object data) {
			this.data = data;
		}

		Node(Object data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

}

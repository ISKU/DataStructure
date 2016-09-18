public class CircularQueue implements Queue {

	Object[] a = new Object[4];
	private int front = 0, rear = 0;;

	public void add(Object data) {
		if ((rear + 1) % a.length == front)
			System.out.println("***** Queue is Full *****");
		else
			a[++rear % a.length] = data;
	}

	public Object remove() {
		if (isEmpty())
			throw new IllegalStateException("***** Queue is Empty *****");
		Object temp = a[++front % a.length];
		a[front % a.length] = null;
		return temp;
	}

	public boolean isEmpty() {
		return (rear == front);
	}

	public Object first() {
		if (isEmpty())
			throw new IllegalStateException("***** Queue is Empty *****");
		return a[(front + 1) % a.length];
	}

	public int size() {
		return rear - front;
	}

	public void print() {
		for (int i = 0; i < a.length; i++)
			System.out.printf("%6s", a[i]);
		System.out.println();
	}
}

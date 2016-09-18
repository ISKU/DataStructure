import java.util.ArrayList;
import java.util.Iterator;

public class ArrayStack extends ArrayList implements Stack {

	ArrayList<String> list = new ArrayList<String>();

	public void push(String data) {
		list.add(data);
	}

	public String pop() {
		if (isEmpty())
			throw new IllegalStateException("*** Stack is Empty ***");
		return list.remove(list.size() - 1);
	}

	public String peek() {
		if (isEmpty())
			throw new IllegalStateException("*** Stack is Empty ***");
		return list.get(list.size() - 1);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public void print() {
		for (Iterator<String> it = list.iterator(); it.hasNext();)
			System.out.print(it.next() + " ");
		System.out.println();
	}

}

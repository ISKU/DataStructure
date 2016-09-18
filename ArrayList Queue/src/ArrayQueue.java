import java.util.ArrayList;
import java.util.Iterator;

public class ArrayQueue extends ArrayList implements Queue {

	ArrayList<String> list = new ArrayList<String>();

	public void add(String data) {
		list.add(data);
	}

	public String remove() {
		if (isEmpty())
			throw new IllegalStateException("*** Queue is Empty ***");
		return list.remove(0);
	}

	public String first() {
		if (isEmpty())
			throw new IllegalStateException("*** Queue is Empty ***");
		return list.get(0);
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

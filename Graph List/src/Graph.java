import java.util.Stack;

public class Graph {

	int size;
	String[] vertices;
	Node[] a;

	public Graph(String[] args) {
		size = args.length;
		a = new Node[size];
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
	}

	public void add(String v, String w) {
		a[index(v)] = new Node(index(w), a[index(v)]);
		a[index(w)] = new Node(index(v), a[index(w)]);

		/*
		if (a[index(v)] == null)
			a[index(v)] = new Node(index(w), a[index(v)]);
		else {
			Node p = a[index(v)];
			while (p.next != null)
				p = p.next;
			p.next = new Node(index(w), null);
		}

		if (a[index(w)] == null)
			a[index(w)] = new Node(index(v), a[index(w)]);
		else {
			Node p = a[index(w)];
			while (p.next != null)
				p = p.next;
			p.next = new Node(index(v), null);
		}
		*/
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{");
		for (int i = 0; i < size; i++) {
			buf.append(vertices[i] + ":");
			for (Node p = a[i]; p != null; p = p.next)
				buf.append(vertices[p.index]);
			buf.append(", ");
		}
		return buf + "}";
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	public String dfs(String firstVertex) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] mark = new boolean[size];
		StringBuffer buf = new StringBuffer("{");

		mark[index(firstVertex)] = true;
		stack.push(index(firstVertex));
		while (!stack.isEmpty()) {
			buf.append(vertices[stack.peek()] + "->");
			for (Node p = a[stack.pop()]; p != null; p = p.next)
				if (!mark[p.index]) {
					mark[p.index] = true;
					stack.push(p.index);
				}
		}
		return buf + "}";
	}

	private class Node {
		int index;
		Node next;

		Node(int index, Node next) {
			this.index = index;
			this.next = next;
		}
	}
}
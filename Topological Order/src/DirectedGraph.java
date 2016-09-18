import java.util.Stack;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class DirectedGraph {

	private int size;
	private String[] vertices;
	private int[] indegree;
	private Node[] list;

	public DirectedGraph() throws IOException {
		FileInputStream stream = new FileInputStream("inputgraph");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		String v = "", w = "";
		int i = 0;

		while ((token.nextToken() != StreamTokenizer.TT_EOF)) {
			switch (token.ttype) {
			case StreamTokenizer.TT_NUMBER:
				if (token.lineno() == 1) {
					size = (int) token.nval;
					vertices = new String[size];
					list = new Node[size];
					indegree = new int[size];
				}
				break;
			case StreamTokenizer.TT_WORD:
				if (token.lineno() < size + 2 && token.lineno() > 1)
					vertices[i++] = token.sval;
				else {
					v = token.sval;
					token.nextToken();
					w = token.sval;
					add(v, w);
				}
				break;
			}
		}
		stream.close();
	}

	public void topSort() {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < size; i++)
			if (indegree[i] == 0)
				stack.push(i);

		for (int i = 0; i < size; i++) {
			if (stack.isEmpty()) {
				System.out.println("impossible to topological sorting");
				break;
			}
			System.out.print(vertices[stack.peek()] + "->");
			for (Node edge = list[stack.pop()]; edge != null; edge = edge.next) {
				indegree[edge.index]--;
				if (indegree[edge.index] == 0)
					stack.push(edge.index);
			}
		}
	}

	private void add(String v, String w) {
		list[index(v)] = new Node(index(w), list[index(v)]);
		indegree[index(w)]++;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return list.length;
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

import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class WeightGraph {

	private int size;
	private String[] vertices;
	private Node[] a;
	private int[] dist;
	private String[] prev;
	private boolean[] mark;
	private Scanner input;

	public WeightGraph() throws IOException {
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
					a = new Node[size];
				} else
					add(v, w, (int) token.nval);
				break;
			case StreamTokenizer.TT_WORD:
				if (token.lineno() < size + 2 && token.lineno() > 1)
					vertices[i++] = token.sval;
				else {
					v = token.sval;
					token.nextToken();
					w = token.sval;
				}
				break;
			}
		}
		stream.close();
	}

	public void dijkstra() {
		dist = new int[size];
		prev = new String[size];
		mark = new boolean[size];
		input = new Scanner(System.in);

		for (int i = 0; i < size; i++)
			System.out.print(vertices[i] + ", ");
		System.out.print("총 " + size + "개의 정점(Vertex)이 있습니다.\n 출발점을 입력하세요: ");

		String firstVertex = input.next();
		int distindex = index(firstVertex);
		for (int i = 0; i < size; i++)
			if (i != distindex)
				dist[i] = Integer.MAX_VALUE;

		while (distindex != -1) {
			mark[distindex] = true;
			for (Node p = a[distindex]; p != null; p = p.next)
				if (!mark[p.vertex] && dist[distindex] + p.weight < dist[p.vertex]) {
					dist[p.vertex] = dist[distindex] + p.weight;
					prev[p.vertex] = vertices[distindex];
				}
			distindex = findSmallestDist();
		}

		for (int i = 0; i < size; i++) {
			System.out.printf("%s: 거리 %d / %s", vertices[i], dist[i],
					prev[i] == null ? "출발점" : vertices[i]);
			printPath(prev[i]);
			System.out.println();
		}
	}

	private void printPath(String prevVertex) {
		if (prevVertex == null)
			return;
		System.out.print("<-" + prevVertex);
		printPath(prev[index(prevVertex)]);
	}

	private int findSmallestDist() {
		int min = Integer.MAX_VALUE;
		int distindex = -1;
		for (int i = 0; i < size; i++)
			if (!mark[i] && dist[i] < min) {
				min = dist[i];
				distindex = i;
			}
		return distindex;
	}

	private void add(String v, String w, int weight) {
		a[index(v)] = new Node(index(w), weight, a[index(v)]);
		a[index(w)] = new Node(index(v), weight, a[index(w)]);
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{");
		for (int i = 0; i < size; i++) {
			buf.append(vertices[i] + ":");
			for (Node p = a[i]; p != null; p = p.next)
				buf.append(vertices[p.vertex]);
			buf.append(", ");
		}
		return buf + "}";
	}

	private class Node {
		int vertex;
		int weight;
		Node next;

		Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
}
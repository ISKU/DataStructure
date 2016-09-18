import java.util.PriorityQueue;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class WeightGraph {

	private int size;
	private String[] vertices;
	private int[][] a;
	private int[] parent;
	private PriorityQueue<Edge> edgeSet = new PriorityQueue<Edge>();

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
					parent = new int[size];
					a = new int[size][size];
					for (int j = 0; j < size; j++)
						for (int k = 0; k < size; k++)
							if (j == k)
								a[j][k] = 0;
							else
								a[j][k] = Integer.MAX_VALUE;
					for (int j = 0; j < size; j++)
						parent[j] = -1;
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

	public void kruskal() {
		int indexSetV, indexSetW, minimumCost = 0, edgeCount = 0;
		StringBuffer buf = new StringBuffer("사용한 Edge: ");

		while (edgeSet.peek() != null && edgeCount < size - 1) {
			Edge leastCostEdge = edgeSet.poll();
			indexSetV = collapsingFind(index(leastCostEdge.v));
			indexSetW = collapsingFind(index(leastCostEdge.w));
			if (indexSetV != indexSetW) {
				weightedUnion(indexSetV, indexSetW);
				buf.append(leastCostEdge.v + leastCostEdge.w + " ");
				minimumCost = minimumCost + leastCostEdge.weight;
				edgeCount++;
			}
		}
		
		if (edgeCount < size - 1)
			System.out.println("No Spanning Tree");
		else {
			System.out.println("최소비용: " + minimumCost);
			System.out.println(buf);
			System.out.print("Parent: ");
			for (int i = 0; i < size; i++)
				System.out.print(parent[i] + " ");
			System.out.println();
		}
	}

	private void weightedUnion(int indexSetV, int indexSetW) {
		int unionSize = parent[indexSetV] + parent[indexSetW];

		if (parent[indexSetV] > parent[indexSetW]) {
			parent[indexSetV] = indexSetW;
			parent[indexSetW] = unionSize;
		} else {
			parent[indexSetW] = indexSetV;
			parent[indexSetV] = unionSize;
		}
	}

	private int collapsingFind(int index) {
		int root, child, next;

		for (root = index; parent[root] >= 0; root = parent[root]) ;
		
		for (child = index; child != root; child = next) {
			next = parent[child];
			parent[child] = root;
		}
		return root;
	}

	private void add(String v, String w, int weight) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = weight;
		Edge edge = new Edge(v, w, weight);
		edgeSet.add(edge);
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if (a[i][j] > 0 && a[i][j] < Integer.MAX_VALUE)
				buf.append(vertices[j]);
		return buf + "";
	}

	public void printGraph() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.printf("%2s", a[i][j] == Integer.MAX_VALUE ? "∞"
						: a[i][j]);
			System.out.println();
		}
	}

	@Override
	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1; i < size; i++)
			buf.append(", " + vertex(i));
		return buf + "}";
	}

	private class Edge implements Comparable<Edge> {
		String v;
		String w;
		int weight;

		Edge(String v, String w, int weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge edge) {
			if (this.weight < edge.weight)
				return -1;
			else if (this.weight > edge.weight)
				return 1;
			else
				return 0;
		}
	}
}
// 
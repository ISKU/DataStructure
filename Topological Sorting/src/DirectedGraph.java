import java.util.PriorityQueue;
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
				if (token.lineno() < size + 2 && token.lineno() > 1) {
					vertices[i++] = token.sval;
				} else {
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
		PriorityQueue<Node> queue = new PriorityQueue<Node>();

		for (int i = 0; i < size; i++) {
			if (indegree[i] == 0) {
				Node grade = new Node(i, priorityGrade(i));
				queue.add(grade);
			}
		}

		for (int i = 0; i < size; i++) {
			if (queue.isEmpty()) {
				System.out.println("impossible to topological sorting");
				break;
			}
			int index = queue.poll().index;
			System.out.print(vertices[index] + "->");
			for (Node edge = list[index]; edge != null; edge = edge.next) {
				indegree[edge.index]--;
				if (indegree[edge.index] == 0) {
					Node grade = new Node(edge.index, priorityGrade(edge.index));
					queue.add(grade);
				}
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

	private int priorityGrade(int index) {
		switch (vertices[index]) {
		case "��ǻ�����α׷���":
		case "C������α׷���":
			return 1;
		case "����Ʈ�����1":
		case "�ý������α׷���":
		case "�ڷᱸ��":
		case "����Ʈ�����2":
		case "��ǻ�ͱ���1":
			return 2;
		case "������α׷���":
		case "��ǻ�ͱ���2":
		case "��ǻ���ϵ�����":
			return 3;
		case "����Ʈ������м���1":
		case "��ǻ��Ư��":
			return 4;
		default:
			break;
		}
		return 0;
	}

	private class Node implements Comparable<Node> {
		int index;
		int grade;
		Node next;

		Node(int index, int grade) {
			this.index = index;
			this.grade = grade;
		}

		Node(int index, Node next) {
			this.index = index;
			this.next = next;
		}

		@Override
		public int compareTo(Node comparison) {
			if (this.grade < comparison.grade)
				return -1;
			else if (this.grade > comparison.grade)
				return 1;
			else
				return 0;
		}
	}

}
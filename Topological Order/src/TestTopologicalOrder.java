import java.io.IOException;

public class TestTopologicalOrder {
	public static void main(String args[]) throws IOException {
		
		DirectedGraph digraph = new DirectedGraph();
		System.out.println(" ���� ���� ����: ");
		digraph.topSort();
	}
}

import java.io.IOException;

public class TestTopologicalOrder {
	public static void main(String args[]) throws IOException {
		
		DirectedGraph digraph = new DirectedGraph();
		System.out.println(" 위상 정렬 순서: ");
		digraph.topSort();
	}
}

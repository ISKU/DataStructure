import java.io.IOException;

public class TestTopologicalSorting {
	public static void main(String args[]) throws IOException {
		
		DirectedGraph digraph = new DirectedGraph();
		System.out.println(" 학년별 위상 정렬 순서: ");
		digraph.topSort();
	}
}

import java.io.IOException;

public class TestKruskal {
	public static void main(String agrs[]) throws IOException  {
		
		WeightGraph wgraph = new WeightGraph();
		
		System.out.println(wgraph.toString()+"\n");

		wgraph.printGraph();
		
		System.out.println("\nKruskal �˰��� ��� --------------------");
		wgraph.kruskal();
		System.out.println("-------------------------------------");
		
	}
}

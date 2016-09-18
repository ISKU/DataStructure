import java.io.IOException;

public class TestDijkstra {
	public static void main(String agrs[]) throws IOException {
		
			WeightGraph wgraph = new WeightGraph();
			System.out.println(wgraph);
			
			wgraph.dijkstra();
	}	
}
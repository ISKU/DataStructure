public class TestGraph {
	public static void main(String args[]) {

		Graph graph = new Graph(new String[] { "SE", "UK", "DE", "FR", "CZ", "CH", "AT", "IT" });
		System.out.println(graph);
		
		graph.add("SE", "UK");
		graph.add("SE", "DE");
		graph.add("UK", "FR");
		graph.add("DE", "FR");
		graph.add("DE", "IT");
		graph.add("DE", "CZ");
		graph.add("CH", "FR");
		graph.add("CH", "IT");
		graph.add("CH", "AT");
		System.out.println(graph);

		System.out.println("깊이 우선 탐색의 결과 입니다.");
		System.out.println(graph.dfs("SE"));

	}
}

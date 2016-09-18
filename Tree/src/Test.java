import java.util.*;

public class Test {
	public static void main(String[] args) {

		OrderedTree treeA, treeB, treeD;
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeE = new OrderedTree("E");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeG = new OrderedTree("G");

		List subtreesOfB = new LinkedList();
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);
		treeB = new OrderedTree("B", subtreesOfB);

		List subtreesOfD = new LinkedList();
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);

		List subtreesOfA = new LinkedList();
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);

		treeA.print(treeA);
		System.out.print("Preorder: ");
		treeA.preorderPrint(treeA);
		System.out.print("\nLevelorder: ");
		treeA.levelorderPrint();
	}
}

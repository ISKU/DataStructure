import java.util.*;

public class OrderedTree {

	private Object root;
	private List subtrees;
	private int size;
	private int count = 0;

	public OrderedTree() {
	}

	public OrderedTree(Object root) {
		this.root = root;
		subtrees = new LinkedList();
		size = 1;
	}

	public OrderedTree(Object root, List trees) {
		this(root);
		for (Iterator it = trees.iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree) object;
				subtrees.add(tree);
				size += tree.size();
			}
		}
	}

	public int size() {
		return size;
	}

	public void print(OrderedTree tree) {
		count++;
		System.out.println(tree.root + " ");

		for (Iterator it = tree.subtrees.iterator(); it.hasNext();) {
			for (int i = count; i > 0; i--)
				System.out.print(" ");

			print((OrderedTree) it.next());
			count--;
		}
	}

	public void preorderPrint(OrderedTree tree) {
		System.out.print(tree.root + " ");
		for (Iterator it = tree.subtrees.iterator(); it.hasNext();)
			preorderPrint((OrderedTree) it.next());
	}

	public void levelorderPrint() {
		LinkedList queue = new LinkedList();
		queue.addLast(this);

		while (!queue.isEmpty()) {
			OrderedTree tree = (OrderedTree) queue.removeFirst();
			System.out.print(tree.root + " ");
			for (Iterator it = tree.subtrees.iterator(); it.hasNext();)
				queue.addLast(it.next());
		}
	}
}

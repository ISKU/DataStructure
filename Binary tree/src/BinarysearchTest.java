public class BinarysearchTest {
	public static void main(String args[]) {

		BinaryTree tree = new BinaryTree();
		
		tree.add(6);
		tree.add(4);
		tree.add(8);
		tree.add(2);
		tree.add(10);

		System.out.print("(1) \n중위 순회 트리 : ");
		tree.inorderPrint();

		System.out.print("\n\n(2)");
		tree.search(9);
		tree.search(10);

		System.out.print("\n(3) delete \n중위 순회 트리 : ");
		tree.delete(6);
		tree.inorderPrint();
	}
}

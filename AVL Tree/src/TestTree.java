
public class TestTree {
	public static void main(String args[]) {
		
		AVLTree avltree = new AVLTree(3);
		System.out.println("********************************** ADD");
		System.out.println(avltree);
		avltree.add(5);
		System.out.println(avltree);
		avltree.add(1);
		System.out.println(avltree);
		avltree.add(8);
		System.out.println(avltree);
		avltree.add(6);
		System.out.println(avltree);
		avltree.add(2);
		System.out.println(avltree);
		avltree.add(11);
		System.out.println(avltree);
		avltree.add(4);
		System.out.println(avltree);
		avltree.add(10);
		System.out.println(avltree);
		avltree.add(9);
		System.out.println(avltree);
		avltree.add(7);
		System.out.println(avltree);
		System.out.println("*************************************");
		
		System.out.println("***************************** DELETE");
		avltree.delete(3);
		System.out.println(avltree);
		avltree.delete(5);
		System.out.println(avltree);
		avltree.delete(1);
		System.out.println(avltree);
		avltree.delete(8);
		System.out.println(avltree);
		avltree.delete(6);
		System.out.println(avltree);
		System.out.println("*************************************");

	}
}

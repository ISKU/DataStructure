public class BinaryTree {

	private BinarytreeNode head;

	BinaryTree() {
		head = null;
	}

	public boolean add(int x) {

		BinarytreeNode p = head;

		if (head == null) {
			head = new BinarytreeNode(x, null, null);
			return true;
		}

		while (true) {
			if (x < p.element) {
				if (p.leftchild != null)
					p = p.leftchild;
				else {
					p.leftchild = new BinarytreeNode(x);
					return true;
				}
			} else if (x > p.element) {
				if (p.rightchild != null)
					p = p.rightchild;
				else {
					p.rightchild = new BinarytreeNode(x);
					return true;
				}
			} else
				return false;
		}
	}

	public void search(int x) {

		BinarytreeNode p = head;

		System.out.println("\nsearch(" + x + ")");
		while (true) {
			if (p == null) {
				System.out.println("Flase");
				break;
			}
			if (x < p.element) {
				System.out.println("비교: " + x + " " + p.element);
				p = p.leftchild;
			} else if (x > p.element) {
				System.out.println("비교: " + x + " " + p.element);
				p = p.rightchild;
			} else {
				System.out.println("비교: " + x + " " + p.element);
				System.out.println("True");
				break;
			}
		}
	}

	public void inorderPrint() {
		if (head == null)
			throw new IllegalStateException("tree is empty");
		else
			print(head);
	}

	private void print(BinarytreeNode head) {
		if (head != null) {
			print(head.leftchild);
			System.out.print(head.element + " ");
			print(head.rightchild);
		}

	}

	public boolean delete(int x) {

		BinarytreeNode p = head;
		BinarytreeNode parent = p;

		while (p.element != x) {
			if (p == null)
				return false;
			parent = p;
			if (x < p.element)
				p = p.leftchild;
			else
				p = p.rightchild;
		}

		if (p.leftchild == null && p.rightchild == null) {
			if (p == head)
				head = null;
			else if (p == parent.leftchild)
				parent.leftchild = null;
			else
				parent.rightchild = null;
		} else if (p.rightchild == null) {
			if (p == head)
				head = p.leftchild;
			else if (p == parent.leftchild)
				parent.leftchild = p.leftchild;
			else
				parent.rightchild = p.leftchild;
		} else if (p.leftchild == null) {
			if (p == head)
				head = p.rightchild;
			else if (p == parent.leftchild)
				parent.leftchild = p.rightchild;
			else
				parent.rightchild = p.rightchild;
		} else {
			BinarytreeNode xParent = p;
			BinarytreeNode candidate = xParent.rightchild;

			while (candidate.leftchild != null) {
				xParent = candidate;
				candidate = candidate.leftchild;
			}
			if (candidate != p.rightchild) {
				xParent.leftchild = candidate.rightchild;
				candidate.rightchild = p.rightchild;
			}
			if (p == head)
				head = candidate;
			else if (p == parent.leftchild)
				parent.leftchild = candidate;
			else
				parent.rightchild = candidate;

			candidate.leftchild = p.leftchild;
		}

		return true;
	}

	private static class BinarytreeNode {

		BinarytreeNode leftchild;
		BinarytreeNode rightchild;
		int element;

		BinarytreeNode(int element) {
			this.element = element;
		}

		BinarytreeNode(int element, BinarytreeNode leftchild,
				BinarytreeNode rightchild) {
			this.element = element;
			this.leftchild = leftchild;
			this.rightchild = rightchild;
		}
	}
}

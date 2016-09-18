public class AVLTree {

	public int key, height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();

	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
	}

	public boolean add(int key) {
		int oldSize = size();
		grow(key);
		return size() > oldSize;
	}

	public boolean delete(int key) {
		int oldSize = size();
		ungrow(key);
		return size() < oldSize;
	}

	public AVLTree grow(int key) {
		if (this == NIL)
			return new AVLTree(key);
		if (key == this.key)
			return this;
		if (key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}
	
	private AVLTree ungrow(int key) {

		if (key < this.key)
			this.left = this.left.ungrow(key);
		else if (key > this.key)
			this.right = this.right.ungrow(key);
		else {
			if (this.left == NIL && this.right == NIL)
				return NIL;
			else if (this.left == NIL)
				return this.right;
			else if (this.right == NIL)
				return this.left;
			else {
				if (this.right.left == NIL)
					return new AVLTree(this.right.key, this.left, this.right.right);
				else {
					AVLTree candidate = this.right;
					while (candidate.left != NIL)
						candidate = candidate.left;
					this.ungrow(candidate.key);
					this.key = candidate.key;
					return new AVLTree(candidate.key, this.left, this.right);
				}
			}
		}
		
		this.rebalance();
		this.height = 1 + Math.max(this.left.height, this.right.height);
		return this;
	}

	public int size() {
		if (this == NIL)
			return 0;
		return 1 + left.size() + right.size();
	}

	public String toString() {
		if (this == NIL)
			return "";
		return right + " " + key + " " + left;
	}

	private AVLTree() {
		left = right = this;
		height = -1;
	}

	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}

	private void rebalance() {
		if (right.height > left.height + 1) {
			if (right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		} else if (left.height > right.height + 1) {
			if (left.right.height > left.left.height)
				left.rotateLeft();
			rotateRight();
		}
	}

	private void rotateLeft() {
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}

	private void rotateRight() {
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
}

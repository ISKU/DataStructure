/**
 * Heap�� ����� PriorityQueue Ŭ����
 * 
 * �˰��� 00�� 201201356 ���ȣ
 * @author Kim Min-Ho
 */
public class PriorityQueue {

	/**
	 * tree: PriorityQueue�� �ڷᱸ���� �迭�� ����Ѵ�.
	 * treeSize: ���� PriorityQueue�� ���� ����
	 */
	private Node[] tree;
	private int treeSize;

	/**
	 * PriorityQueue Default Constructor
	 * Tree�� ������ �� �ִ� ����� ������ �⺻������ 100���̰�, 
	 * �ƹ� ��嵵 ���� PriorityQueue�� �����.
	 */
	public PriorityQueue() {
		treeSize = 0;
		tree = new Node[100];
	}
	
	/**
	 * PriorityQueue Constructor
	 * ����ڷκ��� �� ������ �迭�� �Է� �޾� Heap�� ����Ͽ� PriorityQueue�� �����Ѵ�.
	 * 
	 * @param array �� ���Ҹ� ������ �迭
	 */
	public PriorityQueue(Node[] array) {
		treeSize = array.length;
		tree = new Node[treeSize];
		System.arraycopy(array, 0, tree, 0, treeSize);
		
		buildMaxHeap(tree);
	}
	
	/**
	 * PriorityQueue�� ���� ����
	 * ������ ������ Tree�� ���� ������ index�� �ӽ÷� �־�ΰ�,
	 * �ش� index�������� root���� Bottom-Up heapify�� �����Ѵ�.
	 * 
	 * @param element PriorityQueue�� ������ ����
	 */
	public void insert(Node element) {
		if (treeSize == tree.length)
			resize();
		
		treeSize++;
		int currentIndex = treeSize - 1;
		int parent = parent(currentIndex);
		tree[currentIndex] = element;

		while (parent >= 0 && tree[parent].value < element.value) {
			elementSwap(parent, currentIndex);
			currentIndex = parent;
			parent = parent(currentIndex);
		}
	}

	/**
	 * PriorityQueue�� �켱������ ���� ���� ���Ҹ� ��ȯ�ϰ� �����Ѵ�.
	 * 
	 * @return PriorityQueue�� �켱������ ���� ���Ҹ� ��ȯ
	 */
	public Node extractMax() {
		Node maxNode = tree[0];
		elementSwap(0, treeSize - 1);
		treeSize--;
		heapify(0);
		return maxNode;
	}
	
	/**
	 * PriorityQueue�� �켱������ ���� ���� ���Ҹ� ��ȯ
	 * 
	 * @return Tree�� �켱������ ���� ū ��� ��ȯ
	 */
	public Node max() {
		return tree[0];
	}

	/**
	 * PrioirtyQueue�� �ִ� ������ ���� ������Ų��.
	 * Tree�� �ش� index�� value�� key�� ���� �� ��,
	 * ����Ǵ� key�� ���� �ش� ���� ������ key �� ���� �۾��� �� ���� ������
	 * �ش� index�������� root���� Bottom-Up heapify�� �����Ѵ�.
	 * 
	 * @param index Tree�� ����ڰ� ������ ���� ����� index
	 * @param key ����ڰ� ������ ���� ����� ���� �ش� key�� �����Ѵ�.
	 */
	public void increaseKey(int index, int key) {
		int currentIndex = index - 1;
		int parent = parent(currentIndex);

		if (tree[currentIndex].value < key) {
			tree[currentIndex].value = key;
			while (parent >= 0 && tree[parent].value < tree[currentIndex].value) {
				elementSwap(parent, currentIndex);
				currentIndex = parent;
				parent = parent(currentIndex);
			}
		} else if (tree[currentIndex].value > key) {
			tree[currentIndex].value = key;
			heapify(currentIndex);
		}
	}

	/**
	 * PriorityQueue�� �ִ� ���Ҹ� �����Ѵ�.
	 * Tree�� ����ڰ� ������ index�� ��带 Tree�� ���� ������ ���� ��ġ�� �ٲ� ��
	 * �ٲ� ��ġ���� heapify()�� �����Ͽ� Max-Heap�� �����Ѵ�.
	 * 
	 * @param index Tree���� ���� �� ����� index
	 */
	public void delete(int index) {
		elementSwap(index - 1, treeSize - 1);
		treeSize--;
		heapify(index - 1);
	}
	
	/**
	 * Tree�� ��尡 ������ Ȯ���ϴ� �޼ҵ�
	 * 
	 * @return Ʈ���� ��尡 ������ true, �� �� �̻� ���� �� false
	 */
	public boolean isEmpty() {
		return treeSize <= 0 ? true : false;
	}
	
	/**
	 * @return Tree�� ��� ������ ��ȯ
	 */
	public int getSize() {
		return this.treeSize;
	}

	/**
	 * �Է¹��� �迭�� root�� ���� ū �켱������ ������ Max-Heap�� ����� �޼ҵ�
	 * PriorityQueue�� ����ϱ� ���Ͽ� ����ڷκ��� �Է¹��� �迭�� ���� ���� Max-Heap�� �����Ͽ��� �Ѵ�.
	 * 
	 * ����ڷκ��� �Է¹��� ������ �迭�� Tree�� �����ϱ� ���Ͽ� ���� ũ��� �迭�� ������ �� tree ������ �����Ѵ�.
	 * Max-Heap�� �����ϱ� ���Ͽ� heapify()�� �����Ѵ�.
	 * heapify()�� Tree�� leaf�� �ƴ� ������ root���� �����Ͽ� Max-Heap���� �����Ѵ�.
	 * 
	 * @param array Max-Heap���� ���� ����ڰ� �Է��� �迭
	 */
	private void buildMaxHeap(Node[] array) {
		for (int index = treeSize / 2 - 1; index >= 0; index--)
			heapify(index);
	}

	/**
	 * Tree�� Ž���� ���� Max-Heap�� �׻� �����ϱ� ���� �޼ҵ�
	 * Tree�� ����� ����, ����, ������ ���� �� �׻� Max-Heap ���¸� ��� �����Ͽ��� �Ѵ�.
	 * 
	 * @param parent Ž�� ���� index
	 */
	private void heapify(int parent) {
		int left = left(parent);
		int right = right(parent);
		int largestValue;

		largestValue = (left < treeSize && tree[left].value > tree[parent].value) ? left : parent;
		largestValue = (right < treeSize && tree[right].value > tree[largestValue].value) ? right : largestValue;

		if (largestValue != parent) {
			elementSwap(largestValue, parent);
			heapify(largestValue);
		}
	}

	/**
	 * Tree �迭�� ���̸� �����ϴ� �޼ҵ�
	 * Tree�� ���ο� ���Ұ� �߰��ϱ� ���� ���� tree �迭�� ��� ä���� ������ �迭�� ���̸� �÷��ֱ� ���� ����Ѵ�.
	 */
	private void resize() {
		Node[] tempArray = new Node[tree.length * 2];
		System.arraycopy(tree, 0, tempArray, 0, treeSize);
		tree = tempArray;
	}
	
	/**
	 * Tree�� �� ����� ��ġ�� �ٲٴ� �޼ҵ�
	 * 
	 * @param firstIndex Swap�� ����� index
	 * @param secondIndex Swap�� ����� index
	 */
	private void elementSwap(int firstIndex, int secondIndex) {
		Node tempNode = tree[firstIndex];
		tree[firstIndex] = tree[secondIndex];
		tree[secondIndex] = tempNode;
	}

	/**
	 * @param parent Tree�� index
	 * @return Tree���� parent�� left child index�� ��ȯ
	 */
	private int left(int parent) {
		return parent * 2 + 1;
	}

	/**
	 * @param parent Tree�� index
	 * @return Tree���� parent�� right child index�� ��ȯ
	 */
	private int right(int parent) {
		return parent * 2 + 2;
	}

	/**
	 * @param child Tree�� index
	 * @return Tree���� child�� parent index�� ��ȯ
	 */
	private int parent(int child) {
		return (child - 1) / 2;
	}

	/**
	 * Tree�� ������������ ����
	 */
	public void sort() {
		int tempTreeSize = treeSize;
		while (treeSize-- > 0) {
			elementSwap(0, treeSize);
			heapify(0);
		}
		treeSize = tempTreeSize;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		for (int index = 0; index < treeSize; index++)
			data.append((index + 1) + ".  " + tree[index].value + ", " + tree[index].subject + "\n");
		return data.toString();
	}
}
public class LinkedBag {

	private Node start, p;
	private int size, diffsize;

	public void add(Object object) {
		if (contains(object) == false)
			diffsize++;
		getFirst();
		if (start == null)
			start = new Node(object);
		else {
			while (p.next != null)
				getNext();
			p.next = new Node(object);
		}
		size++;
	}
	// �Է� ���� ���Ҹ� ����Ʈ�� ���� ��Ű�� �޼ҵ�.
	// ���� ����Ʈ�ȿ� �Է� ���� ���ҿ� ���� ���Ұ� �ִ��� contains�� �̿��� Ȯ���Ѵ�.
	// �Է� ���� ���ҿ� ���� ���Ұ� ���ٸ� ���� �ٸ� ������ ������ ��Ÿ�� diffsize�� 1���� ��Ų��.
	// getFrist()�� p�� start�� ������ ����Ʈ�� ���� �տ� ��ġ ��Ų��.
	// ���Ҹ� �Է� �ް� ���� ����Ʈ�� �ƹ� ���ҵ� ���ٸ� start�� null�� ����̰�
	// �� �� �Է� ���� ������ ���� ���� ���ο� ��带 �����ϰ� start�� �̸� ����Ű�� �Ѵ�.
	// ����Ʈ�� ������� �ʾҴٸ� p�� �̿��Ͽ� null�� ����������, �� ����Ʈ�� ������ ��带 ����Ű��
	// �� ������ ����� ������°�� �Է� ���� ������ ���� ���� ���ο� ��带 �����Ѱ� �̸� ���� �Ѵ�.
	// ����Ʈ�� ������ ���������� �̷�������� ������ ������ ��Ÿ�� size�� 1���� ��Ų��.

	public boolean remove(Object object) {
		getFirst();
		if (start == null)
			return false;
		if (start.data == object) {
			start = start.next;
			size--;
			if (contains(object) == false)
				diffsize--;
			return true;
		}
		while (p.next != null) {
			if (p.next.data == object) {
				p.next = p.next.next;
				size--;
				if (contains(object) == false)
					diffsize--;
				return true;
			} else
				getNext();
		}
		return false;
	}
	//����Ʈ �ȿ� �ִ� ���ҿ� �Է¹��� ���Ұ� ���� ��� �� ���Ҹ� �����ϴ� �޼ҵ�.
	//p�� start�� ����Ű�� �Ͽ� ����Ʈ�� �� �տ� ��ġ��Ų��. getFrist()
	//start==null, �� ����Ʈ�� ��������� false�� ��ȯ, ���� ������� ����.
	//�� ó�� ���Ұ� �Է� ���� ���ҿ� �������� Ȯ���ϰ�, ������ ���Ҹ� ����
	//�� �տ������� ���ʴ��  ��� ���� p.next.data�� �Է¹��� ���ҿ� ���Ͽ� ������ ����
	//������ ������ p.next�� p.next.next�� �����ϸ� �߰��� �ִ� ���Ҵ� garbage�� ��
	//���Ҹ� �����ϰ��� contains�� �̿��� ����Ʈ�ȿ� �����ߴ� ���Ұ� ���� �ִ��� Ȯ���Ѵ�.
	//���� ���Ұ� �ִٸ� diffsize�� 1����, ��� ���� �۾��� ������ Bag�� ����Ǿ����Ƿ� True�� ��ȯ.
	//�Է¹��� ���Ұ� ����Ʈ�ȿ� �����ٸ� bag�� ������� �ʾ����Ƿ� False�� ��ȯ�Ѵ�.
	
	
	public boolean contains(Object object) {
		for (getFirst(); p != null; getNext())
			if (p.data == object)
				return true;
		return false;
	}
	//�Է� ���� ���Ұ� ����Ʈ �ȿ� �ִ��� Ȯ���ϴ� �޼ҵ�.
	//����Ʈ ���� ���� ó������ ������ �Է¹��� ���ҿ� ���Ͽ� ���� ���Ұ� ������ True ��ȯ
	//�Է¹��� ���Ұ� ������ False ��ȯ.

	public Node getFirst() {
		p = start;
		return p;
	}
	//p�� ����Ʈ���� ���� ������ ���� �� �� �ִ� ��ġ �����̴�.
	//����Ʈ�� �������� start�� p�� ����Ű�� �Ѵ�.

	public Node getNext() {
		p = p.next;
		return p;
	}
	//��ġ���� p�� ���� ���� ��ĭ �̵� ��Ŵ.

	public int size() {
		return this.size;
	}
	//����Ʈ���� ���� ������ ��Ÿ���� �����̴�.

	public int diffsize() {
		return this.diffsize;
	}
	//����Ʈ���� �ߺ����� �ʴ� ���δٸ� ������ ������ ��Ÿ���� �����̴�.
	
	public void print() {
		System.out.print("\n" + size() + " " + diffsize());
		for (getFirst(); p != null; getNext())
			System.out.print(" " + p.data);
	}
	//����Ʈ���� ��� ���Ҹ� ���ʴ�� ����ϴ� �޼ҵ�.
	//size(), diffsize() ����ϰ�,
	//p�� start���� null�� �ƴҶ����� �� ������ ������ �̵���Ű�鼭 ��� ���Ҹ� �����.

	private static class Node {

		Object data;
		Node next;

		Node(Object object) {
			this.data = object;
		}
	}
}

public class ArraySet implements Set {

	private Object objects[] = new Object[100];
	private int size, i;

	public boolean add(Object object) {
		if (contains(object))
			return false;
		objects[size++] = object;
		return true;
	}
	//Objects �迭�� ���Ҹ� �߰��ϴ� �޼ҵ�
	//contains()�� ȣ���Ͽ� �Է¹��� ���ҿ� �迭�ȿ� �ִ� ���Ҹ� ���Ͽ� ��ȯ�Ǵ� ���� true�̸�
	//add�� false�� ��ȯ (�迭�ȿ� �̹� �ߺ��Ǵ� ���Ұ� �����Ƿ�)
	//contains()�� false�� ��ȯ�ߴٸ�
	//objects�� �� ���Ҹ� ����ְ�, �迭�� ���� ������ ��Ÿ�� size�� 1 ����
	//���� �迭�� ����(���Ҹ� �߰�)�Ǿ����� add�� true�� ��ȯ��.

	public boolean contains(Object object) {
		for (i = 0; i < size; i++)
			if (objects[i] == object)
				return true;
		return false;
	}
	//���ڹ��� ���ҿ� �迭�ȿ� �ִ� ���Ҹ� ���Ѵ�.
	//���Ҹ� ���Ͽ� �迭�ȿ� �־��� ���Ұ� ������(�ߺ��� ����) true�� ��ȯ
	//�ߺ��� ���� ������ false�� ��ȯ��.

	public Object getFirst() {
		i = 0;
		return objects[i++];
	}
	//�迭�� ���� ù��° ���Ҹ� ����ϱ����� �޼ҵ�
	//i�� 0���� �ʱ�ȭ�ϰ�, objects[0] ù��° ���Ҹ� ��ȯ�� i���� 1������Ŵ

	public Object getNext() {
		return objects[i++];
	}
	//getFrist�� �̾ ������° ������ ���� ��ȯ�ϴ� �޼ҵ�.

	public boolean remove(Object object) {
			if (contains(object)) {
				System.arraycopy(objects, i + 1, objects, i, size - i - 1);
				objects[--size] = null;
				return true;
			}
		return false;
	}
	//�迭�� ���Ҹ� �����ϴ� �޼ҵ�
	//�Է¹��� ���Ұ��� ���� �迭�� �ִ� ���ҿ� �������� ���Ͽ�
	//���� ���Ұ� �ִٸ� arraycopy�� �̿��Ͽ� �� ������ ��ġ�� �������� ��ĭ�� ������ ����
	//i�� �迭�ȿ� ���� ������ ��ġ�� ����, objects�迭�� i+1���� i���� size-i-1 ������ŭ ����
	//�׸��� �迭�ȿ� ������ �����ڸ��� null�� �����ϰ� size�� 1���� ��Ų��.
	//�迭�� ���� ������ŭ(size) �ݺ��Ͽ� �迭���� ��� ���ҿ� �Է¹��� ���Ҹ� ���Ѵ�.
	//���Ұ� �迭�ȿ��� �����Ǹ� true��ȯ, ����� ���� ������ false ��ȯ.

	public int size() {
		return size;
	}
	//�迭�� ���� ������ ��Ÿ���� ���� ��ȯ

	public boolean print() {
		Object x = getFirst();
		System.out.print("\n" + size);
		while (true) {
			if (x == null)
				return false;
			else {
				System.out.print(" " + x);
				x = getNext();
			}
		}
	}
	//�迭�� ��� ���ҿ� ���̸� ����ϴ� �޼ҵ�
	//x�� getFrist()�� ���� ��ȯ�� �迭�� ù��° ���Ҹ� ����
	//x���� null������ Ȯ���ؼ� null�̸� false�� ��ȯ
	//null�� �ƴϸ� x���� ����ϰ� x�� getNext()�� �Ǿ� ��ȯ�� ���� ����
	//�̶� getNext()�� �迭���� ������° ���Ұ��� x�� �����Ű�� ��.
	//�� ������ x�� null�� ���������� ��� �ݺ��Ѵ�.

}

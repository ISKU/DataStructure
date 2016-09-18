public class TestEqualSet {
	public static void main(String args[]) {

		Set set1 = new ArraySet();
		Set set2 = new ArraySet();

		set1.add("JA");
		set1.add("RR");
		set1.add("YO");
		set1.add("GU");
		set1.add("ZO");
		set1.add("HA");
		set1.add("RD");
		set1.print();

		set2.add("JA");
		set2.add("RR");
		set2.add("YO");
		set2.add("GU");
		set2.add("ZO");
		set2.add("HA");
		set2.add("RD");
		set2.print();
		equalset(set1, set2);

		set1.remove("HA");
		set1.remove("RD");
		set1.print();
		set2.print();
		equalset(set1, set2);

		set1.add("EA");
		set1.add("SY");
		set1.print();
		set2.print();
		equalset(set1, set2);

	}

	public static boolean equalset(Set set1, Set set2) {

		Object x = set1.getFirst();
		Object y = set2.getFirst();

		if (set1.size() == set2.size()) {
			for (int i = 0; i < set1.size(); i++) {
				if (x != y) {
					System.out.println("\n �ΰ�ü�� ���� �ٸ�");
					return false;
				} else {
					x = set1.getNext();
					y = set2.getNext();
				}
			}
		} else {
			System.out.println("\n �ΰ�ü�� ���� �ٸ�");
			return false;
		}

		System.out.println("\n �ΰ�ü�� ����");
		return true;
	}
	//�ΰ��� ���� ���ڰ����� �ް� �ΰ��� ���� ���� ���Ͽ� ������ �ٸ����� ����� �޼ҵ�
	//x, y�� set1�� set2 ������ ù��° ���Ҹ� getFrist()�� ȣ���Ͽ� ������
	//���� set1�� set2�� �迭�� ���̸� ���Ѵ�.
	//���̰� �ٸ��� �ΰ�ü�� ���� �ٸ��Ƿ� �ΰ�ü�� �ٸ��� ����ϰ� false�� ��ȯ.
	//���̰� ���� �����Ͽ� x�� y���� ���� �ٸ����� ���Ѵ�.
	//x, y�� �ٸ��� �ΰ�ü�� �ٸ��� ����ϰ� false ��ȯ.
	//x, y�� ������ x, y�� �� set�� getNext()�� ȣ���Ͽ� �迭�� ������ ���Ҹ� ����
	//�� ������ �迭�� ���� ����(size)��ŭ �ݺ��Ѵ�.
	//�̻� ���� �ݺ����� ��ġ�� ����, �� ��ü�� ������ ����ϰ� true�� ��ȯ
}

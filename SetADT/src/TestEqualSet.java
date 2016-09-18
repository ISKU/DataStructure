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
					System.out.println("\n 두객체가 서로 다름");
					return false;
				} else {
					x = set1.getNext();
					y = set2.getNext();
				}
			}
		} else {
			System.out.println("\n 두객체가 서로 다름");
			return false;
		}

		System.out.println("\n 두객체가 같음");
		return true;
	}
	//두개의 셋을 인자값으로 받고 두개의 셋을 서로 비교하여 같은지 다른지를 출력할 메소드
	//x, y에 set1과 set2 각각의 첫번째 원소를 getFrist()를 호출하여 저장함
	//먼저 set1과 set2의 배열의 길이를 비교한다.
	//길이가 다르면 두객체는 서로 다르므로 두객체는 다름을 출력하고 false를 반환.
	//길이가 같은 조건하에 x와 y값을 서로 다른지를 비교한다.
	//x, y가 다르면 두객체는 다름을 출력하고 false 반환.
	//x, y가 같으면 x, y에 각 set에 getNext()를 호출하여 배열의 다음번 원소를 저장
	//이 과정을 배열의 원소 개수(size)만큼 반복한다.
	//이상 없이 반복문을 마치고 나면, 두 객체가 같음을 출력하고 true를 반환
}

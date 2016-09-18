public class ArraySet implements Set {

	private Object objects[] = new Object[100];
	private int size, i;

	public boolean add(Object object) {
		if (contains(object))
			return false;
		objects[size++] = object;
		return true;
	}
	//Objects 배열에 원소를 추가하는 메소드
	//contains()를 호출하여 입력받은 원소와 배열안에 있는 원소를 비교하여 반환되는 값이 true이면
	//add는 false를 반환 (배열안에 이미 중복되는 원소가 있으므로)
	//contains()가 false를 반환했다면
	//objects에 그 원소를 집어넣고, 배열의 원소 개수를 나타낼 size를 1 증가
	//따라서 배열이 변경(원소를 추가)되었으면 add는 true를 반환함.

	public boolean contains(Object object) {
		for (i = 0; i < size; i++)
			if (objects[i] == object)
				return true;
		return false;
	}
	//인자받은 원소와 배열안에 있는 원소를 비교한다.
	//원소를 비교하여 배열안에 주어진 원소가 있으면(중복된 원소) true를 반환
	//중복된 값이 없으면 false를 반환함.

	public Object getFirst() {
		i = 0;
		return objects[i++];
	}
	//배열의 가장 첫번째 원소를 사용하기위한 메소드
	//i를 0으로 초기화하고, objects[0] 첫번째 원소를 반환후 i값을 1증가시킴

	public Object getNext() {
		return objects[i++];
	}
	//getFrist에 이어서 다음번째 원소의 값을 반환하는 메소드.

	public boolean remove(Object object) {
			if (contains(object)) {
				System.arraycopy(objects, i + 1, objects, i, size - i - 1);
				objects[--size] = null;
				return true;
			}
		return false;
	}
	//배열에 원소를 삭제하는 메소드
	//입력받은 원소값과 현재 배열에 있는 원소와 같은지를 비교하여
	//같은 원소가 있다면 arraycopy를 이용하여 그 원소의 위치를 기준으로 한칸씩 앞으로 당긴다
	//i는 배열안에 같은 원소의 위치로 기준, objects배열의 i+1에서 i까지 size-i-1 갯수만큼 복사
	//그리고 배열안에 마지막 원소자리에 null을 저장하고 size를 1감소 시킨다.
	//배열의 원소 갯수만큼(size) 반복하여 배열안의 모든 원소와 입력받은 원소를 비교한다.
	//원소가 배열안에서 삭제되면 true반환, 변경된 값이 없으면 false 반환.

	public int size() {
		return size;
	}
	//배열의 원소 개수를 나타내는 값을 반환

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
	//배열의 모든 원소와 길이를 출력하는 메소드
	//x에 getFrist()에 의해 반환된 배열의 첫번째 원소를 저장
	//x값이 null인지를 확인해서 null이면 false를 반환
	//null이 아니면 x값을 출력하고 x는 getNext()에 의애 반환된 값을 저장
	//이때 getNext()는 배열에서 다음번째 원소값을 x에 저장시키는 것.
	//이 과정을 x가 null을 만날때까지 계속 반복한다.

}

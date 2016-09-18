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
	// 입력 받은 원소를 리스트에 연결 시키는 메소드.
	// 먼저 리스트안에 입력 받은 원소와 같은 원소가 있는지 contains를 이용해 확인한다.
	// 입력 받은 원소와 같은 원소가 없다면 서로 다른 원소의 개수를 나타낼 diffsize를 1증가 시킨다.
	// getFrist()는 p가 start를 가르켜 리스트의 가장 앞에 위치 시킨다.
	// 원소를 입력 받고 나서 리스트에 아무 원소도 없다면 start가 null일 경우이고
	// 이 때 입력 받은 원소의 값을 가진 새로운 노드를 생성하고 start가 이를 가르키게 한다.
	// 리스트가 비어있지 않았다면 p를 이용하여 null을 만날때까지, 즉 리스트의 마지막 노드를 가르키고
	// 이 마지막 노드의 다음번째에 입력 받은 원소의 값을 가진 새로운 노드를 생성한고 이를 연결 한다.
	// 리스트에 연결이 성공적으로 이루어졌으면 원소의 개수를 나타낼 size를 1증가 시킨다.

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
	//리스트 안에 있는 원소와 입력받은 원소가 같을 경우 그 원소를 삭제하는 메소드.
	//p가 start를 가르키게 하여 리스트의 맨 앞에 위치시킨다. getFrist()
	//start==null, 즉 리스트가 비어있으면 false를 반환, 백이 변경되지 않음.
	//맨 처음 원소가 입력 받은 원소와 같은지를 확인하고, 같으면 원소를 삭제
	//맨 앞에서부터 차례대로  모든 원소 p.next.data를 입력받은 원소와 비교하여 같으면 삭제
	//원소의 삭제는 p.next가 p.next.next에 연결하면 중간에 있던 원소는 garbage가 됨
	//원소를 삭제하고나서 contains를 이용해 리스트안에 삭제했던 원소가 남아 있는지 확인한다.
	//같은 원소가 있다면 diffsize를 1감소, 모든 삭제 작업이 끝나면 Bag은 변경되었으므로 True를 반환.
	//입력받은 원소가 리스트안에 없었다면 bag은 변경되지 않았으므로 False를 반환한다.
	
	
	public boolean contains(Object object) {
		for (getFirst(); p != null; getNext())
			if (p.data == object)
				return true;
		return false;
	}
	//입력 받은 원소가 리스트 안에 있는지 확인하는 메소드.
	//리스트 안의 원소 처음부터 끝까지 입력받은 원소와 비교하여 같은 원소가 있으면 True 반환
	//입력받은 원소가 없으면 False 반환.

	public Node getFirst() {
		p = start;
		return p;
	}
	//p는 리스트안의 각각 노드들을 참조 할 수 있는 위치 변수이다.
	//리스트의 시작점인 start를 p가 가르키게 한다.

	public Node getNext() {
		p = p.next;
		return p;
	}
	//위치변수 p를 다음 노드로 한칸 이동 시킴.

	public int size() {
		return this.size;
	}
	//리스트안의 원소 개수를 나타내는 변수이다.

	public int diffsize() {
		return this.diffsize;
	}
	//리스트안의 중복되지 않는 서로다른 원소의 개수를 나타내는 변수이다.
	
	public void print() {
		System.out.print("\n" + size() + " " + diffsize());
		for (getFirst(); p != null; getNext())
			System.out.print(" " + p.data);
	}
	//리스트안의 모든 원소를 차례대로 출력하는 메소드.
	//size(), diffsize() 출력하고,
	//p를 start부터 null이 아닐때까지 즉 마지막 노드까지 이동시키면서 모든 원소를 출력함.

	private static class Node {

		Object data;
		Node next;

		Node(Object object) {
			this.data = object;
		}
	}
}

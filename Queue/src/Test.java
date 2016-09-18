public class Test {
	public static void main(String[] args) {

		Queue queue = new CircularQueue();

		queue.add("DE");
		queue.print();
		queue.add("PA");
		queue.print();
		queue.add("NJ");
		queue.print();

		queue.remove();
		queue.print();
		queue.remove();
		queue.print();

		queue.add("GA");
		queue.print();
		queue.add("CT");
		queue.print();

		queue.remove();
		queue.print();

		queue.add("MA");
		queue.print();
		queue.add("MD");
		queue.print();

		queue.remove();
		queue.print();
	}
}

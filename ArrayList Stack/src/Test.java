public class Test {
	public static void main(String[] args) {

		Stack stack = new ArrayStack();

		stack.push("Monday");
		stack.print();
		stack.push("Tuesday");
		stack.print();
		stack.push("Wednesday");
		stack.print();

		stack.pop();
		stack.print();
		stack.pop();
		stack.print();

		stack.push("Thursday");
		stack.print();
		stack.push("Friday");
		stack.print();

		stack.pop();
		stack.print();

		stack.push("Saturday");
		stack.print();
		stack.push("Sunday");
		stack.print();

		stack.pop();
		stack.print();
		stack.pop();
		stack.print();

	}
}

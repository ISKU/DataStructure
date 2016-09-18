
public class Test {
	public static void main(String[] args){
		
	
	
	Queue queue = new DLinkedQueue();
	
	queue.add("aaa");
	queue.print();
	queue.add("bbb");
	queue.print();

	queue.add("ccc");
	queue.print();

	queue.add("ddd");
	queue.print();

	System.out.println(queue.first());
	queue.remove();
	queue.print();

	System.out.println(queue.first());
	queue.remove();
	queue.print();
	
	}
}

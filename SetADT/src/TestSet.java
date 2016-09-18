public class TestSet {
	public static void main(String args[]) {

		Set set = new ArraySet();

		set.add("CA");
		set.add("US");
		set.add("MX");
		set.add("RU");
		set.add("US");
		set.add("MX");
		set.print();

		set.remove("CA");
		set.remove("US");
		set.remove("MX");
		set.print();
	}
}

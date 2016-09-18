public class TestBag {
	public static void main(String args[]){
		
		LinkedBag bag = new LinkedBag();
		bag.remove("ca");
		bag.add("CA");
		bag.add("US");
		bag.add("MX");
		bag.add("RU");
		bag.add("US");
		bag.add("MX");
		bag.print();

		bag.remove("CA");
		bag.remove("US");
		bag.remove("MX");
		bag.print();
		
		bag.remove("RU");
		bag.remove("US");
		bag.remove("MX");
		bag.print();
		
		bag.add("CA");
		bag.add("US");
		bag.add("MX");
		bag.add("RU");
		bag.add("US");
		bag.add("MX");
		bag.print();
		
		bag.remove("MX");
		bag.print();
		bag.remove("MX");
		bag.print();
		bag.remove("CA");
		bag.print();
	
	}
}

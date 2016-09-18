
public class TestHashTable {
	public static void main(String args[]) {

		HashTable linearHash = new HashTable(17);
		System.out.println("******************* Linear Probing");
		linearHash.put("AT", new Country("Austria", "German", 33278, 8139299));
		linearHash.put("BE", new Country("Belgium", " Dutch", 11800, 10182034));
		linearHash.put("DE", new Country("Germany", "German", 137800, 82087361));
		linearHash.put("DK", new Country("Denmark", "Danish", 16639, 5356845));
		linearHash.put("ES", new Country("Spain", "Spanish", 194880, 39167744));
		linearHash.put("FR", new Country("France", "French", 211200, 58978172));
		linearHash.put("IT", new Country("Italy", "Italian", 116300, 56735130));
		linearHash.put("LU", new Country("Luxembourg", "French", 998, 429080));
		linearHash.put("SE", new Country("Sweden", "Portuguese", 35672, 9918040));
		System.out.println("전체 충돌 횟수: " + linearHash.getCollisions() + " collisions");
		System.out.println("**********************************\n");
		
		QuadraticHashTable quadraticHash = new QuadraticHashTable(17);
		System.out.println("**************** Quadratic Probing");
		quadraticHash.put("AT", new Country("Austria", "German", 33278, 8139299));
		quadraticHash.put("BE", new Country("Belgium", " Dutch", 11800, 10182034));
		quadraticHash.put("DE", new Country("Germany", "German", 137800, 82087361));
		quadraticHash.put("DK", new Country("Denmark", "Danish", 16639, 5356845));
		quadraticHash.put("ES", new Country("Spain", "Spanish", 194880, 39167744));
		quadraticHash.put("FR", new Country("France", "French", 211200, 58978172));
		quadraticHash.put("IT", new Country("Italy", "Italian", 116300, 56735130));
		quadraticHash.put("LU", new Country("Luxembourg", "French", 998, 429080));
		quadraticHash.put("SE", new Country("Sweden", "Portuguese", 35672, 9918040));
		System.out.println("전체 충돌 횟수: " + quadraticHash.getCollisions() + " collisions");
		System.out.println("**********************************\n");
		
		DoubleHashTable doubleHash = new DoubleHashTable(17);
		System.out.println("******************* Double Hashing");
		doubleHash.put("AT", new Country("Austria", "German", 33278, 8139299));
		doubleHash.put("BE", new Country("Belgium", " Dutch", 11800, 10182034));
		doubleHash.put("DE", new Country("Germany", "German", 137800, 82087361));
		doubleHash.put("DK", new Country("Denmark", "Danish", 16639, 5356845));
		doubleHash.put("ES", new Country("Spain", "Spanish", 194880, 39167744));
		doubleHash.put("FR", new Country("France", "French", 211200, 58978172));
		doubleHash.put("IT", new Country("Italy", "Italian", 116300, 56735130));
		doubleHash.put("LU", new Country("Luxembourg", "French", 998, 429080));
		doubleHash.put("SE", new Country("Sweden", "Portuguese", 35672, 9918040));
		System.out.println("전체 충돌 횟수: " + doubleHash.getCollisions() + " collisions");
		System.out.println("**********************************\n");
	}
}

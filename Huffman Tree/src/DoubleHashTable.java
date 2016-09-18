
public class DoubleHashTable {

	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private final Entry NIL = new Entry(null, null);

	public DoubleHashTable(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}

	public DoubleHashTable(int capacity) {
		this(capacity, 0.50F);
	}

	public DoubleHashTable() {
		this(101);
	}

	public Object get(Object key) {
		int h = hash(key);
		int d = hash2(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if (entry == null)
				break;
			if (entry == NIL)
				continue;
			if (entry.key.equals(key))
				return entry.value;
		}
		return null;
	}

	public Object put(Object key, Object value) {
		if (used > loadFactor * entries.length)
			rehash();
		int h = hash(key);
		int d = hash2(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if (entry == null) {
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return null;
			}
			if (entry == NIL)
				continue;
			if (entry.key.equals(key)) {
				int oldValue = (int)entry.value;
				entries[j].value = oldValue + 1;
				return oldValue;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

	class Entry {
		Object key, value;

		Entry(Object k, Object v) {
			key = k;
			value = v;
		}
	}

	private int hash(Object key) {
		if (key == null)
			throw new IllegalArgumentException();
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;
	}

	private int hash2(Object key) {
		if (key == null)
			throw new IllegalArgumentException();
		return 1 + (key.hashCode() & 0x7FFFFFFF) % (entries.length - 1);
	}

	private int nextProbe(int h, int d, int i) {
		return (h + d * i) % entries.length;
	}

	private void rehash() {
		Entry[] oldEntries = entries;
		entries = new Entry[2 * oldEntries.length + 1];
		for (int k = 0; k < oldEntries.length; k++) {
			Entry entry = oldEntries[k];
			if (entry == null || entry == NIL)
				continue;
			int h = hash(entry.key);
			int d = hash2(entry.key);
			for (int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, d, i);
				if (entries[j] == null) {
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
	
	public void print() {
		for(int i=0; i<entries.length; i++)
			if(entries[i] != null)
				System.out.print(entries[i].key + " " + entries[i].value + "\n");
		System.out.println();
	}
	
	public Entry[] array() {
		Entry[] array = new Entry[size()];
		int count = 0;
		for(int i=0; i<entries.length; i++)
			if(entries[i] != null)
				array[count++] = entries[i];
		
		return array;
	}
}

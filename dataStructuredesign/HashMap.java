package hashtable;

class Entry<K, V> {
	K key;
	V val;
	Entry<K, V> next;

	public Entry(K key, V val) {
		this.key = key;
		this.val = val;
		this.next = null;
	}

	public Entry(K key, V val, Entry<K, V> next) {
		this.key = key;
		this.val = val;
		this.next = next;
	}
}

public class HashMap<K, V> {

	static final private float DEFAULT_LOAD_FACTOR = 0.75f;
	static final int MAXIMUM_CAPACITY = 1 << 30;

	private Entry<K, V>[] table;
	private int size;
	private int capacity = 4;
	private float loadfactor = 0.75f;

	public HashMap() {
		capacity = 4;
		size = 0;
		table = new Entry[4];
	}

	public HashMap(int c) {
		this(c, DEFAULT_LOAD_FACTOR);
	}

	public HashMap(int c, float l) {
		if (c < 0)
			throw new IllegalArgumentException("Illegal initial capacity: " + c);
		if (c > MAXIMUM_CAPACITY)
			c = MAXIMUM_CAPACITY;
		if (l <= 0 || Float.isNaN(l))
			throw new IllegalArgumentException("Illegal load factor: " + l);
		this.capacity = c;
		this.loadfactor = l;
	}

	public void put(K key, V val) {
		if (key == null)
			return;
		int hash = hash(key);
		Entry<K, V> newEntry = new Entry(key, val);
		if (table[hash] == null) {
			table[hash] = newEntry;
			size++;
		} else {
			Entry<K, V> curEntry = table[hash];
			Entry<K, V> previous = null;
			Entry<K, V> next = curEntry;

			while (curEntry != null) {
				if (curEntry.key.equals(key)) {
					newEntry.next = curEntry.next;
					if (previous == null) {
						table[hash] = newEntry;
					} else {
						previous.next = newEntry;
					}
					return;
				} else {
					previous = curEntry;
					curEntry = curEntry.next;
				}
			}
			previous.next = newEntry;
			size++;
		}
		if (this.capacity * this.loadfactor <= this.size)
			resize();
	}

	public V get(K key) {
		if (key == null)
			return null;
		int hash = hash(key);
		if (table[hash] == null)
			return null;
		Entry<K, V> curEntry = table[hash];
		while (curEntry != null && !curEntry.key.equals(key)) {
			curEntry = curEntry.next;
		}
		if (curEntry != null && curEntry.key.equals(key)) {
			return curEntry.val;
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean containsKey(K key) {
		return get(key) != null;
	}

	public boolean remove(K key) {
		if (key == null)
			return false;
		int hash = hash(key);
		Entry<K, V> previousEntry = null;
		Entry<K, V> curEntry = table[hash];
		while (curEntry != null) {
			if (curEntry.key.equals(key)) {
				if (previousEntry == null) {
					table[hash] = curEntry.next;
					return true;
				} else {
					previousEntry.next = curEntry.next;
					return true;
				}
			} else {
				previousEntry = curEntry;
				curEntry = curEntry.next;
			}
		}
		return false;

	}

	public int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public int size() {
		return this.size;
	}

	public void resize() {
		int newcapacity = this.capacity << 1;
		Entry<K, V>[] newtable = new Entry[newcapacity];
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				boolean odd = true;
				Entry<K, V> curEntry = table[i];
				Entry<K, V> newEntry = newtable[i + this.capacity];
				Entry<K, V> previous = null;
				while (curEntry != null) {
					if (odd) {
						if (newEntry == null) {
							newtable[i] = curEntry;
						} else {
							newEntry.next = curEntry;
							newEntry = newEntry.next;
						}
						previous = curEntry;
						curEntry = curEntry.next;
					} else {
						Entry<K, V> nextEntry = curEntry.next;
						if (newEntry == null) {
							newtable[i + this.capacity] = curEntry;
							previous.next = curEntry.next;
						} else {
							newEntry.next = curEntry;
							newEntry = newEntry.next;
						}
						curEntry = nextEntry;
					}
					odd = !odd;
				}
			}
		}
		this.table = newtable;
		this.capacity = newcapacity;
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(i + "   " + map.get(i));
		}

	}
}

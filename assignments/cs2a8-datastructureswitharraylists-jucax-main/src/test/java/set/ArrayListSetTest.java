package set;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListSetTest {

	// Array list has this initial capacity 
	private static final int ARRAYLISTSET_DEFAULT_CAPACITY = 10;

	// There are several sets for different data types
	public ArrayListSet<Integer> set;
	public ArrayListSet<Double> smallSet;
	public ArrayListSet<Integer> emptySet;
	public ArrayListSet<String> stringSet;

	/**
	 * Reinitialize set contents before each test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		set = new ArrayListSet<Integer>();
		set.add(4);
		set.add(2);
		set.add(5);
		set.add(100);
		set.add(-30);
		set.add(-10);

		emptySet = new ArrayListSet<Integer>();

		smallSet = new ArrayListSet<Double>(4);
		smallSet.add(4.0);
		smallSet.add(-100.34);
		smallSet.add(0.000034);
		smallSet.add(4.5);

		stringSet = new ArrayListSet<String>(); 
        stringSet.add("Alice");
        stringSet.add("Bob");
        stringSet.add("Charlie");
        stringSet.add("Diana");
        stringSet.add("Evan");
	}

	/**
	 * This is provided for you, but it shows how you can verify that the constructor works
	 */
	@Test
	void testArrayListSet() {
		ArrayListSet<Integer> defaultSet = new ArrayListSet<>(); // Capacity should be 10
		for(int i = 0; i < ARRAYLISTSET_DEFAULT_CAPACITY; i++) {
			assertTrue(defaultSet.add(i));
		}
		for(int i = 0; i < ARRAYLISTSET_DEFAULT_CAPACITY; i++) {
			assertTrue(defaultSet.contains(i));
		}
		assertFalse(defaultSet.add(5)); // No repetitions
		assertTrue(defaultSet.add(10)); // Set is full, but resize automatically
	}

	/**
	 * This is provided for you, but it shows how you can verify that the constructor works
	 */
	@Test
	void testArrayListSetInt() {
		int capacity = 46;
		ArrayListSet<Integer> defaultSet = new ArrayListSet<>(capacity); 
		for(int i = 0; i < capacity; i++) {
			assertTrue(defaultSet.add(i));
		}
		for(int i = 0; i < capacity; i++) {
			assertTrue(defaultSet.contains(i));
		}
		assertFalse(defaultSet.add(10)); // No repetitions
		assertTrue(defaultSet.add(100)); // Set is full, but resize automatically
	}

	@Test
	void testGetCurrentSize() {
		assertEquals(6, set.getCurrentSize());
		assertEquals(0, emptySet.getCurrentSize());
		assertEquals(4, smallSet.getCurrentSize()); // Test for smallSet
        assertEquals(5, stringSet.getCurrentSize()); // Test for stringSet
	}

	@Test
	void testIsEmpty() {
		assertTrue(emptySet.isEmpty());
		assertFalse(set.isEmpty());
		assertFalse(smallSet.isEmpty()); // Test for smallSet
        assertFalse(stringSet.isEmpty()); // Test for stringSet
	}

	@Test
	void testAdd() {
		assertTrue(set.add(77));
		assertTrue(set.contains(77));

		assertTrue(smallSet.add(1.0)); // Auto resize
		assertTrue(smallSet.contains(1.0));
		
		assertTrue(stringSet.add("Frank"));
		assertTrue(stringSet.contains("Frank"));

		// Fill set to capacity: 10 is the private DEFAULT_CAPACITY in ArraySet
		for(int i = 0; i < ARRAYLISTSET_DEFAULT_CAPACITY; i++) {
			assertTrue(emptySet.add(i));
		}
		assertTrue(emptySet.contains(9));
		
		assertFalse(emptySet.add(9)); // No repetitions allowed
		assertTrue(emptySet.add(100)); // Set is full, but resize automatically
	}

	@Test
	void testRemove() {
		// Because set contains Integers instead of primitive ints, must specify values with the syntax below
		assertEquals(Integer.valueOf(-10), set.remove());
		assertEquals(Integer.valueOf(-30), set.remove());
		assertEquals(Integer.valueOf(100), set.remove());
		assertEquals(Integer.valueOf(5), set.remove());
		assertEquals(Integer.valueOf(2), set.remove());
		assertEquals(Integer.valueOf(4), set.remove());
		assertEquals(null, set.remove()); // When removing from an empty set

		assertEquals(null, emptySet.remove()); // Already empty

		assertEquals(Double.valueOf(4.5), smallSet.remove()); // Tests for smallSet
        assertEquals(Double.valueOf(0.000034), smallSet.remove());
        assertEquals(Double.valueOf(-100.34), smallSet.remove());
        assertEquals(Double.valueOf(4.0), smallSet.remove());
        assertEquals(null, smallSet.remove());

		assertEquals("Evan", stringSet.remove()); // Tests for stringSet
        assertEquals("Diana", stringSet.remove());
        assertEquals("Charlie", stringSet.remove());
        assertEquals("Bob", stringSet.remove());
        assertEquals("Alice", stringSet.remove());
        assertEquals(null, stringSet.remove());
	}

	@Test
	void testRemoveT() {
		assertTrue(set.remove(2));
		assertFalse(set.remove(2));
		assertTrue(set.remove(-10));
		assertFalse(set.remove(-10));
		assertTrue(set.remove(-30));
		assertFalse(set.remove(-30));
		assertFalse(set.remove(34));
		assertTrue(set.remove(100));
		assertFalse(set.remove(100));
		assertTrue(set.remove(5));
		assertFalse(set.remove(5));
		assertTrue(set.remove(4));
		assertFalse(set.remove(4)); // Was in the set, but not anymore
		assertFalse(set.remove(345)); // Was never in the set

		assertFalse(emptySet.remove(32));

        assertTrue(smallSet.remove(4.0)); // Tests for smallSet
		assertFalse(smallSet.remove(4.0)); // Already removed
        assertFalse(smallSet.remove(1.1)); 
		assertTrue(smallSet.remove(-100.34));
		assertFalse(smallSet.remove(-100.34)); 
		assertTrue(smallSet.remove(0.000034));
		assertFalse(smallSet.remove(0.000034)); 
		assertTrue(smallSet.remove(4.5));
		assertFalse(smallSet.remove(4.5));
		assertFalse(smallSet.remove(-100.34)); // Was in the set, but not anymore
		assertFalse(set.remove(345)); // Was never in the set

		assertTrue(stringSet.remove("Alice")); // Tests for stringSet
        assertFalse(stringSet.remove("Alice")); // Already removed
        assertTrue(stringSet.remove("Bob"));
		assertFalse(stringSet.remove("Bob"));
		assertTrue(stringSet.remove("Charlie"));
		assertFalse(stringSet.remove("Charlie"));
		assertFalse(stringSet.remove("Anne"));
		assertTrue(stringSet.remove("Diana"));
		assertFalse(stringSet.remove("Diana"));
		assertTrue(stringSet.remove("Evan"));
		assertFalse(stringSet.remove("Evan"));
		assertFalse(stringSet.remove("Bob")); // Was in the set, but not anymore
        assertFalse(stringSet.remove("Zach")); // Was never in the set
	}

	@Test
	void testClear() {
		assertFalse(set.isEmpty());
		set.clear();
		assertTrue(set.isEmpty());

		assertTrue(emptySet.isEmpty());
		emptySet.clear();
		assertTrue(emptySet.isEmpty());

		assertFalse(smallSet.isEmpty()); // Test for smallSet
        smallSet.clear();
        assertTrue(smallSet.isEmpty());

        assertFalse(stringSet.isEmpty()); // Test for stringSet
        stringSet.clear();
        assertTrue(stringSet.isEmpty());
	}

	@Test
	void testContains() {
		assertTrue(set.contains(-10));
		assertTrue(set.contains(2));
		assertTrue(set.contains(100));
		assertTrue(set.contains(-30));
		assertTrue(set.contains(5));
		assertTrue(set.contains(4));
		assertFalse(set.contains(46));
		assertFalse(set.contains(4345));

		assertFalse(emptySet.contains(46));

		assertTrue(smallSet.contains(4.0)); // Tests for smallSet
		assertTrue(smallSet.contains(-100.34));
		assertTrue(smallSet.contains(0.000034));
		assertTrue(smallSet.contains(4.5));
        assertFalse(smallSet.contains(1.1));
		assertFalse(smallSet.contains(-734.86));

        assertTrue(stringSet.contains("Alice")); // Tests for stringSet
		assertTrue(stringSet.contains("Bob"));
		assertTrue(stringSet.contains("Charlie"));
		assertTrue(stringSet.contains("Diana"));
		assertTrue(stringSet.contains("Evan"));
        assertFalse(stringSet.contains("Zach"));
	}

	@Test
	void testToArray() {
		Object[] result1 = set.toArray();
		assertArrayEquals(new Integer[] {4,2,5,100,-30,-10}, result1);

		Object[] result2 = emptySet.toArray();
		assertArrayEquals(new Integer[0], result2);

		Object[] result3 = smallSet.toArray(); // Tests for smallSet
        assertArrayEquals(new Double[] {4.0, -100.34, 0.000034, 4.5}, result3);

        Object[] result4 = stringSet.toArray(); // Tests for stringSet
        assertArrayEquals(new String[] {"Alice", "Bob", "Charlie", "Diana", "Evan"},result4);
	}

}
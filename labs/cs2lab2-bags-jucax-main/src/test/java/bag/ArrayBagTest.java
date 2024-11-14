package bag;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the ArrayBag class
 * from our text book. You will need to
 * write additional tests. Note that
 * several of these tests depend on specific
 * underlying implementation details of
 * the ArrayBag (certain tests would not
 * apply for other bag implementations).
 *
 * @author Jacob Schrum
 */
class ArrayBagTest {

	// Make sure your ArrayBag has this same restriction
	private static final int ARRAYBAG_DEFAULT_CAPACITY = 25;

	// There are several bags for different data types
	public ArrayBag<Integer> bag;
	public ArrayBag<Double> smallBag;
	public ArrayBag<Integer> emptyBag;
	public ArrayBag<String> stringBag;

	/**
	 * Reinitialize bag contents before each test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		bag = new ArrayBag<Integer>();
		bag.add(4);
		bag.add(2);
		bag.add(2);
		bag.add(4);
		bag.add(5);
		bag.add(100);
		bag.add(-30);
		bag.add(-10);
		bag.add(-10);

		emptyBag = new ArrayBag<Integer>();

		smallBag = new ArrayBag<Double>(4);
		smallBag.add(4.0);
		smallBag.add(-100.34);
		smallBag.add(0.000034);
		smallBag.add(4.0);

		//TODO: Add initialization for stringBag.
		//      Fill it with interesting data.		
	}

	/**
	 * This is provided for you, but it shows how you can verify that the constructor works
	 */
	@Test
	void testArrayBag() {
		ArrayBag<Integer> defaultBag = new ArrayBag<>(); // Capacity should be 25
		for(int i = 0; i < ARRAYBAG_DEFAULT_CAPACITY; i++) {
			assertTrue(defaultBag.add(9));
		}
		assertFalse(defaultBag.add(10)); // Bag is full
	}

	/**
	 * This is provided for you, but it shows how you can verify that the constructor works
	 */
	@Test
	void testArrayBagInt() {
		int capacity = 46;
		ArrayBag<Integer> defaultBag = new ArrayBag<>(capacity); 
		for(int i = 0; i < capacity; i++) {
			assertTrue(defaultBag.add(9));
		}
		assertFalse(defaultBag.add(10)); // Bag is full
	}

	@Test
	void testGetCurrentSize() {
		assertEquals(9, bag.getCurrentSize());
		assertEquals(0, emptyBag.getCurrentSize());
		// TODO: Test for smallBag
		// TODO: Test for stringBag
	}

	@Test
	void testIsEmpty() {
		assertTrue(emptyBag.isEmpty());
		assertFalse(bag.isEmpty());
		// TODO: Test for smallBag
		// TODO: Test for stringBag
	}

	@Test
	void testAdd() {
		assertTrue(bag.add(77));
		assertTrue(bag.contains(77));
		// TODO: Test for smallBag: Won't be able to add
		// TODO: Test for stringBag

		// Fill bag to capacity: 25 is the private DEFAULT_CAPACITY in ArrayBag
		for(int i = 0; i < ARRAYBAG_DEFAULT_CAPACITY; i++) {
			assertTrue(emptyBag.add(9));
		}
		assertTrue(emptyBag.contains(9));
		// No more additions allowed
		assertFalse(emptyBag.add(9));
	}

	@Test
	void testRemove() {
		// Because bag contains Integers instead of primitive ints, must specify values with the syntax below
		assertEquals(Integer.valueOf(-10), bag.remove());
		assertEquals(Integer.valueOf(-10), bag.remove());
		assertEquals(Integer.valueOf(-30), bag.remove());
		assertEquals(Integer.valueOf(100), bag.remove());
		assertEquals(Integer.valueOf(5), bag.remove());
		assertEquals(Integer.valueOf(4), bag.remove());
		assertEquals(Integer.valueOf(2), bag.remove());
		assertEquals(Integer.valueOf(2), bag.remove());
		assertEquals(Integer.valueOf(4), bag.remove());
		assertEquals(null, bag.remove()); // When removing from an empty bag

		assertEquals(null, emptyBag.remove()); // Already empty

		// TODO: Add similar tests for smallBag. Specify values with Double.valueOf
		// TODO: Add similar tests for stringBag. Specify values as String literals in double quotes
	}

	@Test
	void testRemoveT() {
		assertTrue(bag.remove(2));
		assertTrue(bag.remove(2));
		assertFalse(bag.remove(2));
		assertTrue(bag.remove(-10));
		assertTrue(bag.remove(-10));
		assertFalse(bag.remove(-10));
		assertTrue(bag.remove(-30));
		assertFalse(bag.remove(-30));
		assertFalse(bag.remove(34));
		assertTrue(bag.remove(100));
		assertFalse(bag.remove(100));
		assertTrue(bag.remove(5));
		assertFalse(bag.remove(5));
		assertTrue(bag.remove(4));
		assertTrue(bag.remove(4));
		assertFalse(bag.remove(4)); // Was in the bag, but not anymore
		assertFalse(bag.remove(345)); // Was never in the bag

		assertFalse(emptyBag.remove(32));

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}

	@Test
	void testClear() {
		assertFalse(bag.isEmpty());
		bag.clear();
		assertTrue(bag.isEmpty());

		assertTrue(emptyBag.isEmpty());
		emptyBag.clear();
		assertTrue(emptyBag.isEmpty());

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}

	@Test
	void testGetFrequencyOf() {
		assertEquals(2, bag.getFrequencyOf(-10));
		assertEquals(2, bag.getFrequencyOf(2));
		assertEquals(1, bag.getFrequencyOf(100));
		assertEquals(1, bag.getFrequencyOf(-30));
		assertEquals(1, bag.getFrequencyOf(5));
		assertEquals(2, bag.getFrequencyOf(4));
		assertEquals(0, bag.getFrequencyOf(534));

		assertEquals(0, emptyBag.getFrequencyOf(4));

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}

	@Test
	void testContains() {
		assertTrue(bag.contains(-10));
		assertTrue(bag.contains(2));
		assertTrue(bag.contains(100));
		assertTrue(bag.contains(-30));
		assertTrue(bag.contains(5));
		assertTrue(bag.contains(4));
		assertFalse(bag.contains(46));
		assertFalse(bag.contains(4345));

		assertFalse(emptyBag.contains(46));

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}

	@Test
	void testToArray() {
		Object[] result1 = bag.toArray();
		assertArrayEquals(new Integer[] {4,2,2,4,5,100,-30,-10,-10}, result1);

		Object[] result2 = emptyBag.toArray();
		assertArrayEquals(new Integer[0], result2);

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}

}
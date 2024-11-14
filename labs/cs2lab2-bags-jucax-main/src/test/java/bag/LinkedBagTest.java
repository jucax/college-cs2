package bag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedBagTest {

	// This is just to compare with the ArrayBag. The
	// tests demonstrate how the LinkedBag does not
	// have any such restriction.
	private static final int ARRAYBAG_DEFAULT_CAPACITY = 25;

	// There are several bags for different data types
	public LinkedBag<Integer> bag;
	public LinkedBag<Double> smallBag;
	public LinkedBag<Integer> emptyBag;
	public LinkedBag<String> stringBag;

	/**
	 * Reinitialize bag contents before each test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		bag = new LinkedBag<Integer>();
		bag.add(4);
		bag.add(2);
		bag.add(2);
		bag.add(4);
		bag.add(5);
		bag.add(100);
		bag.add(-30);
		bag.add(-10);
		bag.add(-10);

		emptyBag = new LinkedBag<Integer>();

		smallBag = new LinkedBag<Double>();
		smallBag.add(4.0);
		smallBag.add(-100.34);
		smallBag.add(0.000034);
		smallBag.add(4.0);

		//TODO: Add initialization for stringBag.
		//      Fill it with interesting data.		
	}

	@Test
	void testLinkedBag() {
		LinkedBag<Integer> defaultBag = new LinkedBag<>(); // Unlimited capacity
		for(int i = 0; i < ARRAYBAG_DEFAULT_CAPACITY; i++) {
			assertTrue(defaultBag.add(9));
		}
		// Add successfully beyond limit of fixed-length ArrayBag
		assertTrue(defaultBag.add(10)); 
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
		// TODO: Test for smallBag
		// TODO: Test for stringBag

		// Fill up to the capacity of the ArrayBag, 
		// but then surpass it in the following step
		// to show how the LinkedBag differs.
		for(int i = 0; i < ARRAYBAG_DEFAULT_CAPACITY; i++) {
			assertTrue(emptyBag.add(9));
		}
		assertTrue(emptyBag.contains(9));
		// LinkedBag does not have a restriction on the size
		assertTrue(emptyBag.add(9));
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
		assertArrayEquals(new Integer[] {-10,-10,-30,100,5,4,2,2,4}, result1);

		Object[] result2 = emptyBag.toArray();
		assertArrayEquals(new Integer[0], result2);

		// TODO: Add similar tests for smallBag.
		// TODO: Add similar tests for stringBag.
	}
}

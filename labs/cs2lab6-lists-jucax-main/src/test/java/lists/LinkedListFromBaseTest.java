package lists;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListFromBaseTest {
	// Note that these are from list.LinkedList
	// and are not the standard Java LinkedList
	LinkedListFromBase<Integer> intList;
	LinkedListFromBase<Integer> smallIntList;

	@BeforeEach
	void setUp() throws Exception {
		intList = new LinkedListFromBase<>();
		intList.add(77);
		intList.add(-324);
		intList.add(9934);
		intList.add(0);
		intList.add(1234);
		intList.add(9);

		smallIntList = new LinkedListFromBase<>();
		smallIntList.add(9);
	}

	@Test
	void testLinkedListFromBase() {
		LinkedListFromBase<Integer> temp = new LinkedListFromBase<>();
		assertTrue(temp.isEmpty());
		assertEquals(0, temp.getLength());
	}

	@Test
	void testAddT() {
		intList.add(20);
		assertEquals(7, intList.getLength());
		assertEquals(Integer.valueOf(20), intList.getEntry(6));
		intList.add(50);
		assertEquals(8, intList.getLength());
		assertEquals(Integer.valueOf(50), intList.getEntry(7));
		intList.add(1);
		assertEquals(9, intList.getLength());
		assertEquals(Integer.valueOf(1), intList.getEntry(8));
	}

	@Test
	void testAddIntT() {
		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.add(-1, 9);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.add(7, 213);
		});		

		intList.add(0,-10); // Add to start
		intList.add(7,999); // Add to end
		intList.add(4,1000); // Add to middle

		assertEquals(Integer.valueOf(-10), intList.getEntry(0));
		assertEquals(Integer.valueOf(77), intList.getEntry(1));
		assertEquals(Integer.valueOf(-324), intList.getEntry(2));
		assertEquals(Integer.valueOf(9934), intList.getEntry(3));
		assertEquals(Integer.valueOf(1000), intList.getEntry(4));
		assertEquals(Integer.valueOf(0), intList.getEntry(5));
		assertEquals(Integer.valueOf(1234), intList.getEntry(6));
		assertEquals(Integer.valueOf(9), intList.getEntry(7));
		assertEquals(Integer.valueOf(999), intList.getEntry(8));

		assertEquals(9, intList.getLength());
	}

	@Test
	void testRemove() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.remove(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.remove(6);
		});		

		assertEquals(Integer.valueOf(77), intList.remove(0)); // Remove to start
		assertEquals(Integer.valueOf(9), intList.remove(4)); // Remove to end
		assertEquals(Integer.valueOf(0), intList.remove(2)); // Remove to middle

		assertEquals(Integer.valueOf(-324), intList.getEntry(0));
		assertEquals(Integer.valueOf(9934), intList.getEntry(1));
		assertEquals(Integer.valueOf(1234), intList.getEntry(2));

		assertEquals(3, intList.getLength());
	}

	@Test
	void testClear() {
		assertFalse(intList.isEmpty());
		intList.clear();
		assertTrue(intList.isEmpty());

		assertFalse(smallIntList.isEmpty());
		smallIntList.clear();
		assertTrue(smallIntList.isEmpty());
	}

	@Test
	void testReplace() {
		assertEquals(Integer.valueOf(77), intList.replace(0, 78));
		assertEquals(Integer.valueOf(-324), intList.replace(1, -12));
		assertEquals(Integer.valueOf(9934), intList.replace(2, 3342));
		assertEquals(Integer.valueOf(0), intList.replace(3, -21));
		assertEquals(Integer.valueOf(1234), intList.replace(4, 0));
		assertEquals(Integer.valueOf(9), intList.replace(5, 4232));

		// Make sure the values changed
		assertEquals(Integer.valueOf(78), intList.replace(0, 55));
		assertEquals(Integer.valueOf(-12), intList.replace(1, 55));
		assertEquals(Integer.valueOf(3342), intList.replace(2, 55));
		assertEquals(Integer.valueOf(-21), intList.replace(3, 55));
		assertEquals(Integer.valueOf(0), intList.replace(4, 55));
		assertEquals(Integer.valueOf(4232), intList.replace(5, 55));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.replace(-1, 9);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.replace(6, 213);
		});
	}

	@Test
	void testGetEntry() {
		assertEquals(Integer.valueOf(77), intList.getEntry(0));
		assertEquals(Integer.valueOf(-324), intList.getEntry(1));
		assertEquals(Integer.valueOf(9934), intList.getEntry(2));
		assertEquals(Integer.valueOf(0), intList.getEntry(3));
		assertEquals(Integer.valueOf(1234), intList.getEntry(4));
		assertEquals(Integer.valueOf(9), intList.getEntry(5));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.getEntry(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.getEntry(6);
		});
	}

	@Test
	void testToArray() {
		Object[] result1 = intList.toArray();
		assertArrayEquals(new Integer[] {77,-324,9934,0,1234,9}, result1);

		Object[] result2 = smallIntList.toArray();
		assertArrayEquals(new Integer[] {9}, result2);
	}

	@Test
	void testContains() {
		assertTrue(intList.contains(77));
		assertTrue(intList.contains(-324));
		assertTrue(intList.contains(9934));
		assertTrue(intList.contains(0));
		assertTrue(intList.contains(1234));
		assertTrue(intList.contains(9));

		assertFalse(intList.contains(1));

		assertTrue(smallIntList.contains(9));

		assertFalse(smallIntList.contains(0));
	}

	@Test
	void testGetLength() {
		assertEquals(6, intList.getLength());
		intList.remove(0);
		intList.remove(1);
		intList.remove(2);
		assertEquals(3, intList.getLength());

		assertEquals(1, smallIntList.getLength());
		smallIntList.remove(0);
		assertEquals(0, smallIntList.getLength());
	}

	@Test
	void testIsEmpty() {
		assertFalse(intList.isEmpty());
		intList.clear();
		assertTrue(intList.isEmpty());
		
		assertFalse(smallIntList.isEmpty());
		smallIntList.clear();
		assertTrue(smallIntList.isEmpty());
	}
}

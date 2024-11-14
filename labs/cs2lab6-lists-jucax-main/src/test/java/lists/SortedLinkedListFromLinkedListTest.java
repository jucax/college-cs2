package lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedLinkedListFromLinkedListTest {

	SortedLinkedListFromLinkedList<Integer> intList;

	@BeforeEach
	void setUp() throws Exception {
		intList = new SortedLinkedListFromLinkedList<Integer>();
		intList.add(100);
		intList.add(5);
		intList.add(0);
		intList.add(50);
		intList.add(27);
		intList.add(9000);
		intList.add(18);
	}

	@Test
	void testSortedLinkedListFromLinkedList() {
		SortedLinkedListFromLinkedList<Integer> temp = new SortedLinkedListFromLinkedList<>();
		assertTrue(temp.isEmpty());
		assertEquals(0, temp.getLength());
	}

	@Test
	void testAdd() {
		intList.add(20);
		assertEquals(8, intList.getLength());
		assertEquals(Integer.valueOf(20), intList.getEntry(3));
		intList.add(50);
		assertEquals(9, intList.getLength());
		assertEquals(Integer.valueOf(50), intList.getEntry(6));
		intList.add(1);
		assertEquals(10, intList.getLength());
		assertEquals(Integer.valueOf(1), intList.getEntry(1));
	}

	@Test
	void testRemoveT() {
		assertFalse(intList.remove(Integer.valueOf(20)));
		assertFalse(intList.remove(Integer.valueOf(55)));
		assertFalse(intList.remove(Integer.valueOf(-10)));
		
		assertTrue(intList.remove(Integer.valueOf(5))); // Remove to start
		assertTrue(intList.remove(Integer.valueOf(50))); // Remove to end
		assertTrue(intList.remove(Integer.valueOf(9000))); // Remove to middle

		assertEquals(Integer.valueOf(0), intList.getEntry(0));
		assertEquals(Integer.valueOf(18), intList.getEntry(1));
		assertEquals(Integer.valueOf(27), intList.getEntry(2));

		assertEquals(4, intList.getLength());
	}

	@Test
	void testGetPosition() {
		assertEquals(-1, intList.getPosition(-10));
		assertEquals(0, intList.getPosition(0));
		assertEquals(-1, intList.getPosition(3));
		assertEquals(1, intList.getPosition(5));
		assertEquals(-1, intList.getPosition(6));
		assertEquals(2, intList.getPosition(18));
		assertEquals(-1, intList.getPosition(26));
		assertEquals(3, intList.getPosition(27));
		assertEquals(-1, intList.getPosition(30));
		assertEquals(4, intList.getPosition(50));
		assertEquals(-1, intList.getPosition(80));
		assertEquals(5, intList.getPosition(100));
		assertEquals(-1, intList.getPosition(763));
		assertEquals(6, intList.getPosition(9000));
		assertEquals(-1, intList.getPosition(9001));
	}

	@Test
	void testGetEntry() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.getEntry(-1);
		});

		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.getEntry(7);
		});

		assertEquals(Integer.valueOf(0), intList.getEntry(0));
		assertEquals(Integer.valueOf(5), intList.getEntry(1));
		assertEquals(Integer.valueOf(18), intList.getEntry(2));
		assertEquals(Integer.valueOf(27), intList.getEntry(3));
		assertEquals(Integer.valueOf(50), intList.getEntry(4));
		assertEquals(Integer.valueOf(100), intList.getEntry(5));
		assertEquals(Integer.valueOf(9000), intList.getEntry(6));
	}

	@Test
	void testContains() {
		assertTrue(intList.contains(100));
		assertTrue(intList.contains(5));
		assertTrue(intList.contains(0));
		assertTrue(intList.contains(50));
		assertTrue(intList.contains(27));
		assertTrue(intList.contains(9000));
		assertTrue(intList.contains(18));
	}

	@Test
	void testRemoveInt() {	
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.remove(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.remove(10);
		});		

		assertEquals(Integer.valueOf(0), intList.remove(0)); // Remove to start
		assertEquals(Integer.valueOf(100), intList.remove(4)); // Remove to end
		assertEquals(Integer.valueOf(27), intList.remove(2)); // Remove to middle

		assertEquals(Integer.valueOf(5), intList.getEntry(0));
		assertEquals(Integer.valueOf(18), intList.getEntry(1));
		assertEquals(Integer.valueOf(50), intList.getEntry(2));

		assertEquals(4, intList.getLength());
	}

	@Test
	void testClear() {
		assertFalse(intList.isEmpty());
		intList.clear();
		assertTrue(intList.isEmpty());
	}

	@Test
	void testGetLength() {
		assertEquals(7, intList.getLength());
		intList.remove(0);
		intList.remove(1);
		intList.remove(2);
		assertEquals(4, intList.getLength());
	}

	@Test
	void testIsEmpty() {
		assertFalse(intList.isEmpty());
		intList.clear();
		assertTrue(intList.isEmpty());
	}
}
